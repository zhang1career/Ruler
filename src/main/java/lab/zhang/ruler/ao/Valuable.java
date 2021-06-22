package lab.zhang.ruler.ao;

import lab.zhang.ruler.pojo.IndexContext;

/**
 * @author zhangrj
 */
public interface Valuable<T> {
    /**
     * Get the value
     * @return value
     */
    T getValue(IndexContext indexContext);
}
