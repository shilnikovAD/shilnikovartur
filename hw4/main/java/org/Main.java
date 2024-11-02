import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(4, 2, 7, 1, 3);

    SortStrategy collectionsSort = new CollectionsSortStrategy(10);
    SortStrategy bubbleSort = new BubbleSortStrategy(5);

    SortService sortService = new SortService(Arrays.asList(collectionsSort, bubbleSort));

    List<Integer> sortedList = sortService.sort(numbers);
    System.out.println("Sorted list: " + sortedList);
  }
}
