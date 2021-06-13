package lab.zhang.ruler.model.operators;

import lab.zhang.ruler.model.Operator;
import lab.zhang.ruler.repo.Calculable;

/**
 * @author zhangrj
 */
abstract public class UnsortableOperator<T> extends Operator<T> implements Calculable<T> {
    public UnsortableOperator(String name, OperatorType operatorType, CardinalityType cardType) {
        super(name, operatorType, cardType);
    }

    public UnsortableOperator(OperatorType operatorType, CardinalityType cardType) {
        this("", operatorType, cardType);
    }
}
