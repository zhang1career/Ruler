package lab.zhang.ruler.pojo.operators;

import lab.zhang.ruler.ao.Valuable;
import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.operands.instants.BoolInstant;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author zhangrj
 */
public class LogicalOr extends SortableOperator<Boolean, Boolean> {
    public LogicalOr() {
        super(OperatorType.LogicalOr, CardinalityType.Multinary);
    }

    @Override
    public Valuable<Boolean> calc(@NotNull List<? extends Valuable<Boolean>> operands, IndexContext indexContext) {
        if (!cardType.checkCard(operands.size())) {
            throw new IllegalArgumentException("The num of operands is wrong.");
        }

        for (Valuable<Boolean> operand : operands) {
            if (operand.getValue(indexContext)) {
                return new BoolInstant(true);
            }
        }
        return new BoolInstant(false);
    }
}
