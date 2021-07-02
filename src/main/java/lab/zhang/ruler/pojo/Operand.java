package lab.zhang.ruler.pojo;

import lab.zhang.ruler.bo.ComparableValuable;
import lab.zhang.ruler.bo.Readable;
import lab.zhang.ruler.util.HashUtil;
import lombok.Data;

/**
 * @author zhangrj
 */
@Data
abstract public class Operand<V, N> implements ComparableValuable<V> {

    protected RulerType type;

    protected N value;

    protected Readable<V, N> reader;


    public Operand(RulerType type, N value, Readable<V, N> reader) {
        this.type = type;
        this.value = value;
        this.reader = reader;
    }


    @Override
    public V getValue(IndexContext indexContext) {
        return reader.read(value, indexContext);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Operand)) {
            return false;
        }

        Operand<?, ?> op = (Operand<?, ?>) obj;
        return hashCode() == op.hashCode();
    }

    @Override
    public int hashCode() {
        return type.getUuid() ^ HashUtil.codeAsInt(value);
    }
}
