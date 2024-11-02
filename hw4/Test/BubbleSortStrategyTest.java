import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BubbleSortStrategyTest {

    @Test
    void shouldSortListUsingBubbleSort() throws Exception {
        BubbleSortStrategy strategy = new BubbleSortStrategy(10);
        List<Integer> sortedList = strategy.sort(Arrays.asList(3, 2, 1));
        assertEquals(Arrays.asList(1, 2, 3), sortedList);
    }

    @Test
    void shouldThrowExceptionForExceedingMaxElements() {
        BubbleSortStrategy strategy = new BubbleSortStrategy(2);
        assertThrows(Exception.class, () -> strategy.sort(Arrays.asList(3, 2, 1)));
    }
}
