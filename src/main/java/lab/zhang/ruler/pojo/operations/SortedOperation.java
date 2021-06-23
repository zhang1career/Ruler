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
public class SortedOperation<R, V> extends Operation<R, V> {
    @NotNull
    @Contract("null, _ -> fail")
    public static <R, V> SortedOperation<R, V> getInstance(Operator<R, V> operator, List<? extends Valuable<V>> operands) {
        if (!(operator instanceof SortableOperator)) {
            throw new IllegalArgumentException("The operator is not sortable");
        }

        List<ComparableValuable<V>> comparableOperands = new ArrayList<>();
        for (Valuable<V> operand : operands) {
            if (!(operand instanceof ComparableValuable)) {
                throw new IllegalArgumentException("An operand is not comparable");
            }
            comparableOperands.add((ComparableValuable<V>) operand);
        }

        Collections.sort(comparableOperands);
        return new SortedOperation<>(operator, comparableOperands);
    }

    private SortedOperation(Operator<R, V> operator, List<? extends Valuable<V>> operands) {
        super(operator, operands);
    }
}
