package lab.zhang.ruler.pojo;

import lab.zhang.ruler.pojo.operators.CardinalityType;
import lab.zhang.ruler.bo.Calculable;

/**
 * @author zhangrj
 */
abstract public class Operator<R, V> implements Calculable<R, V> {
    protected RulerType rulerType;
    protected CardinalityType cardType;

    public Operator(RulerType rulerType, CardinalityType cardType) {
        this.rulerType = rulerType;
        this.cardType = cardType;
    }

    @Override
    public int hashCode() {
        return rulerType.getUuid();
    }
}
