package lab.zhang.ruler.pojo.readers;

import lab.zhang.ruler.bo.Readable;
import lab.zhang.ruler.pojo.IndexContext;
import lombok.NoArgsConstructor;

/**
 * @author zhangrj
 */
@NoArgsConstructor
public class InstantReader<V> implements Readable<V, V> {
    @Override
    public V read(V value, IndexContext indexContext) {
        return value;
    }
}
