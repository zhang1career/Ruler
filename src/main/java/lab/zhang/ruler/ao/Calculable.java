package lab.zhang.ruler.ao;

import lab.zhang.ruler.pojo.IndexContext;

import java.util.List;

/**
 * @param <R> The return type
 * @param <V> The parameters type
 * @author zhangrj
 */
public interface Calculable<R, V> {
    /**
     * Calculate
     *
     * @param operands values to be calculated
     * @return result
     */
    Valuable<R> calc(List<? extends Valuable<V>> operands, IndexContext indexContext);
}
