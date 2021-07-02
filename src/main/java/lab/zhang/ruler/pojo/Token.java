package lab.zhang.ruler.pojo;

import com.alibaba.fastjson.serializer.ValueFilter;
import lab.zhang.ruler.exception.TokenizationException;
import lombok.Data;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangrj
 */
@Data
public class Token {
    @NotNull
    @Contract(pure = true)
    public static ValueFilter getFilter() {
        return (object, name, value) -> {
            try {
                if (!"type".equals(name) || !(value instanceof RulerType)) {
                    return value;
                }
                return ((RulerType) value).getId();
            } catch (Exception e) {
                return value;
            }
        };
    }


    private String name;

    private RulerType type;

    private Object value;


    public Token(String name, RulerType type, Object value) {
        if (type == null) {
            throw new TokenizationException("The type does not exist");
        }
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public void setType(RulerType type) {
        if (type == null) {
            throw new TokenizationException("The type does not exist");
        }
        this.type = type;
    }
}
