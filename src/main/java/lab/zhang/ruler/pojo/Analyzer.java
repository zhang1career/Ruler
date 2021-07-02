package lab.zhang.ruler.pojo;

import lab.zhang.ruler.bo.Valuable;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangrj
 */
@NoArgsConstructor
abstract public class Analyzer {
    public AnalysisContext fire(Operation<?, ?> root) {
        return dfs(root);
    }

    private AnalysisContext dfs(@NotNull Operation<?, ?> root) {
        AnalysisContext context = new AnalysisContext();

        if (root.isLeaf()) {
            onTraversal(root, context);
            return this.postTraversal(root, context);
        }

        List<AnalysisContext> childrenContextList = new ArrayList<>();
        for (Valuable<?> node : root.getOperands()) {
            if (!(node instanceof Operation)) {
                continue;
            }
            childrenContextList.add(dfs((Operation<?, ?>) node));
        }
        context = mergeContext(childrenContextList);
        return postTraversal(root, context.incrLevel());
    }


    /**
     * Do something on Token traversal
     *
     * @param node Token node
     * @param analysisContext analysis context for now
     */
    protected abstract void onTraversal(Operation<?, ?> node, AnalysisContext analysisContext);

    /**
     * Do something after Token traversal
     *
     * @param node Token node
     * @param analysisContext analysis context for now
     * @return analysis context for further
     */
    protected abstract AnalysisContext postTraversal(Operation<?, ?> node, AnalysisContext analysisContext);


    /**
     * Merge analysis contexts
     *
     * @param contexts analysis contexts to be merged
     * @return analysis contexts after merged
     */
    protected abstract AnalysisContext mergeContext(List<AnalysisContext> contexts);
}
