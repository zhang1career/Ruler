package lab.zhang.ruler.model.operators;

import lab.zhang.ruler.model.operands.IntNumber;
import lab.zhang.ruler.repo.Valuable;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author zhangrj
 */
public class Subtraction extends UnsortableOperator<Integer> {
    public Subtraction() {
        super(OperatorType.Subtraction, CardinalityType.Binary);
    }

    @Override
    public Valuable<Integer> calc(@NotNull List<? extends Valuable<Integer>> operands) {
        if (!cardType.checkCard(operands.size())) {
            throw new IllegalArgumentException("The num of operands is wrong.");
        }

        return new IntNumber(operands.get(0).getValue() - operands.get(1).getValue());
    }
}
