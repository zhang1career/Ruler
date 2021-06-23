package lab.zhang.ruler.pojo.operands.comparables.variables;

import lab.zhang.ruler.ao.Valuable;
import lab.zhang.ruler.pojo.operands.comparables.instants.StrInstant;
import lab.zhang.ruler.pojo.operands.comparables.Variable;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangrj
 */
public class StrVariable extends Variable<String> {
    static final int TYPE = 0x3993CB02;

    public StrVariable(String value) {
        super(value);
    }

    @Override
    protected int getType() {
        return TYPE;
    }

    @Override
    public int compareTo(@NotNull Valuable<String> o) {
        if (!(o instanceof StrInstant)) {
            throw new IllegalArgumentException("A right operand is not comparable, StrInstant is needed");
        }
        return -1;
    }
}
