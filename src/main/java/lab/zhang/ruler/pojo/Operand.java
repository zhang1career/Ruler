package lab.zhang.ruler.pojo;

import lab.zhang.ruler.ao.Valuable;
import lombok.Data;

/**
 * @author zhangrj
 */
@Data
abstract public class Operand<V, T> implements Valuable<T> {

    protected long id;
    protected String name;
    protected V value;


    public Operand(String name, V value) {
        this.name = name;
        this.value = value;
    }

    public Operand(V value) {
        this("", value);
    }

    protected abstract int getType();

    @Override
    public int hashCode() {
        return getType() ^ (Integer) value;
    }
}
