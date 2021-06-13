package lab.zhang.ruler.model;

import lab.zhang.ruler.model.operands.OperandType;
import lab.zhang.ruler.repo.Valuable;

/**
 * @author zhangrj
 */
public class Operand<T> implements Valuable<T> {
    protected long id;
    protected String name;
    protected OperandType type;
    protected T value;


    public Operand(String name, OperandType type, T value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public Operand(OperandType type, T value) {
        this("", type, value);
    }


    @Override
    public T getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return type.getValue() ^ (Integer) value;
    }
}
