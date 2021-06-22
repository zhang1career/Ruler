package lab.zhang.ruler.util.lock;

/**
 * @author zhangrj
 */
public interface Lock {
    /**
     * Lock
     * @return true - lock success, false - lock failed
     */
    boolean lock();

    /**
     * Unlock
     */
    void unlock();
}
