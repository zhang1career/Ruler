package lab.zhang.ruler.model.operations;

import lab.zhang.ruler.model.Operation;
import lab.zhang.ruler.model.Operator;
import lab.zhang.ruler.model.operators.SortableOperator;
import lab.zhang.ruler.repo.ComparableValuable;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

/**
 * @author zhangrj
 */
@Getter
@Setter
public class SortedOperation<T> extends Operation<T> {

    public static <T> SortedOperation<T> getInstance(Operator<T> operator, List<ComparableValuable<T>> operands) {
        if (!(operator instanceof SortableOperator)) {
            throw new IllegalArgumentException("Operator should be sortable.");
        }
        Collections.sort(operands);

        int hash = hash(operator, operands);
        if (operationCache.containsKey(hash)) {
            return (SortedOperation<T>) operationCache.get(hash);
        }
        SortedOperation<T> operation = new SortedOperation<>(operator, operands);
        operationCache.put(hash, operation);
        return operation;
    }

    public SortedOperation(Operator<T> operator, List<ComparableValuable<T>> operands) {
        super(hash(operator, operands), operator, operands);
    }
}
