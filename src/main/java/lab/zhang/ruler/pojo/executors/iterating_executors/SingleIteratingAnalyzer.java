package lab.zhang.ruler.pojo.executors.iterating_executors;

import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.Operation;
import lab.zhang.ruler.pojo.executors.IteratingAnalyzer;

import java.util.List;

/**
 * @author zhangrj
 */
public class SingleIteratingAnalyzer<T extends Comparable<T>> extends IteratingAnalyzer<T> {

    public SingleIteratingAnalyzer(Operation<T> root) {
        super(root);
    }

    public T getValue(IndexContext indexContext) {
        T result = null;
        for (List<Operation<T>> operations : operationList) {
            for (Operation<T> operation : operations) {
                result = getResult(operation, indexContext);
            }
        }
        return result;
    }
}
