package lab.zhang.ruler.pojo;

import lab.zhang.ruler.pojo.operators.CardinalityType;
import lab.zhang.ruler.bo.Calculable;

/**
 * @author zhangrj
 */
abstract public class Operator<R, V> implements Calculable<R, V> {

    protected RulerType type;

    protected CardinalityType cardType;

    public Operator(RulerType type, CardinalityType cardType) {
        this.type = type;
        this.cardType = cardType;
    }

    @Override
    public int hashCode() {
        return type.getUuid();
    }
}
