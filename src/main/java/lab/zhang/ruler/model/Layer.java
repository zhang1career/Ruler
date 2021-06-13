package lab.zhang.ruler.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

/**
 * @author zhangrj
 */
@Data
@AllArgsConstructor
public class Layer<T> {
    private List<List<Operation<T>>> list;

    public Layer() {
        this(new ArrayList<>());
    }

    public void enlargeList(int level) {
        while (list.size() < level + 1) {
            list.add(new ArrayList<>());
        }
    }

    public List<Operation<T>> getLevel(int level) {
        if (list.size() < level + 1) {
            return null;
        }
        return list.get(level);
    }

    public T getValue() throws ExecutionException, InterruptedException {
        ForkJoinPool customThreadPool = new ForkJoinPool(4);
        T result = null;
        for (List<Operation<T>> operations : list) {
            for (Operation<T> operation : operations) {
                result = operation.getValue();
            }
//            result = (T) customThreadPool.submit(
//                    () -> operations.parallelStream().forEach(Operation::evaluate)
//            ).get();
        }
        return result;
    }
}
