package lab.zhang.ruler.pojo.operands;

import lab.zhang.ruler.ao.Valuable;
import lab.zhang.ruler.pojo.IndexContext;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangrj
 */
public class StrVariable extends ComparableOperand<String, String> {
    static final int TYPE = 0x3993CB02;

    public StrVariable(String value) {
        super(value);
    }

    @Override
    protected int getType() {
        return TYPE;
    }

    @Override
    public String getValue(@NotNull IndexContext indexContext) {
        String ret = indexContext.getIndex(value);
        if (ret == null) {
            throw new RuntimeException("An index cannot get value");
        }
        return ret;
    }

    @Override
    public int compareTo(@NotNull Valuable<String> o) {
        if (!(o instanceof StrInstant)) {
            throw new IllegalArgumentException("A right operand is not comparable, StrInstant is needed");
        }
        return -1;
    }
}
