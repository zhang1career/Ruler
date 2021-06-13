package lab.zhang.ruler.model;

import lab.zhang.ruler.model.operators.CardinalityType;
import lab.zhang.ruler.model.operators.OperatorType;
import lab.zhang.ruler.repo.Valuable;
import lab.zhang.ruler.repo.Calculable;
import lab.zhang.ruler.utils.CacheUtil;
import org.ehcache.Cache;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

import java.util.List;

/**
 * @author zhangrj
 */
abstract public class Operator<T> implements Calculable<T> {
    /**
     * cache
     */
    protected static Cache<Integer, Operator> operatorCache;

    static {
        operatorCache = CacheUtil.cacheManager.createCache(
                "OPERATOR",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(
                        Integer.class,
                        Operator.class,
                        ResourcePoolsBuilder.heap(256)
                ).build()
        );
    }

    protected String name;
    protected OperatorType operatorType;
    protected CardinalityType cardType;

    public Operator(String name, OperatorType operatorType, CardinalityType cardType) {
        this.name = name;
        this.operatorType = operatorType;
        this.cardType = cardType;
    }


    /**
     * Calculate with operands
     * @param operands the items to be calculated.
     * @return result
     */
    @Override
    abstract public Valuable<T> calc(List<? extends Valuable<T>> operands);

    @Override
    public int hashCode() {
        return operatorType.getValue();
    }
}
