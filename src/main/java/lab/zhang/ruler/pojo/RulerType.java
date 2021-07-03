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
import lab.zhang.ruler.pojo.operators.logics.LogicalNot;
import lab.zhang.ruler.pojo.operators.logics.LogicalOr;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * @author zhangrj
 */
@Getter
@AllArgsConstructor
public enum RulerType {
    /**
     * boolean instant operand
     */
    BOOL_INSTANT(0) {
        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(BOOL_INSTANT, BOOL_VARIABLE));
        }

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
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(INT_INSTANT, INT_VARIABLE));
        }

        @Override
        public Valuable<Integer> getMaterial() {
            return new IntInstant();
        }
    },
    LONG_INSTANT(2) {
        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(LONG_INSTANT, LONG_VARIABLE));
        }

        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    DOUBLE_INSTANT(3) {
        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(DOUBLE_INSTANT, DOUBLE_VARIABLE));
        }

        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    LOCATION_INSTANT(4) {
        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(LOCATION_INSTANT, LOCATION_VARIABLE));
        }

        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    CHAR_INSTANT(5) {
        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(CHAR_INSTANT, CHAR_VARIABLE));
        }

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
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(STR_INSTANT, STR_VARIABLE));
        }

        @Override
        public Valuable<String> getMaterial() {
            return new StrInstant();
        }
    },
    BYTES_INSTANT(7) {
        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(BYTES_INSTANT, BYTES_VARIABLE));
        }

        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    DUMMY_1_INSTANT(8) {
        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(DUMMY_1_INSTANT, DUMMY_1_VARIABLE));
        }

        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    DUMMY_2_INSTANT(9) {
        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(DUMMY_2_INSTANT, DUMMY_2_VARIABLE));
        }

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
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(BOOL_INSTANT, BOOL_VARIABLE));
        }

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
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(INT_INSTANT, INT_VARIABLE));
        }

        @Override
        public Valuable<Integer> getMaterial() {
            return new IntVariable();
        }
    },
    LONG_VARIABLE(12) {
        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(LONG_INSTANT, LONG_VARIABLE));
        }

        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    DOUBLE_VARIABLE(13) {
        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(DOUBLE_INSTANT, DOUBLE_VARIABLE));
        }

        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    LOCATION_VARIABLE(14) {
        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(LOCATION_INSTANT, LOCATION_VARIABLE));
        }

        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    CHAR_VARIABLE(15) {
        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(CHAR_INSTANT, CHAR_VARIABLE));
        }

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
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(STR_INSTANT, STR_VARIABLE));
        }

        @Override
        public Valuable<String> getMaterial() {
            return new StrVariable();
        }
    },
    BYTES_VARIABLE(17) {
        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(BYTES_INSTANT, BYTES_VARIABLE));
        }

        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    DUMMY_1_VARIABLE(18) {
        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(DUMMY_1_INSTANT, DUMMY_1_VARIABLE));
        }

        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    DUMMY_2_VARIABLE(19) {
        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(DUMMY_2_INSTANT, DUMMY_2_VARIABLE));
        }

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
        public boolean checkCard(int num) {
            return Cardinality.MULTINARY.checkCard(num);
        }

        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(INT_INSTANT, INT_VARIABLE));
        }

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
        public boolean checkCard(int num) {
            return Cardinality.BINARY.checkCard(num);
        }

        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(INT_INSTANT, INT_VARIABLE));
        }

        @Override
        public Valuable<?> getMaterial() {
            return new UnsortedOperation<>(new Subtraction());
        }
    },
    MULTIPLION(22) {
        @Override
        public boolean checkCard(int num) {
            return Cardinality.MULTINARY.checkCard(num);
        }

        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(INT_INSTANT, INT_VARIABLE));
        }

        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    DEVISION(23) {
        @Override
        public boolean checkCard(int num) {
            return Cardinality.BINARY.checkCard(num);
        }

        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(INT_INSTANT, INT_VARIABLE));
        }

        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },

    /**
     * equal-to operator
     */
    EQUAL_TO(24) {
        @Override
        public boolean checkCard(int num) {
            return Cardinality.BINARY.checkCard(num);
        }

        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(BOOL_INSTANT, BOOL_VARIABLE, INT_INSTANT, INT_VARIABLE));
        }

        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    NOT_EQUAL_TO(25) {
        @Override
        public boolean checkCard(int num) {
            return Cardinality.BINARY.checkCard(num);
        }

        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(BOOL_INSTANT, BOOL_VARIABLE, INT_INSTANT, INT_VARIABLE));
        }

        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    SMALL_THAN(26) {
        @Override
        public boolean checkCard(int num) {
            return Cardinality.BINARY.checkCard(num);
        }

        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(INT_INSTANT, INT_VARIABLE));
        }

        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },
    SMALL_THAN_OR_EQUAL_TO(27) {
        @Override
        public boolean checkCard(int num) {
            return Cardinality.BINARY.checkCard(num);
        }

        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(INT_INSTANT, INT_VARIABLE));
        }

        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },

    /**
     * greater-than operator
     */
    GREATER_THAN(28) {
        @Override
        public boolean checkCard(int num) {
            return Cardinality.BINARY.checkCard(num);
        }

        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(INT_INSTANT, INT_VARIABLE));
        }

        @Override
        public Valuable<?> getMaterial() {
            return new UnsortedOperation<>(new GreaterThan());
        }
    },
    GREATER_THAN_OR_EQUAL_TO(29) {
        @Override
        public boolean checkCard(int num) {
            return Cardinality.BINARY.checkCard(num);
        }

        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(INT_INSTANT, INT_VARIABLE));
        }

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
        public boolean checkCard(int num) {
            return Cardinality.BINARY.checkCard(num);
        }

        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(
                    BOOL_INSTANT, BOOL_VARIABLE,
                    EQUAL_TO, NOT_EQUAL_TO, SMALL_THAN, SMALL_THAN_OR_EQUAL_TO, GREATER_THAN, GREATER_THAN_OR_EQUAL_TO,
                    LOGICAL_EQUAL_TO, LOGICAL_NOT_EQUAL_TO, LOGICAL_AND, LOGICAL_OR, LOGICAL_NOT));
        }

        @Override
        public Valuable<?> getMaterial() {
            return new SortedOperation<>(new LogicalEqualTo());
        }
    },

    /**
     * logical not-equal-to operator
     */
    LOGICAL_NOT_EQUAL_TO(31) {
        @Override
        public boolean checkCard(int num) {
            return Cardinality.BINARY.checkCard(num);
        }

        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(
                    BOOL_INSTANT, BOOL_VARIABLE,
                    EQUAL_TO, NOT_EQUAL_TO, SMALL_THAN, SMALL_THAN_OR_EQUAL_TO, GREATER_THAN, GREATER_THAN_OR_EQUAL_TO,
                    LOGICAL_EQUAL_TO, LOGICAL_NOT_EQUAL_TO, LOGICAL_AND, LOGICAL_OR, LOGICAL_NOT));
        }

        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },

    /**
     * logical and operator
     */
    LOGICAL_AND(32) {
        @Override
        public boolean checkCard(int num) {
            return Cardinality.MULTINARY.checkCard(num);
        }

        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(
                    BOOL_INSTANT, BOOL_VARIABLE,
                    EQUAL_TO, NOT_EQUAL_TO, SMALL_THAN, SMALL_THAN_OR_EQUAL_TO, GREATER_THAN, GREATER_THAN_OR_EQUAL_TO,
                    LOGICAL_EQUAL_TO, LOGICAL_NOT_EQUAL_TO, LOGICAL_AND, LOGICAL_OR, LOGICAL_NOT));
        }

        @Override
        public Valuable<?> getMaterial() {
            return null;
        }
    },

    /**
     * logical or operator
     */
    LOGICAL_OR(33) {
        @Override
        public boolean checkCard(int num) {
            return Cardinality.MULTINARY.checkCard(num);
        }

        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(
                    BOOL_INSTANT, BOOL_VARIABLE,
                    EQUAL_TO, NOT_EQUAL_TO, SMALL_THAN, SMALL_THAN_OR_EQUAL_TO, GREATER_THAN, GREATER_THAN_OR_EQUAL_TO,
                    LOGICAL_EQUAL_TO, LOGICAL_NOT_EQUAL_TO, LOGICAL_AND, LOGICAL_OR, LOGICAL_NOT));
        }

        @Override
        public Valuable<?> getMaterial() {
            return new SortedOperation<>(new LogicalOr());
        }
    },

    /**
     * logical not operator
     */
    LOGICAL_NOT(34) {
        @Override
        public boolean checkCard(int num) {
            return Cardinality.UNARY.checkCard(num);
        }

        @Override
        public Set<RulerType> getPairableOperandTypes() {
            return new HashSet<>(Arrays.asList(
                    BOOL_INSTANT, BOOL_VARIABLE,
                    EQUAL_TO, NOT_EQUAL_TO, SMALL_THAN, SMALL_THAN_OR_EQUAL_TO, GREATER_THAN, GREATER_THAN_OR_EQUAL_TO,
                    LOGICAL_EQUAL_TO, LOGICAL_NOT_EQUAL_TO, LOGICAL_AND, LOGICAL_OR, LOGICAL_NOT));
        }

        @Override
        public Valuable<?> getMaterial() {
            return new UnsortedOperation<>(new LogicalNot());
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
        uuidMap.put(34,     0x7D3ADCBA);
    }

    private final int id;

    int getUuid() {
        return uuidMap.get(id);
    }

    public boolean checkCard(int num) {
        return Cardinality.NONE.checkCard(num);
    }

    public boolean checkType(@NotNull List<RulerType> types) {
        if (types.size() <= 0) {
            return true;
        }
        Set<RulerType> pairableTypes = this.getPairableOperandTypes();
        for (RulerType type : types) {
            if (!pairableTypes.contains(type)) {
                return false;
            }
        }
        return true;
    }

    public abstract Set<RulerType> getPairableOperandTypes();

    public abstract Valuable<?> getMaterial();

    @Override
    public String toString() {
        return String.valueOf(id);
    }


    @Getter
    @AllArgsConstructor
    public enum Cardinality {
        /**
         * none
         */
        NONE(0),

        /**
         * one
         */
        UNARY(1),

        /**
         * two
         */
        BINARY(2),

        /**
         * more
         */
        MULTINARY(Integer.MAX_VALUE) {
            @Override
            public boolean checkCard(int num) {
                return num > 0;
            }
        },
        ;

        private final int card;

        public boolean checkCard(int num) {
            return card == num;
        }
    }
}
