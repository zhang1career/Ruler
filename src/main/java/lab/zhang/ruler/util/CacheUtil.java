package lab.zhang.ruler.util;

import lab.zhang.ruler.pojo.Operation;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

/**
 * @author zhangrj
 */
public class CacheUtil {
    public static CacheManager cacheManager;

    protected static Cache<Integer, Operation> operationCache;

    protected static Cache<Integer, Object> resultCache;

    static {
        cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build();
        cacheManager.init();

        operationCache = cacheManager.createCache(
                "OPERATION",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(
                        Integer.class,
                        Operation.class,
                        ResourcePoolsBuilder.heap(100)
                ).build()
        );

        resultCache = cacheManager.createCache(
                "RESULT",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(
                        Integer.class,
                        Object.class,
                        ResourcePoolsBuilder.heap(100)
                ).build()
        );
    }

    public static <T> Operation<T> getOperation(int uuid) {
        return (Operation<T>) operationCache.get(uuid);
    }

    public static <T> void setOperation(int uuid, Operation<T> operation) {
        operationCache.put(uuid, operation);
    }

    public static <T> T getResult(int uuid) {
        return (T) resultCache.get(uuid);
    }

    public static <T> void setResult(int uuid, T result) {
        resultCache.put(uuid, result);
    }
}
