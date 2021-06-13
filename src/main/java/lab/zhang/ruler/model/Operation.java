package lab.zhang.ruler.model;

import lab.zhang.ruler.repo.Calculable;
import lab.zhang.ruler.repo.ComparableValuable;
import lab.zhang.ruler.repo.Valuable;
import lab.zhang.ruler.utils.CacheUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ehcache.Cache;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author zhangrj
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operation<T> implements ComparableValuable<T>, Calculable<T> {
    /**
     * cache
     */
    protected static Cache<Integer, Operation> operationCache;

    protected static Cache<Integer, Object> resultCache;

    static {
        operationCache = CacheUtil.cacheManager.createCache(
                "OPERATION",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(
                        Integer.class,
                        Operation.class,
                        ResourcePoolsBuilder.heap(1024)
                ).build()
        );

        resultCache = CacheUtil.cacheManager.createCache(
                "RESULT",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(
                        Integer.class,
                        Object.class,
                        ResourcePoolsBuilder.heap(1024)
                ).build()
        );
    }

    private static final int HASH_MASK = 0x96A55A69;
    private static final int PRIME = 997;
    private static final int OFFSET = 7;

    public static <T> T evaluate(@NotNull Operation<T> operation) {
        return operation.getValue();
    }


    protected int id;

    protected Operator<T> operator;

    protected List<? extends Valuable<T>> operands;


    @Override
    public T getValue() {
        if (resultCache.containsKey(id)) {
            return (T) resultCache.get(id);
        }

        T result = calc(operands).getValue();
        resultCache.put(id, result);

        return result;
    }

    @Override
    public Valuable<T> calc(List<? extends Valuable<T>> operands) {
        if (operator == null || operands == null) {
            return null;
        }
        return operator.calc(operands);
    }

    @Override
    public int compareTo(@NotNull Valuable<T> o) {
        if (!(o instanceof Operation)) {
            return 1;
        }
        int thisHashCode = this.hashCode();
        int thatHashCode = o.hashCode();
        return Integer.compare(thisHashCode, thatHashCode);
    }

    @Override
    public int hashCode() {
        return hash(operator, operands);
    }

    public boolean isLeaf() {
        if (operands == null) {
            return true;
        }
        for (Valuable<T> operand : operands) {
            if (operand instanceof Operation) {
                return false;
            }
        }
        return true;
    }

    protected static <T> int hash(@NotNull Operator<T> operator, List<? extends Valuable<T>> operands) {
        int ret = HASH_MASK ^ operator.hashCode();
        if (operands == null) {
            return ret;
        }
        for (int i = 0; i < operands.size(); i++) {
            int hash = operands.get(i).hashCode();
            ret += (PRIME + OFFSET * i) * hash;
        }

        return ret;
    }
}
