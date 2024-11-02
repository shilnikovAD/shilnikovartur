import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsSortStrategy implements SortStrategy {
  private final int maxElements;

  public CollectionsSortStrategy(int maxElements) {
    this.maxElements = maxElements;
  }

  @Override
  public List<Integer> sort(List<Integer> list) throws Exception {
    if (list.size() > maxElements) {
      throw new Exception("Exceeded maximum element count for CollectionsSortStrategy");
    }
    List<Integer> sortedList = new ArrayList<>(list);
    Collections.sort(sortedList);
    return sortedList;
  }
}
