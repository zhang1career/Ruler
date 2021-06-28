package lab.zhang.ruler.pojo;

import lab.zhang.ruler.bo.Calculable;
import lab.zhang.ruler.bo.ComparableValuable;
import lab.zhang.ruler.bo.Valuable;
import lab.zhang.ruler.util.CacheUtil;
import lab.zhang.ruler.util.HashUtil;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author zhangrj
 */
@Getter
@Setter
public class Operation<R, V> implements ComparableValuable<R>, Calculable<R, V> {
    private static final int HASH_MASK = 0x96A55A69;

    @NotNull
    public static <R, T> Operation<R, T> getInstance(Operator<R, T> operator, List<? extends Valuable<T>> operands) {
        int uuid = hash(operator, operands);
        Operation<R, T> operation = CacheUtil.getOperation(uuid);
        if (operation == null) {
            operation = new Operation<>(operator, operands);
            CacheUtil.setOperation(uuid, operation);
        }
        return operation;
    }

    private static <R, V> int hash(Operator<R, V> operator, List<? extends Valuable<V>> operands) {
        return HashUtil.hash(operator, operands, HASH_MASK);
    }


    protected Operator<R, V> operator;

    protected List<? extends Valuable<V>> operands;

    protected int uuid;

    boolean cacheOn = false;


    public Operation(Operator<R, V> operator, List<? extends Valuable<V>> operands) {
        this.operator = operator;
        this.operands = operands;
        this.uuid = hash(operator, operands);
    }

    @Override
    public R getValue(IndexContext indexContext) {
        Valuable<R> result = calc(operands, indexContext);
        return result.getValue(indexContext);
    }

    @Override
    public Valuable<R> calc(List<? extends Valuable<V>> operands, IndexContext indexContext) {
        if (operator == null || operands == null) {
            return null;
        }
        return operator.calc(operands, indexContext);
    }

    @Override
    public int compareTo(@NotNull Valuable<R> o) {
        if (!(o instanceof Operation)) {
            return 1;
        }
        int thisHashCode = this.hashCode();
        int thatHashCode = o.hashCode();
        return Integer.compare(thisHashCode, thatHashCode);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Operation)) {
            return false;
        }

        Operation<?, ?> op = (Operation<?, ?>) obj;
        return uuid == op.uuid;
    }

    @Override
    public int hashCode() {
        return hash(operator, operands);
    }

    public boolean isLeaf() {
        if (operands == null) {
            return true;
        }
        for (Valuable<V> operand : operands) {
            if (operand instanceof Operation) {
                return false;
            }
        }
        return true;
    }
}
