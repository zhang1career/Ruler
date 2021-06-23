package lab.zhang.ruler.pojo.operators;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhangrj
 */
@Getter
@AllArgsConstructor
public enum OperatorType {
    /**
     * addition
     */
    Addition(0xA037E901),
    /**
     * subtraction
     */
    Subtraction(0x9E5A823C),

    /**
     * greater than
     */
    GreaterThan(0x55D272AC),
    ;

    private final int value;
}
