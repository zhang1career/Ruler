package lab.zhang.ruler.pojo.operands.variables;

import lab.zhang.ruler.bo.Valuable;
import lab.zhang.ruler.pojo.RulerType;
import lab.zhang.ruler.pojo.operands.Variable;
import lab.zhang.ruler.pojo.operands.instants.StrInstant;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangrj
 */
public class StrVariable extends Variable<String> {

    public StrVariable(String value) {
        super(RulerType.STR_VARIABLE, value);
    }

    public StrVariable() {
        this(null);
    }

    @Override
    public int compareTo(@NotNull Valuable<String> o) {
        if (!(o instanceof StrInstant) && !(o instanceof StrVariable)) {
            throw new IllegalArgumentException("An operand is not comparable, an instance of StrInstant / StrVariable is needed");
        }

        if (o instanceof StrInstant) {
            return -1;
        }

        return Integer.compare(hashCode(), o.hashCode());
    }
}
