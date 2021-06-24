package lab.zhang.ruler.pojo.operands;

import lab.zhang.ruler.pojo.Operand;
import lab.zhang.ruler.pojo.readers.IndexReader;

/**
 * @author zhangrj
 */
abstract public class Variable<V> extends Operand<V, String> {
    public Variable(String value) {
        super(value, new IndexReader<>());
    }
}
