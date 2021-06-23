package lab.zhang.ruler.pojo.operands.comparables.variables;

import lab.zhang.ruler.ao.Valuable;
import lab.zhang.ruler.pojo.operands.comparables.Variable;
import lab.zhang.ruler.pojo.operands.comparables.instants.BoolInstant;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangrj
 */
public class BoolVariable extends Variable<Boolean> {
    static final int TYPE = 0x245D1431;

    public BoolVariable(String value) {
        super(value);
    }

    @Override
    protected int getType() {
        return TYPE;
    }

    @Override
    public int compareTo(@NotNull Valuable<Boolean> o) {
        if (!(o instanceof BoolInstant)) {
            throw new IllegalArgumentException("An operand is not comparable, an instance of BoolInstant is needed");
        }
        return -1;
    }
}
