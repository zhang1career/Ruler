package lab.zhang.ruler.pojo;

import lab.zhang.ruler.ao.Valuable;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangrj
 */
@Data
abstract public class Analyzer<T> {

    public Analyzer(Operation<T> root) {
        dfs(root);
    }


    private AnalysisContext dfs(@NotNull Operation<T> root) {
        if (root.isLeaf()) {
            return this.postTraversal(root, new AnalysisContext());
        }

        List<AnalysisContext> analysisContexts = new ArrayList<>();
        for (Valuable<T> node : root.getOperands()) {
            if (!(node instanceof Operation)) {
                continue;
            }
            analysisContexts.add(dfs((Operation<T>) node));
        }

        return postTraversal(root, mergeContext(analysisContexts).incrLevel());
    }


    /**
     * Do something after AST traversal
     *
     * @param node AST node
     * @param analysisContext analysis context for now
     * @return analysis context for further
     */
    protected abstract AnalysisContext postTraversal(Operation<T> node, AnalysisContext analysisContext);


    /**
     * Merge analysis contexts
     *
     * @param contexts analysis contexts to be merged
     * @return analysis contexts after merged
     */
    protected abstract AnalysisContext mergeContext(List<AnalysisContext> contexts);


    protected int hash(@NotNull Operation<T> operation, @NotNull IndexContext indexContext) {
        return operation.getUuid() ^ indexContext.hashCode();
    }
}
