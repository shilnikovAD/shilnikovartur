import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SortServiceTest {

    @Test
    void shouldSortUsingAvailableStrategy() {
        SortStrategy bubbleSort = new BubbleSortStrategy(5);
        SortService service = new SortService(Arrays.asList(bubbleSort));

        List<Integer> sortedList = service.sort(Arrays.asList(3, 2, 1));
        assertEquals(Arrays.asList(1, 2, 3), sortedList);
    }

    @Test
    void shouldThrowExceptionWhenNoSuitableStrategy() {
        SortStrategy bubbleSort = new BubbleSortStrategy(2);
        SortService service = new SortService(Arrays.asList(bubbleSort));

        assertThrows(RuntimeException.class, () -> service.sort(Arrays.asList(3, 2, 1)));
    }
}
