package lab.zhang.ruler.pojo.analyzers;

import lab.zhang.ruler.ao.Valuable;
import lab.zhang.ruler.pojo.AnalysisContext;
import lab.zhang.ruler.pojo.Analyzer;
import lab.zhang.ruler.pojo.Operand;
import lab.zhang.ruler.pojo.Operation;
import lab.zhang.ruler.pojo.operands.comparables.Variable;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

/**
 * @author zhangrj
 */
public class IteratingAnalyzer extends Analyzer {

    public IteratingAnalyzer() {
        super();
    }

    @Override
    protected void onTraversal(@NotNull Operation<?, ?> node, AnalysisContext analysisContext) {
        for (Valuable<?> operand : node.getOperands()) {
            if (!(operand instanceof Variable)) {
                continue;
            }
            analysisContext.getIndexMap().put(operand.hashCode(), (Operand<?, String>) operand);
        }
    }

    @Override
    protected AnalysisContext postTraversal(Operation<?, ?> node, @NotNull AnalysisContext analysisContext) {
        analysisContext.getOperationOfLevel(analysisContext.getLevel()).add(node);
        return analysisContext;
    }

    @Override
    protected AnalysisContext mergeContext(@NotNull List<AnalysisContext> contexts) {
        AnalysisContext mergedContext = new AnalysisContext();
        for (AnalysisContext context : contexts) {
            if (mergedContext.getLevel() < context.getLevel()) {
                mergedContext.setLevel(context.getLevel());
            }

            for (Map.Entry<Integer, Operand<?, String>> entry : context.getIndexMap().entrySet()) {
                if (mergedContext.getIndexMap().containsKey(entry.getKey())) {
                    continue;
                }
                mergedContext.getIndexMap().put(entry.getKey(), entry.getValue());
            }

            for (int i = 0; i < Math.max(mergedContext.getOperationListSize(), context.getOperationListSize()); i++) {
                if (i >= context.getOperationListSize()) {
                    break;
                }
                mergedContext.getOperationOfLevel(i).addAll(context.getOperationOfLevel(i));
            }
        }
        return mergedContext;
    }
}
