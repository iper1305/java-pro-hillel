package AdvancedMultithreading;
import java.util.ArrayList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeList<T> {
    private final ArrayList<T> list = new ArrayList<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void add(T item) {
        lock.writeLock().lock();
        try {
            list.add(item);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void remove(int index) {
        lock.writeLock().lock();
        try {
            list.remove(index);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public T get(int index) {
        lock.readLock().lock();
        try {
            return list.get(index);
        } finally {
            lock.readLock().unlock();
        }
    }

}
