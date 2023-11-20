package QuickSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortTest {

    @Test
    public void testQuicksort() {
        int[] arr = {5, 2, 9, 3, 6};
        int[] expected = {2, 3, 5, 6, 9};
        QuickSort.quicksort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testPartition() {
        int[] arr = {5, 2, 9, 3, 6};
        int pivotIndex = QuickSort.partition(arr, 0, arr.length - 1);
        int[] expected = {2, 3, 5, 9, 6};
        assertArrayEquals(expected, arr);
        int expectedPivotIndex = 4;
        assertEquals(expectedPivotIndex, pivotIndex);
    }
}

