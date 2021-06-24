package lab.zhang.ruler.pojo;

import lab.zhang.ruler.ao.ComparableValuable;
import lab.zhang.ruler.ao.Readable;
import lab.zhang.ruler.ao.Valuable;
import lab.zhang.ruler.util.HashUtil;
import lombok.Data;

/**
 * @author zhangrj
 */
@Data
abstract public class Operand<V, N> implements Valuable<V>, ComparableValuable<V> {

    protected long id;
    protected String name;
    protected N value;

    protected Readable<V, N> reader;


    public Operand(String name, N value, Readable<V, N> reader) {
        this.name = name;
        this.value = value;
        this.reader = reader;
    }

    public Operand(N value, Readable<V, N> reader) {
        this("", value, reader);
    }

    protected abstract int getType();

    @Override
    public int hashCode() {
        return getType() ^ HashUtil.codeAsInt(value);
    }

    @Override
    public V getValue(IndexContext indexContext) {
        return reader.read(value, indexContext);
    }
}
