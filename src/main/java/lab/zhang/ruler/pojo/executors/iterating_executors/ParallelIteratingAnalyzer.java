package lab.zhang.ruler.pojo.executors.iterating_executors;

import lab.zhang.ruler.pojo.IndexContext;
import lab.zhang.ruler.pojo.Operation;
import lab.zhang.ruler.pojo.executors.IteratingAnalyzer;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

/**
 * @author zhangrj
 */
public class ParallelIteratingAnalyzer<T extends Comparable<T>> extends IteratingAnalyzer<T> {

    public <T> T getValueOf(Operation<T> operation) {
        return null;
    }

    public ParallelIteratingAnalyzer(Operation<T> root) {
        super(root);
    }

    public T getValue(IndexContext indexContext) {
        ForkJoinPool pool = new ForkJoinPool(4);
        for (List<Operation<T>> operations : operationList) {
            try {
                pool.submit(
                        () -> operations.parallelStream().forEach(this::getValueOf)
                ).get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return Operation.getValueOf(getOperationLevel(operationList.size() - 1).get(0), indexContext);
    }
}
