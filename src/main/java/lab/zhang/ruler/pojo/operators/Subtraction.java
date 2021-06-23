package lab.zhang.ruler.pojo.operators;

import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.operands.comparables.instants.IntInstant;
import lab.zhang.ruler.ao.Valuable;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author zhangrj
 */
public class Subtraction extends UnsortableOperator<Integer, Integer> {
    public Subtraction() {
        super(OperatorType.Subtraction, CardinalityType.Binary);
    }

    @Override
    public Valuable<Integer> calc(@NotNull List<? extends Valuable<Integer>> operands, IndexContext indexContext) {
        if (!cardType.checkCard(operands.size())) {
            throw new IllegalArgumentException("The num of operands is wrong.");
        }

        return new IntInstant(operands.get(0).getValue(indexContext) - operands.get(1).getValue(indexContext));
    }
}
