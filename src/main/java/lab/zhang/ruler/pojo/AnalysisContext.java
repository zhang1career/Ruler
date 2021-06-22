package lab.zhang.ruler.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangrj
 */
@Getter
@Setter
public class AnalysisContext {
    private int level;

    private List<Operand<String, ?>> variableList;


    public AnalysisContext(int level) {
        this.level = level;
        this.variableList = new ArrayList<>();
    }

    public AnalysisContext() {
        this(0);
    }

    public AnalysisContext incrLevel() {
        level++;
        return this;
    }
}
