package lab.zhang.ruler.pojo.operations;

import lab.zhang.ruler.ao.Valuable;
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
public class UnsortedOperation<T> extends Operation<T> {
    @NotNull
    @Contract("null, _ -> fail")
    public static <T> UnsortedOperation<T> getInstance(Operator<T> operator, List<? extends Valuable<T>> operands) {
        if (!(operator instanceof UnsortableOperator)) {
            throw new IllegalArgumentException("The operator is not unsortable");
        }

        return new UnsortedOperation<T>(operator, operands);
    }

    private UnsortedOperation(Operator<T> operator, List<? extends Valuable<T>> operands) {
        super(operator, operands);
    }
}
