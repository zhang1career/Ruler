package lab.zhang.ruler.pojo.executors;

import lab.zhang.ruler.pojo.AnalysisContext;
import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.Operation;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangrj
 */
public class SingleExecutor<R extends Comparable<R>> {
    private final Map<Integer, Object> resultMap;

    private final AnalysisContext analysisContext;

    public SingleExecutor(AnalysisContext analysisContext) {
        this.resultMap = new HashMap<>();
        this.analysisContext = analysisContext;
    }

    public R getValue(IndexContext indexContext) {
        R result = null;
        for (List<Operation<?, ?>> operations : analysisContext.getOperationList()) {
            for (Operation<?, ?> operation : operations) {
                result = getResult(operation, indexContext);
            }
        }
        return result;
    }

    protected R getResult(Operation<?, ?> operation, IndexContext indexContext) {
        int uuid = hash(operation, indexContext);
        if (!resultMap.containsKey(uuid)) {
            resultMap.put(uuid, operation.getValue(indexContext));
        }
        return (R) resultMap.get(uuid);
    }

    protected int hash(@NotNull Operation<?, ?> operation, @NotNull IndexContext indexContext) {
        return operation.getUuid() ^ indexContext.hashCode();
    }
}
