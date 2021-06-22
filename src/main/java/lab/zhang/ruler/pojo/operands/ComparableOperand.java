package lab.zhang.ruler.pojo.operands;

import lab.zhang.ruler.pojo.Operand;
import lab.zhang.ruler.ao.ComparableValuable;

/**
 * @author zhangrj
 */
abstract public class ComparableOperand<V, T> extends Operand<V, T> implements ComparableValuable<T> {
    public ComparableOperand(V value) {
        super(value);
    }
}
