package lab.zhang.ruler.pojo.operators.arithmetics;

import lab.zhang.ruler.exception.CalculationException;
import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.operands.instants.IntInstant;
import lab.zhang.ruler.bo.Valuable;
import lab.zhang.ruler.pojo.RulerType;
import lab.zhang.ruler.pojo.operators.SortableOperator;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author zhangrj
 */
public class Addition extends SortableOperator<Integer, Integer> {
    public Addition() {
        super(RulerType.ADDITION);
    }

    @Override
    public Valuable<Integer> calc(@NotNull List<? extends Valuable<Integer>> operands, IndexContext indexContext) {
        if (!type.getCardinality().checkCard(operands.size())) {
            throw new CalculationException("The num of operands is wrong.");
        }

        int ret = 0;
        for (Valuable<Integer> operand : operands) {
            ret += operand.getValue(indexContext);
        }
        return new IntInstant(ret);
    }
}
