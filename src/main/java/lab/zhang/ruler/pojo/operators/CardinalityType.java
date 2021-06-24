package lab.zhang.ruler.pojo.operators;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhangrj
 */
@Getter
@AllArgsConstructor
public enum CardinalityType {
    /**
     * one
     */
    Unary(1),

    /**
     * two
     */
    Binary(2),

    /**
     * more
     */
    Multinary(Integer.MAX_VALUE) {
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
