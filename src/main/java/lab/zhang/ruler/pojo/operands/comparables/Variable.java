package lab.zhang.ruler.pojo.operands.comparables;

import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.operands.ComparableOperand;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangrj
 */
abstract public class Variable<T> extends ComparableOperand<T, String> {
    public Variable(String value) {
        super(value);
    }

    @Override
    public T getValue(@NotNull IndexContext indexContext) {
        T ret = indexContext.getIndex(value);
        if (ret == null) {
            throw new RuntimeException("An index cannot get value");
        }
        return ret;
    }
}
