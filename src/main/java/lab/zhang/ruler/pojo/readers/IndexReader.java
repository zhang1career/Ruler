package lab.zhang.ruler.pojo.readers;

import lab.zhang.ruler.ao.Readable;
import lab.zhang.ruler.pojo.IndexContext;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangrj
 */
@NoArgsConstructor
public class IndexReader<V> implements Readable<V, String> {
    @Override
    public V read(String value, @NotNull IndexContext indexContext) {
        V ret = indexContext.getIndex(value);
        if (ret == null) {
            throw new RuntimeException("Cannot find the index from IndexContext");
        }
        return ret;
    }
}
