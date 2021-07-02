package lab.zhang.ruler.pojo;

import lab.zhang.ruler.bo.Calculable;

/**
 * @author zhangrj
 */
abstract public class Operator<R, V> implements Calculable<R, V> {

    protected RulerType type;

    public Operator(RulerType type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        return type.getUuid();
    }
}
