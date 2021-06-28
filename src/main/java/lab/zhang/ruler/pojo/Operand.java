package lab.zhang.ruler.pojo;

import lab.zhang.ruler.bo.ComparableValuable;
import lab.zhang.ruler.bo.Readable;
import lab.zhang.ruler.bo.Valuable;
import lab.zhang.ruler.util.HashUtil;
import lombok.Data;

/**
 * @author zhangrj
 */
@Data
abstract public class Operand<V, N> implements Valuable<V>, ComparableValuable<V> {

    protected long id;

    protected RulerType rulerType;

    protected N value;

    protected Readable<V, N> reader;


    public Operand(RulerType rulerType, N value, Readable<V, N> reader) {
        this.rulerType = rulerType;
        this.value = value;
        this.reader = reader;
    }

    @Override
    public int hashCode() {
        return rulerType.getUuid() ^ HashUtil.codeAsInt(value);
    }

    @Override
    public V getValue(IndexContext indexContext) {
        return reader.read(value, indexContext);
    }
}
