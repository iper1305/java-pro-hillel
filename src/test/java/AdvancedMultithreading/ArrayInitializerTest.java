package AdvancedMultithreading;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ArrayInitializerTest {

    @Test
    public void testArrayInitialization_fullArray() {
        int[] array = new int[10000];
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new ArrayInitializer(array, 0, array.length));

        IntStream.range(0, array.length).forEach(i -> assertEquals(i, array[i]));
    }

    @Test
    public void testArrayInitialization_partialArray() {
        int[] array = new int[10000];
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new ArrayInitializer(array, 500, 1000));

        IntStream.range(0, 500).forEach(i -> assertEquals(0, array[i]));
        IntStream.range(500, 1000).forEach(i -> assertEquals(i, array[i]));
        IntStream.range(1000, array.length).forEach(i -> assertEquals(0, array[i]));
    }

    @Test
    public void testArrayInitialization_emptyArray() {
        int[] array = new int[0];
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new ArrayInitializer(array, 0, array.length));

        assertEquals(0, array.length);
    }
}

