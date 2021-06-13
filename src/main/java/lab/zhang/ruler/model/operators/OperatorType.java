package lab.zhang.ruler.model.operators;

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

    ;

    private final int value;
}
