package lab.zhang.ruler.pojo.operands.variables;

import lab.zhang.ruler.bo.Valuable;
import lab.zhang.ruler.pojo.RulerType;
import lab.zhang.ruler.pojo.operands.Variable;
import lab.zhang.ruler.pojo.operands.instants.IntInstant;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangrj
 */
public class IntVariable extends Variable<Integer> {

    public IntVariable(String value) {
        super(RulerType.INT_VARIABLE, value);
    }

    public IntVariable() {
        this(null);
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
