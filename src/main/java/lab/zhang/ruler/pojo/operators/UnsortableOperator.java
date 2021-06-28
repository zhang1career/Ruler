package lab.zhang.ruler.pojo.operators;

import lab.zhang.ruler.pojo.Operator;
import lab.zhang.ruler.bo.Calculable;
import lab.zhang.ruler.pojo.RulerType;

/**
 * @author zhangrj
 */
abstract public class UnsortableOperator<R, T> extends Operator<R, T> implements Calculable<R, T> {
    public UnsortableOperator(RulerType rulerType, CardinalityType cardType) {
        super(rulerType, cardType);
    }
}
