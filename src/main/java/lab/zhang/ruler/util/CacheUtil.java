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
    }

    public static <R, V> Operation<R, V> getOperation(int uuid) {
        return (Operation<R, V>) operationCache.get(uuid);
    }

    public static <R, V> void setOperation(int uuid, Operation<R, V> operation) {
        operationCache.put(uuid, operation);
    }
}
