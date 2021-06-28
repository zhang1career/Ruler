package lab.zhang.ruler.bo;

import lab.zhang.ruler.pojo.IndexContext;

/**
 * @author zhangrj
 */
public interface Valuable<V> {
    /**
     * Get the value
     * @param indexContext The context that holds indices
     * @return value
     */
    V getValue(IndexContext indexContext);
}
