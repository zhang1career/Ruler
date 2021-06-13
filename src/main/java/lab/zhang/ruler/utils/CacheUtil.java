package lab.zhang.ruler.utils;

import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheManagerBuilder;

/**
 * @author zhangrj
 */
public class CacheUtil {
    public static CacheManager cacheManager;

    static {
        cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build();
        cacheManager.init();
    }
}
