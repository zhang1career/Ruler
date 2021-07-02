package lab.zhang.ruler.pojo.operands.instants;

import lab.zhang.ruler.bo.Valuable;
import lab.zhang.ruler.pojo.RulerType;
import lab.zhang.ruler.pojo.operands.Instant;
import lab.zhang.ruler.pojo.operands.variables.BoolVariable;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangrj
 */
public class BoolInstant extends Instant<Boolean> {

    public BoolInstant(Boolean value) {
        super(RulerType.BOOL_INSTANT, value);
    }

    public BoolInstant() {
        this(null);
    }

    @Override
    public int compareTo(@NotNull Valuable<Boolean> o) {
        if (!(o instanceof BoolInstant) && !(o instanceof BoolVariable)) {
            throw new IllegalArgumentException("An operand is not comparable, an instance of BoolInstant/BoolVariable is needed");
        }
        if ((o instanceof BoolVariable)) {
            return 1;
        }
        return this.getValue().compareTo(o.getValue(null));
    }
}
