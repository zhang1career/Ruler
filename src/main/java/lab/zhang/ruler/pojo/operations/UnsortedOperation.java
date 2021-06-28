package lab.zhang.ruler.pojo.operations;

import lab.zhang.ruler.bo.Valuable;
import lab.zhang.ruler.pojo.Operation;
import lab.zhang.ruler.pojo.Operator;
import lab.zhang.ruler.pojo.operators.UnsortableOperator;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author zhangrj
 */
@Getter
@Setter
public class UnsortedOperation<R, V> extends Operation<R, V> {
    @NotNull
    @Contract("null, _ -> fail")
    public static <R, V> UnsortedOperation<R, V> getInstance(Operator<R, V> operator, List<? extends Valuable<V>> operands) {
        if (!(operator instanceof UnsortableOperator)) {
            throw new IllegalArgumentException("The operator is not unsortable");
        }

        return new UnsortedOperation<>(operator, operands);
    }

    private UnsortedOperation(Operator<R, V> operator, List<? extends Valuable<V>> operands) {
        super(operator, operands);
    }
}
