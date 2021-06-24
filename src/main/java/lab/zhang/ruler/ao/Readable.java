package lab.zhang.ruler.ao;

import lab.zhang.ruler.pojo.IndexContext;

/**
 * @author zhangrj
 */
public interface Readable<V, N> {
    V read(N name, IndexContext indexContext);
}
