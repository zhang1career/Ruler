package lab.zhang.ruler.pojo.operations;

import lab.zhang.ruler.ao.ComparableValuable;
import lab.zhang.ruler.ao.Valuable;
import lab.zhang.ruler.pojo.Operation;
import lab.zhang.ruler.pojo.Operator;
import lab.zhang.ruler.pojo.operators.SortableOperator;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangrj
 */
@Getter
@Setter
public class SortedOperation<T> extends Operation<T> {
    @NotNull
    @Contract("null, _ -> fail")
    public static <T> SortedOperation<T> getInstance(Operator<T> operator, List<? extends Valuable<T>> operands) {
        if (!(operator instanceof SortableOperator)) {
            throw new IllegalArgumentException("The operator is not sortable");
        }

        List<ComparableValuable<T>> comparableOperands = new ArrayList<>();
        for (Valuable<T> operand : operands) {
            if (!(operand instanceof ComparableValuable)) {
                throw new IllegalArgumentException("An operand is not comparable");
            }
            comparableOperands.add((ComparableValuable<T>) operand);
        }

        Collections.sort(comparableOperands);
        return new SortedOperation<T>(operator, comparableOperands);
    }

    private SortedOperation(Operator<T> operator, List<? extends Valuable<T>> operands) {
        super(operator, operands);
    }
}
