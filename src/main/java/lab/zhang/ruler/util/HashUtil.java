package lab.zhang.ruler.util;

import lab.zhang.ruler.bo.Valuable;
import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.Operator;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author zhangrj
 */
public class HashUtil {
    private static final int PRIME = 997;
    private static final int OFFSET = 7;

    public static <R, V> int hash(@NotNull Operator<R, V> operator, List<? extends Valuable<V>> operands, int salt) {
        int ret = salt ^ operator.hashCode();
        if (operands == null) {
            return ret;
        }
        for (int i = 0; i < operands.size(); i++) {
            int hash = operands.get(i).hashCode();
            ret += (PRIME + OFFSET * i) * hash;
        }

        return ret;
    }

    public static <T> int hashWithContext(int hash, IndexContext indexContext) {
        return hash ^ indexContext.hashCode();
    }

    public static <T> Integer codeAsInt(T value) {
        if (value instanceof Integer) {
            return (Integer) value;
        }
        if (value instanceof String) {
            return value.hashCode();
        }
        return null;
    }
}
