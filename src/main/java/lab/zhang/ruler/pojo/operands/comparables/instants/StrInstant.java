package lab.zhang.ruler.pojo.operands.comparables.instants;

import lab.zhang.ruler.ao.Valuable;
import lab.zhang.ruler.pojo.operands.comparables.Instant;
import lab.zhang.ruler.pojo.operands.comparables.variables.StrVariable;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangrj
 */
public class StrInstant extends Instant<String> {
    static final int TYPE = 0x5FD3EFD6;

    public StrInstant(String value) {
        super(value);
    }

    @Override
    protected int getType() {
        return TYPE;
    }

    @Override
    public int compareTo(@NotNull Valuable<String> o) {
        if (!(o instanceof StrInstant) && !(o instanceof StrVariable)) {
            throw new IllegalArgumentException("An operand is not comparable, an instance of StrInstant/StrVariable is needed");
        }
        if ((o instanceof StrVariable)) {
            return 1;
        }
        return this.getValue().compareTo(o.getValue(null));
    }
}
