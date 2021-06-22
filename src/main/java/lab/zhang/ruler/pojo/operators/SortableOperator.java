package lab.zhang.ruler.pojo.operators;

import lab.zhang.ruler.pojo.Operator;
import lab.zhang.ruler.ao.Calculable;

/**
 * @author zhangrj
 */
abstract public class SortableOperator<T> extends Operator<T> implements Calculable<T> {
    public SortableOperator(String name, OperatorType operatorType, CardinalityType cardType) {
        super(name, operatorType, cardType);
    }

    public SortableOperator(OperatorType operatorType, CardinalityType cardType) {
        this("", operatorType, cardType);
    }
}
