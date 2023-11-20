package AdvancedMultithreading;
import java.util.concurrent.RecursiveAction;
import java.util.stream.IntStream;

public class ArrayInitializer extends RecursiveAction {
    private static final int THRESHOLD = 1000;
    private final int[] array;
    private final int start;
    private final int end;

    public ArrayInitializer(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start < THRESHOLD) {
            IntStream.range(start, end).forEach(i -> array[i] = i);
        } else {
            int middle = (start + end) / 2;
            ArrayInitializer leftTask = new ArrayInitializer(array, start, middle);
            ArrayInitializer rightTask = new ArrayInitializer(array, middle, end);

            invokeAll(leftTask, rightTask);
        }
    }

}
