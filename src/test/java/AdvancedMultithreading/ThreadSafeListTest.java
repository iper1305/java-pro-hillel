package AdvancedMultithreading;
import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static org.junit.jupiter.api.Assertions.*;

public class ThreadSafeListTest {

    @Test
    public void testAddAndGet_singleThread() {
        ThreadSafeList<Integer> list = new ThreadSafeList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void testRemove_singleThread() {
        ThreadSafeList<Integer> list = new ThreadSafeList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(1);

        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Test
    public void testConcurrentAddAndRemove_multiThread() throws InterruptedException {
        ThreadSafeList<Integer> list = new ThreadSafeList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CountDownLatch latch = new CountDownLatch(4);

        Runnable addTask = () -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
            latch.countDown();
        };

        Runnable removeTask = () -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    list.remove(0);
                } catch (IndexOutOfBoundsException e) {
                }
            }
            latch.countDown();
        };

        executorService.execute(addTask);
        executorService.execute(addTask);
        executorService.execute(removeTask);
        executorService.execute(removeTask);

        latch.await();

        assertTrue(list.get(0) >= 0);
    }
}

