package lab.zhang.ruler.util.lock;

import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zhangrj
 */
@NoArgsConstructor
public class OptimisticLock implements Lock {

    private final AtomicReference<Thread> owner = new AtomicReference<>();

    /**
     * reentrant counter
     */
    private int count = 0;


    @Override
    public boolean lock() {
        Thread t = Thread.currentThread();
        if (t == owner.get()) {
            count++;
            return true;
        }

        if (owner.compareAndSet(null, t)) {
            count = 1;
            return true;
        }

        return false;
    }


    @Override
    public void unlock() {
        Thread t = Thread.currentThread();
        if (t != owner.get()) {
            return;
        }

        count--;
        if (count <= 0) {
            owner.set(null);
        }
    }
}