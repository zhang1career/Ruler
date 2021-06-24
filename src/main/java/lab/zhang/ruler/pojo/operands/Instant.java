package lab.zhang.ruler.pojo.operands;

import lab.zhang.ruler.pojo.Operand;
import lab.zhang.ruler.pojo.readers.InstantReader;

/**
 * @author zhangrj
 */
abstract public class Instant<V> extends Operand<V, V> {
    public Instant(V value) {
        super(value, new InstantReader<V>());
    }
}
