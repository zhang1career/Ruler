package lab.zhang.ruler.pojo.executors;

import lab.zhang.ruler.pojo.AnalysisContext;
import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.Analyzer;
import lab.zhang.ruler.pojo.Operation;
import lab.zhang.ruler.util.CacheUtil;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangrj
 */
public class IteratingAnalyzer<T> extends Analyzer<T> {
    protected List<List<Operation<T>>> operationList;

    public IteratingAnalyzer(Operation<T> root) {
        super(root);
    }

    public void enlargeOpList(int level) {
        if (operationList == null) {
            operationList = new ArrayList<>();
        }
        while (operationList.size() < level + 1) {
            operationList.add(new ArrayList<>());
        }
    }

    public List<Operation<T>> getOperationLevel(int level) {
        if (operationList.size() < level + 1) {
            return null;
        }
        return operationList.get(level);
    }

    protected T getResult(Operation<T> operation, IndexContext indexContext) {
        T result;
        int uuid = hash(operation, indexContext);
        result = CacheUtil.getResult(uuid);
        if (result == null) {
            result = operation.getValue(indexContext);
            CacheUtil.setResult(uuid, result);
        }
        return result;
    }

    @Override
    protected AnalysisContext postTraversal(Operation<T> node, @NotNull AnalysisContext analysisContext) {
        enlargeOpList(analysisContext.getLevel());
        getOperationLevel(analysisContext.getLevel()).add(node);
        return analysisContext;
    }

    @Override
    protected AnalysisContext mergeContext(@NotNull List<AnalysisContext> contexts) {
        AnalysisContext analysisContext = new AnalysisContext();
        for (AnalysisContext context : contexts) {
            if (analysisContext.getLevel() < context.getLevel()) {
                analysisContext.setLevel(context.getLevel());
            }
        }
        return analysisContext;
    }
}
