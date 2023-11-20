package AdvancedMultithreading;
import org.junit.jupiter.api.Test;
import java.util.concurrent.ExecutionException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleCalculatorTest {

    @Test
    public void testSquareSum_positiveNumbers() throws ExecutionException, InterruptedException {
        SimpleCalculator calculator = new SimpleCalculator();

        int result = calculator.squareSum(2, 3).get();

        assertEquals(13, result);
    }

    @Test
    public void testSquareSum_negativeNumbers() throws ExecutionException, InterruptedException {
        SimpleCalculator calculator = new SimpleCalculator();

        int result = calculator.squareSum(-2, -3).get();

        assertEquals(13, result);
    }

    @Test
    public void testSquareSum_zero() throws ExecutionException, InterruptedException {
        SimpleCalculator calculator = new SimpleCalculator();

        int result = calculator.squareSum(0, 0).get();

        assertEquals(0, result);
    }

    @Test
    public void testSquareSum_mixedSigns() throws ExecutionException, InterruptedException {
        SimpleCalculator calculator = new SimpleCalculator();

        int result = calculator.squareSum(-2, 3).get();

        assertEquals(13, result);
    }
}

