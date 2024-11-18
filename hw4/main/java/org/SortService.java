import java.util.List;

public class SortService {
  private final List<SortStrategy> strategies;

  public SortService(List<SortStrategy> strategies) {
    this.strategies = strategies;
  }

  public List<Integer> sort(List<Integer> list) {
    for (SortStrategy strategy : strategies) {
      try {
        return strategy.sort(list);
      } catch (Exception e) {
        System.out.println("Strategy failed: " + e.getMessage());
      }
    }
    throw new RuntimeException("No suitable sorting strategy available.");
  }
}
