package lab.zhang.ruler.pojo.operators;

import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.operands.comparables.instants.IntInstant;
import lab.zhang.ruler.ao.Valuable;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author zhangrj
 */
public class Addition extends SortableOperator<Integer, Integer> {
    public Addition() {
        super(OperatorType.Addition, CardinalityType.Multinary);
    }

    @Override
    public Valuable<Integer> calc(@NotNull List<? extends Valuable<Integer>> operands, IndexContext indexContext) {
        if (!cardType.checkCard(operands.size())) {
            throw new IllegalArgumentException("The num of operands is wrong.");
        }

        int ret = 0;
        for (Valuable<Integer> operand : operands) {
            ret += operand.getValue(indexContext);
        }
        return new IntInstant(ret);
    }
}
