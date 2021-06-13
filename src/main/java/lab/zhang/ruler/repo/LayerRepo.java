package lab.zhang.ruler.repo;

import lab.zhang.ruler.model.Layer;
import lab.zhang.ruler.model.Operation;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutionException;

/**
 * @author zhangrj
 */
@Data
public class LayerRepo<T extends Comparable<T>> {
    private final Layer<T> layer;


    public LayerRepo(Operation<T> root) {
        this.layer = new Layer<>();
        dfs(root);
    }

    public T getValue() throws ExecutionException, InterruptedException {
        return layer.getValue();
    }

    private int dfs(@NotNull Operation<T> root) {
        if (root.isLeaf()) {
            after(root, 0);
            return 0;
        }

        int level = -1;
        for (Valuable<T> node : root.getOperands()) {
            if (!(node instanceof Operation)) {
                continue;
            }
            level = Math.max(level, dfs((Operation<T>) node));
        }
        after(root, ++level);
        return level;
    }

    private void after(Operation<T> node, int level) {
        layer.enlargeList(level);
        layer.getLevel(level).add(node);
    }
}
