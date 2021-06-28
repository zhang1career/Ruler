package lab.zhang.ruler.pojo;

import com.alibaba.fastjson.serializer.ValueFilter;
import lab.zhang.ruler.exception.AstTypeException;
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


    public Ast(String name, RulerType type, Object value)  {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public void setType(RulerType type) {
        if (type == null) {
            throw new AstTypeException("The type does not exist");
        }
        this.type = type;
    }
}
