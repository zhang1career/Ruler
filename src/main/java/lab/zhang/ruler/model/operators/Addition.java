package lab.zhang.ruler.model.operators;

import lab.zhang.ruler.model.operands.IntNumber;
import lab.zhang.ruler.repo.Valuable;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author zhangrj
 */
public class Addition extends SortableOperator<Integer> {
    public Addition() {
        super(OperatorType.Addition, CardinalityType.Multinary);
    }

    @Override
    public Valuable<Integer> calc(@NotNull List<? extends Valuable<Integer>> operands) {
        if (!cardType.checkCard(operands.size())) {
            throw new IllegalArgumentException("The num of operands is wrong.");
        }

        int ret = 0;
        for (Valuable<Integer> operand : operands) {
            ret += operand.getValue();
        }
        return new IntNumber(ret);
    }
}
