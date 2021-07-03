package lab.zhang.ruler.pojo.operators.logics;

import lab.zhang.ruler.bo.Valuable;
import lab.zhang.ruler.exception.CalculationException;
import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.RulerType;
import lab.zhang.ruler.pojo.operands.instants.BoolInstant;
import lab.zhang.ruler.pojo.operators.SortableOperator;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author zhangrj
 */
public class LogicalNot extends SortableOperator<Boolean, Boolean> {
    public LogicalNot() {
        super(RulerType.LOGICAL_NOT);
    }

    @Override
    public Valuable<Boolean> calc(@NotNull List<? extends Valuable<Boolean>> operands, IndexContext indexContext) {
        if (!type.checkCard(operands.size())) {
            throw new CalculationException("The num of operands is wrong.");
        }
        return new BoolInstant(!operands.get(0).getValue(indexContext));
    }
}
