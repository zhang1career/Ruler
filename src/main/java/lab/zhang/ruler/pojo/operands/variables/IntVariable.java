package lab.zhang.ruler.pojo.operands.variables;

import lab.zhang.ruler.ao.Valuable;
import lab.zhang.ruler.pojo.operands.Variable;
import lab.zhang.ruler.pojo.operands.instants.IntInstant;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangrj
 */
public class IntVariable extends Variable<Integer> {
    static final int TYPE = 0xD0E40A0;

    public IntVariable(String value) {
        super(value);
    }

    @Override
    protected int getType() {
        return TYPE;
    }

    @Override
    public int compareTo(@NotNull Valuable<Integer> o) {
        if (!(o instanceof IntInstant) && !(o instanceof IntVariable)) {
            throw new IllegalArgumentException("An operand is not comparable, an instance of IntInstant / IntVariableis is needed");
        }

        if (o instanceof IntInstant) {
            return -1;
        }

        return Integer.compare(hashCode(), o.hashCode());
    }
}
