package lab.zhang.ruler.pojo.operators;

import lab.zhang.ruler.ao.Valuable;
import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.operands.comparables.instants.BoolInstant;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author zhangrj
 */
public class GreaterThan extends UnsortableOperator<Boolean, Integer> {
    public GreaterThan() {
        super(OperatorType.GreaterThan, CardinalityType.Binary);
    }

    @Override
    public Valuable<Boolean> calc(@NotNull List<? extends Valuable<Integer>> operands, IndexContext indexContext) {
        if (!cardType.checkCard(operands.size())) {
            throw new IllegalArgumentException("The num of operands is wrong.");
        }

        return new BoolInstant(operands.get(0).getValue(indexContext) > operands.get(1).getValue(indexContext));
    }
}
