package lab.zhang.ruler.pojo.operands.comparables;

import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.operands.ComparableOperand;

/**
 * @author zhangrj
 */
abstract public class Instant<T> extends ComparableOperand<T, T> {

    public Instant(T value) {
        super(value);
    }

    @Override
    public T getValue(IndexContext indexContext) {
        return value;
    }
}
