package lab.zhang.ruler.pojo.operands;

import lab.zhang.ruler.ao.Valuable;
import lab.zhang.ruler.pojo.IndexContext;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangrj
 */
public class IntInstant extends ComparableOperand<Integer, Integer> {
    static final int TYPE = 0x35AA1F69;

    public IntInstant(Integer value) {
        super(value);
    }

    @Override
    protected int getType() {
        return TYPE;
    }

    @Override
    public Integer getValue(IndexContext indexContext) {
        return value;
    }

    @Override
    public int compareTo(@NotNull Valuable<Integer> o) {
        return this.getValue().compareTo(o.getValue(null));
    }
}
