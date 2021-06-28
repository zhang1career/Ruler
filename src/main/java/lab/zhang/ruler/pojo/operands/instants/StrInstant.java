package lab.zhang.ruler.pojo.operands.instants;

import lab.zhang.ruler.bo.Valuable;
import lab.zhang.ruler.pojo.RulerType;
import lab.zhang.ruler.pojo.operands.Instant;
import lab.zhang.ruler.pojo.operands.variables.StrVariable;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangrj
 */
public class StrInstant extends Instant<String> {

    public StrInstant(String value) {
        super(RulerType.StrInstant, value);
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
