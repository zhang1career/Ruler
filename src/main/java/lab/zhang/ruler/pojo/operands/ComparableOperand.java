package lab.zhang.ruler.pojo.operands;

import lab.zhang.ruler.pojo.Operand;
import lab.zhang.ruler.ao.ComparableValuable;

/**
 * @author zhangrj
 */
abstract public class ComparableOperand<V, N> extends Operand<V, N> implements ComparableValuable<V> {
    public ComparableOperand(N value) {
        super(value);
    }
}
