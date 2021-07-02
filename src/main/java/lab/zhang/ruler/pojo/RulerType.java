package lab.zhang.ruler.pojo;

import lab.zhang.ruler.bo.Valuable;
import lab.zhang.ruler.pojo.operands.instants.BoolInstant;
import lab.zhang.ruler.pojo.operands.instants.IntInstant;
import lab.zhang.ruler.pojo.operands.instants.StrInstant;
import lab.zhang.ruler.pojo.operands.variables.BoolVariable;
import lab.zhang.ruler.pojo.operands.variables.IntVariable;
import lab.zhang.ruler.pojo.operands.variables.StrVariable;
import lab.zhang.ruler.pojo.operations.SortedOperation;
import lab.zhang.ruler.pojo.operations.UnsortedOperation;
import lab.zhang.ruler.pojo.operators.arithmetics.Addition;
import lab.zhang.ruler.pojo.operators.arithmetics.Subtraction;
import lab.zhang.ruler.pojo.operators.comparators.GreaterThan;
import lab.zhang.ruler.pojo.operators.logics.LogicalEqualTo;
import lab.zhang.ruler.pojo.operators.logics.LogicalOr;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangrj
 */
@Getter
public enum RulerType {
    /**
     * boolean instant operand
     */
    BOOL_INSTANT(0) {
        @Override
        public Valuable<Boolean> getMaterial() {
            return new BoolInstant();
        }
    },
    /**
     * integer instant operand
     */
    INT_INSTANT(1) {
        @Override
        public Valuable<Integer> getMaterial() {
            return new IntInstant();
        }
    },
    LongInstant(2) {
        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    DoubleInstant(3) {
        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    LocationInstant(4) {
        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    CharInstant(5) {
        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    /**
     * string instant operand
     */
    STR_INSTANT(6) {
        @Override
        public Valuable<String> getMaterial() {
            return new StrInstant();
        }
    },
    BytesInstant(7) {
        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    Dummy1Instant(8) {
        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    Dummy2Instant(9) {
        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },

    /**
     * boolean variable operand
     */
    BOOL_VARIABLE(10) {
        @Override
        public Valuable<Boolean> getMaterial() {
            return new BoolVariable();
        }
    },
    /**
     * integer variable operand
     */
    INT_VARIABLE(11) {
        @Override
        public Valuable<Integer> getMaterial() {
            return new IntVariable();
        }
    },
    LongVariable(12) {
        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    DoubleVariable(13) {
        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    LocationVariable(14) {
        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    CharVariable(15) {
        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    /**
     * string variable operand
     */
    STR_VARIABLE(16) {
        @Override
        public Valuable<String> getMaterial() {
            return new StrVariable();
        }
    },
    BytesVariable(17) {
        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    Dummy1Variable(18) {
        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    Dummy2Variable(19) {
        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },


    /**
     * addition operator
     */
    ADDITION(20) {
        @Override
        public Valuable<?> getMaterial() {
            return new SortedOperation<>(new Addition());
        }
    },
    /**
     * subtraction operator
     */
    SUBTRACTION(21) {
        @Override
        public Valuable<?> getMaterial() {
            return new UnsortedOperation<>(new Subtraction());
        }
    },
    Multiplion(22) {
        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    Devision(23) {
        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },

    /**
     * greater-than operator
     */
    EqualTo(24) {
        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    NotEqualTo(25) {
        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    SmallThan(26) {
        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    SmallThanOrEqualTo(27) {
        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    GREATER_THAN(28) {
        @Override
        public Valuable<?> getMaterial() {
            return new UnsortedOperation<>(new GreaterThan());
        }
    },
    GreaterThanOrEqualTo(29) {
        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },

    /**
     * logical equal-to operator
     */
    LOGICAL_EQUAL_TO(30) {
        @Override
        public Valuable<?> getMaterial() {
            return new SortedOperation<>(new LogicalEqualTo());
        }
    },
    LogicalNotEqualTo(31) {
        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    /**
     * logical or operator
     */
    LogicalAnd(32) {
        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    LogicalOr(33) {
        @Override
        public Valuable<?> getMaterial() {
            return new SortedOperation<>(new LogicalOr());
        }
    },
    LogicalNot(34) {
        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    ;

    static Map<Integer, Integer> uuidMap;
    static {
        uuidMap = new HashMap<>();
        uuidMap.put(0,      0x6914B8C1);
        uuidMap.put(1,      0x35AA1F69);
        uuidMap.put(6,      0x723C7BAB);
        uuidMap.put(10,     0x1C3BFC50);
        uuidMap.put(11,     0x41165CAC);
        uuidMap.put(16,     0x66A27177);
        uuidMap.put(20,     0x46EA16A4);
        uuidMap.put(21,     0x07027B67);
        uuidMap.put(28,     0x24DB35CA);
        uuidMap.put(30,     0x26AC5F0A);
        uuidMap.put(33,     0x06ED8409);
    }

    private final int id;

    RulerType(int id) {
        this.id = id;
    }

    int getUuid() {
        return uuidMap.get(id);
    }

    public abstract Valuable<?> getMaterial();

        @Override
    public String toString() {
        return String.valueOf(id);
    }
}
