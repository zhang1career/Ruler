package lab.zhang.ruler.pojo;

import lab.zhang.ruler.pojo.operators.CardinalityType;
import lab.zhang.ruler.pojo.operators.OperatorType;
import lab.zhang.ruler.ao.Calculable;

/**
 * @author zhangrj
 */
abstract public class Operator<T> implements Calculable<T> {
    protected String name;
    protected OperatorType operatorType;
    protected CardinalityType cardType;

    public Operator(String name, OperatorType operatorType, CardinalityType cardType) {
        this.name = name;
        this.operatorType = operatorType;
        this.cardType = cardType;
    }

    @Override
    public int hashCode() {
        return operatorType.getValue();
    }
}
