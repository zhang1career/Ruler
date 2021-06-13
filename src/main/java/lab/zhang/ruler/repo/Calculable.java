package lab.zhang.ruler.repo;

import java.util.List;

/**
 * @author zhangrj
 */
public interface Calculable<T> {
    /**
     * Calculate
     * @param operands values to be calculated
     * @return result
     */
    Valuable<T> calc(List<? extends Valuable<T>> operands);
}
