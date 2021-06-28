package lab.zhang.ruler.pojo.operands.instants;

import lab.zhang.ruler.bo.Valuable;
import lab.zhang.ruler.pojo.RulerType;
import lab.zhang.ruler.pojo.operands.Instant;
import lab.zhang.ruler.pojo.operands.variables.IntVariable;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangrj
 */
public class IntInstant extends Instant<Integer> {

    public IntInstant(Integer value) {
        super(RulerType.IntInstant, value);
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
