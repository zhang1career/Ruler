package lab.zhang.ruler.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangrj
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RuleDto extends BaseEntryDto {
    /**
     * 规则id
     */
    private Integer id;

    /**
     * 条件
     */
    private String cond;

    /**
     * 决策
     */
    private Boolean dec;
}
