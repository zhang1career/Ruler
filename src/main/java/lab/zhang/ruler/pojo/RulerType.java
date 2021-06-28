package lab.zhang.ruler.pojo;

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
    BoolInstant(0),
    /**
     * integer instant operand
     */
    IntInstant(1),
    LongInstant(2),
    DoubleInstant(3),
    LocationInstant(4),
    CharInstant(5),
    /**
     * string instant operand
     */
    StrInstant(6),
    BytesInstant(7),
    Dummy1Instant(8),
    Dummy2Instant(9),

    /**
     * boolean variable operand
     */
    BoolVariable(10),
    /**
     * integer variable operand
     */
    IntVariable(11),
    LongVariable(12),
    DoubleVariable(13),
    LocationVariable(14),
    CharVariable(15),
    /**
     * string variable operand
     */
    StrVariable(16),
    BytesVariable(17),
    Dummy1Variable(18),
    Dummy2Variable(19),


    /**
     * addition operator
     */
    Addition(20),
    /**
     * subtraction operator
     */
    Subtraction(21),
    Multiplion(22),
    Devision(23),

    /**
     * greater-than operator
     */
    EqualTo(24),
    NotEqualTo(25),
    SmallThan(26),
    SmallThanOrEqualTo(27),
    GreaterThan(28),
    GreaterThanOrEqualTo(29),

    /**
     * logical equal-to operator
     */
    LogicalEqualTo(30),
    LogicalNotEqualTo(31),
    /**
     * logical or operator
     */
    LogicalAnd(32),
    LogicalOr(33),
    LogicalNot(34),
    ;

    static Map<Integer, Integer> uuidMap;
    static {
        uuidMap = new HashMap<>();
        uuidMap.put(0,      0x6914B8C1);
        uuidMap.put(1,      0x35AA1F69);
    }

    private final int id;

    RulerType(int id) {
        this.id = id;
    }

    int getUuid() {
        return uuidMap.get(id);
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
