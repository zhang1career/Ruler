package lab.zhang.ruler.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangrj
 */
public class IndexContext {
    private long reqid;

    private final Map<String, Object> indices = new HashMap<>();


    public <T> T getIndex(String key) {
        return (T) indices.get(key);
    }

    public void putIndex(String key, Object value) {
        indices.put(key, value);
    }
}
