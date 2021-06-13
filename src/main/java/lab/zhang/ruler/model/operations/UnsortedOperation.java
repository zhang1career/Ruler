package lab.zhang.ruler.model.operations;

import lab.zhang.ruler.model.Operation;
import lab.zhang.ruler.model.Operator;
import lab.zhang.ruler.model.operators.UnsortableOperator;
import lab.zhang.ruler.repo.Valuable;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zhangrj
 */
@Getter
@Setter
public class UnsortedOperation<T> extends Operation<T> {

    public static <T> UnsortedOperation<T> getInstance(Operator<T> operator, List<Valuable<T>> operands) {
        if (!(operator instanceof UnsortableOperator)) {
            throw new IllegalArgumentException("Operator should be unsortable.");
        }

        int hash = hash(operator, operands);
        if (operationCache.containsKey(hash)) {
            return (UnsortedOperation<T>) operationCache.get(hash);
        }
        UnsortedOperation<T> operation = new UnsortedOperation<>(operator, operands);
        operationCache.put(hash, operation);
        return operation;
    }

    public UnsortedOperation(Operator<T> operator, List<Valuable<T>> operands) {
        super(hash(operator, operands), operator, operands);
    }
}
