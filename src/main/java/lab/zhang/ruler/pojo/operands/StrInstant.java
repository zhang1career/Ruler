package lab.zhang.ruler.pojo.operands;

import lab.zhang.ruler.ao.Valuable;
import lab.zhang.ruler.pojo.IndexContext;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangrj
 */
public class StrInstant extends ComparableOperand<String, String> {
    static final int TYPE = 0x5FD3EFD6;

    public StrInstant(String value) {
        super(value);
    }

    @Override
    protected int getType() {
        return TYPE;
    }

    @Override
    public String getValue(IndexContext indexContext) {
        return value;
    }

    @Override
    public int compareTo(@NotNull Valuable<String> o) {
        return this.getValue().compareTo(o.getValue(null));
    }
}
