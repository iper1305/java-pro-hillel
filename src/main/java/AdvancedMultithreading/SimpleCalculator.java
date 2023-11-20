package AdvancedMultithreading;
import java.util.concurrent.CompletableFuture;

public class SimpleCalculator {
    public CompletableFuture<Integer> squareSum(int first, int second) {
        CompletableFuture<Integer> squareFirstFuture = CompletableFuture.supplyAsync(() -> square(first));
        CompletableFuture<Integer> squareSecondFuture = CompletableFuture.supplyAsync(() -> square(second));

        return squareFirstFuture.thenCombine(squareSecondFuture, (result1, result2) -> result1 + result2);
    }

    private int square(int number) {
        return number * number;
    }

}
