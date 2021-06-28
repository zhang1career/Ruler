package lab.zhang.ruler.pojo;

import com.alibaba.fastjson.serializer.ValueFilter;
import lombok.Data;

/**
 * @author zhangrj
 */
@Data
public class Ast {
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
}
