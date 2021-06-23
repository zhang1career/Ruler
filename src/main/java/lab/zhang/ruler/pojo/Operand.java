package lab.zhang.ruler.pojo;

import lab.zhang.ruler.ao.Valuable;
import lab.zhang.ruler.util.HashUtil;
import lombok.Data;

/**
 * @author zhangrj
 */
@Data
abstract public class Operand<V, N> implements Valuable<V> {

    protected long id;
    protected String name;
    protected N value;


    public Operand(String name, N value) {
        this.name = name;
        this.value = value;
    }

    public Operand(N value) {
        this("", value);
    }

    protected abstract int getType();

    @Override
    public int hashCode() {
        return getType() ^ HashUtil.codeAsInt(value);
    }
}
