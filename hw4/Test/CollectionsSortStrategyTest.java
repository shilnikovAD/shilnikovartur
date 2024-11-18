import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CollectionsSortStrategyTest {

    @Test
    void shouldSortListUsingCollectionsSort() throws Exception {
        CollectionsSortStrategy strategy = new CollectionsSortStrategy(10);
        List<Integer> sortedList = strategy.sort(Arrays.asList(5, 1, 4, 2));
        assertEquals(Arrays.asList(1, 2, 4, 5), sortedList);
    }

    @Test
    void shouldThrowExceptionForExceedingMaxElements() {
        CollectionsSortStrategy strategy = new CollectionsSortStrategy(2);
        assertThrows(Exception.class, () -> strategy.sort(Arrays.asList(5, 1, 4)));
    }
}
