package AdvancedMultithreading;
import java.util.concurrent.CompletableFuture;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class Runner {

    public static void main(String[] args) {
        // SimpleCalculator
        SimpleCalculator calculator = new SimpleCalculator();

        Random random = new Random();
        int first = random.nextInt(100);
        int second = random.nextInt(100);

        CompletableFuture<Integer> sumFuture = calculator.squareSum(first, second);

        sumFuture.thenAccept(sum -> {
            System.out.println("Sum of Squares: " + sum);
        });
        sumFuture.join();

        // ArrayInitializer
        int[] array = new int[100_000];
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new ArrayInitializer(array, 0, array.length));

        IntStream.range(0, 10).forEach(i -> System.out.println(array[i]));

        //ThreadSafeList
        ThreadSafeList<Integer> threadSafeList = new ThreadSafeList<>();

        threadSafeList.add(1);
        threadSafeList.add(2);
        threadSafeList.add(3);

        System.out.println("Item at index 1: " + threadSafeList.get(1));

        threadSafeList.remove(1);

        System.out.println("Item at index 1 after removal: " + threadSafeList.get(1));
    }
}
