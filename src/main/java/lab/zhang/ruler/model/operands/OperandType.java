package lab.zhang.ruler.model.operands;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhangrj
 */
@Getter
@AllArgsConstructor
public enum OperandType {
    /**
     * integer number
     */
    IntNumber(0x107C3B01);


    private final int value;
}
