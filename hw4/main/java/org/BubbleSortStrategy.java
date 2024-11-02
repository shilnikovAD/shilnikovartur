import java.util.ArrayList;
import java.util.List;

public class BubbleSortStrategy implements SortStrategy {
  private final int maxElements;

  public BubbleSortStrategy(int maxElements) {
    this.maxElements = maxElements;
  }

  @Override
  public List<Integer> sort(List<Integer> list) throws Exception {
    if (list.size() > maxElements) {
      throw new Exception("Exceeded maximum element count for BubbleSortStrategy");
    }
    List<Integer> sortedList = new ArrayList<>(list);
    for (int i = 0; i < sortedList.size() - 1; i++) {
      for (int j = 0; j < sortedList.size() - i - 1; j++) {
        if (sortedList.get(j) > sortedList.get(j + 1)) {
          int temp = sortedList.get(j);
          sortedList.set(j, sortedList.get(j + 1));
          sortedList.set(j + 1, temp);
        }
      }
    }
    return sortedList;
  }
}
