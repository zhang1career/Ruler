package lab.zhang.ruler.pojo.operands.variables;

import lab.zhang.ruler.bo.Valuable;
import lab.zhang.ruler.pojo.RulerType;
import lab.zhang.ruler.pojo.operands.Variable;
import lab.zhang.ruler.pojo.operands.instants.BoolInstant;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangrj
 */
public class BoolVariable extends Variable<Boolean> {

    public BoolVariable(String value) {
        super(RulerType.BoolVariable, value);

    }

    @Override
    public int compareTo(@NotNull Valuable<Boolean> o) {
        if (!(o instanceof BoolInstant) && !(o instanceof BoolVariable)) {
            throw new IllegalArgumentException("An operand is not comparable, an instance of BoolInstant / BoolVariable is needed");
        }

        if (o instanceof BoolInstant) {
            return -1;
        }

        return Integer.compare(hashCode(), o.hashCode());
    }
}
