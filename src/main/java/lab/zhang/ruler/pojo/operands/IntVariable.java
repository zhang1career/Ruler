package lab.zhang.ruler.pojo.operands;

import lab.zhang.ruler.ao.Valuable;
import lab.zhang.ruler.pojo.IndexContext;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangrj
 */
public class IntVariable extends ComparableOperand<String, Integer> {
    static final int TYPE = 0xD0E40A0;

    public IntVariable(String value) {
        super(value);
    }

    @Override
    protected int getType() {
        return TYPE;
    }

    @Override
    public Integer getValue(@NotNull IndexContext indexContext) {
        Integer ret = indexContext.getIndex(value);
        if (ret == null) {
            throw new RuntimeException("An index cannot get value");
        }
        return ret;
    }

    @Override
    public int compareTo(@NotNull Valuable<Integer> o) {
        if ((!(o instanceof IntInstant))) {
            throw new IllegalArgumentException("A right operand is not comparable, IntInstant is needed");
        }
        return -1;
    }
}
