package lab.zhang.ruler.pojo.operators.comparators;

import lab.zhang.ruler.bo.Valuable;
import lab.zhang.ruler.exception.CalculationException;
import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.operands.instants.BoolInstant;
import lab.zhang.ruler.pojo.RulerType;
import lab.zhang.ruler.pojo.operators.UnsortableOperator;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author zhangrj
 */
public class GreaterThan extends UnsortableOperator<Boolean, Integer> {
    public GreaterThan() {
        super(RulerType.GREATER_THAN);
    }

    @Override
    public Valuable<Boolean> calc(@NotNull List<? extends Valuable<Integer>> operands, IndexContext indexContext) {
        if (!type.checkCard(operands.size())) {
            throw new CalculationException("The num of operands is wrong.");
        }

        return new BoolInstant(operands.get(0).getValue(indexContext) > operands.get(1).getValue(indexContext));
    }
}
