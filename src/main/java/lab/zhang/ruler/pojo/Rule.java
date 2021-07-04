package lab.zhang.ruler.pojo;

import lombok.Data;

/**
 * @author zhangrj
 */
@Data
public class Rule {
    private Integer id;
    private String cond;

    @Override
    public String toString() {
        return String.format("{\"id\":%d, \"cond\":%s}", id, cond);
    }
}
