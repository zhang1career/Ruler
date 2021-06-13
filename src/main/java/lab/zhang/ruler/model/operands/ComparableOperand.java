package lab.zhang.ruler.model.operands;

import lab.zhang.ruler.model.Operand;
import lab.zhang.ruler.repo.ComparableValuable;

/**
 * @author zhangrj
 */
abstract public class ComparableOperand<T> extends Operand<T> implements ComparableValuable<T> {
    public ComparableOperand(OperandType type, T value) {
        super(type, value);
    }
}
