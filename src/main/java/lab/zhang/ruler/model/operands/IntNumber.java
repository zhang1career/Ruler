package lab.zhang.ruler.model.operands;

import lab.zhang.ruler.repo.Valuable;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangrj
 */
public class IntNumber extends ComparableOperand<Integer> {
    public IntNumber(Integer value) {
        super(OperandType.IntNumber, value);
    }

    @Override
    public int compareTo(@NotNull Valuable<Integer> o) {
        return this.getValue().compareTo(o.getValue());
    }
}
