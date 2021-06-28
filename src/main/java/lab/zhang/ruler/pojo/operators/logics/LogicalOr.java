package lab.zhang.ruler.pojo.operators.logics;

import lab.zhang.ruler.bo.Valuable;
import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.operands.instants.BoolInstant;
import lab.zhang.ruler.pojo.operators.CardinalityType;
import lab.zhang.ruler.pojo.RulerType;
import lab.zhang.ruler.pojo.operators.SortableOperator;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author zhangrj
 */
public class LogicalOr extends SortableOperator<Boolean, Boolean> {
    public LogicalOr() {
        super(RulerType.LogicalOr, CardinalityType.Multinary);
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
