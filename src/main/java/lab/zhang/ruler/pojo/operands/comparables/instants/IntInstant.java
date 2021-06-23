package lab.zhang.ruler.pojo.operands.comparables.instants;

import lab.zhang.ruler.ao.Valuable;
import lab.zhang.ruler.pojo.operands.comparables.Instant;
import lab.zhang.ruler.pojo.operands.comparables.variables.IntVariable;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangrj
 */
public class IntInstant extends Instant<Integer> {
    static final int TYPE = 0x35AA1F69;

    public IntInstant(Integer value) {
        super(value);
    }

    @Override
    protected int getType() {
        return TYPE;
    }

    @Override
    public int compareTo(@NotNull Valuable<Integer> o) {
        if (!(o instanceof IntInstant) && !(o instanceof IntVariable)) {
            throw new IllegalArgumentException("An operand is not comparable, an instance of IntInstant/IntVariable is needed");
        }
        if ((o instanceof IntVariable)) {
            return 1;
        }
        return this.getValue().compareTo(o.getValue(null));
    }
}
