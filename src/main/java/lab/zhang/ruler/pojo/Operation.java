package lab.zhang.ruler.pojo;

import lab.zhang.ruler.ao.Calculable;
import lab.zhang.ruler.ao.ComparableValuable;
import lab.zhang.ruler.ao.Valuable;
import lab.zhang.ruler.util.CacheUtil;
import lab.zhang.ruler.util.HashUtil;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author zhangrj
 */
@Getter
@Setter
public class Operation<T> implements ComparableValuable<T>, Calculable<T> {
    private static final int HASH_MASK = 0x96A55A69;

    @NotNull
    public static <T> Operation<T> getInstance(Operator<T> operator, List<? extends Valuable<T>> operands) {
        int uuid = hash(operator, operands);
        Operation<T> operation = CacheUtil.getOperation(uuid);
        if (operation == null) {
            operation = new Operation<>(operator, operands);
            CacheUtil.setOperation(uuid, operation);
        }
        return operation;
    }

    public static <T> T getValueOf(Operation<T> operation, IndexContext indexContext) {
        return operation.getValue(indexContext);
    }

    private static <T> int hash(Operator<T> operator, List<? extends Valuable<T>> operands) {
        return HashUtil.hash(operator, operands, HASH_MASK);
    }


    protected Operator<T> operator;

    protected List<? extends Valuable<T>> operands;

    protected int uuid;

    boolean cacheOn = false;


    public Operation(Operator<T> operator, List<? extends Valuable<T>> operands) {
        this.operator = operator;
        this.operands = operands;
        this.uuid = hash(operator, operands);
    }

    @Override
    public T getValue(IndexContext indexContext) {
        return calc(operands, indexContext).getValue(indexContext);
    }

    @Override
    public Valuable<T> calc(List<? extends Valuable<T>> operands, IndexContext indexContext) {
        if (operator == null || operands == null) {
            return null;
        }
        return operator.calc(operands, indexContext);
    }

    @Override
    public int compareTo(@NotNull Valuable<T> o) {
        if (!(o instanceof Operation)) {
            return 1;
        }
        int thisHashCode = this.hashCode();
        int thatHashCode = o.hashCode();
        return Integer.compare(thisHashCode, thatHashCode);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Operation)) {
            return false;
        }

        Operation<?> op = (Operation<?>) obj;
        return uuid == op.uuid;
    }

    @Override
    public int hashCode() {
        return hash(operator, operands);
    }

    public boolean isLeaf() {
        if (operands == null) {
            return true;
        }
        for (Valuable<T> operand : operands) {
            if (operand instanceof Operation) {
                return false;
            }
        }
        return true;
    }
}
