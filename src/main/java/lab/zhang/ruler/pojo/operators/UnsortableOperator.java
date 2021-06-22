package lab.zhang.ruler.pojo.operators;

import lab.zhang.ruler.pojo.Operator;
import lab.zhang.ruler.ao.Calculable;

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
