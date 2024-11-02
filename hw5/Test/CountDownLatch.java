import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConcurrentEnrichmentTest {

  @Test
  void shouldSucceedEnrichmentInConcurrentEnvironmentSuccessfully() throws InterruptedException {
    UserRepository userRepository = new InMemoryUserRepository();
    userRepository.updateUserByMsisdn("88005553535", new User("Vasya", "Ivanov"));

    EnrichmentService enrichmentService = new EnrichmentService(userRepository);

    Map<String, String> content = Map.of(
        "action", "button_click",
        "page", "book_card",
        "msisdn", "88005553535"
    );

    Message message = new Message(new ConcurrentHashMap<>(content), Message.EnrichmentType.MSISDN);

    ExecutorService executorService = Executors.newFixedThreadPool(5);
    CountDownLatch latch = new CountDownLatch(5);
    List<Message> results = new CopyOnWriteArrayList<>();

    for (int i = 0; i < 5; i++) {
      executorService.submit(() -> {
        results.add(enrichmentService.enrich(new Message(new ConcurrentHashMap<>(content), Message.EnrichmentType.MSISDN)));
        latch.countDown();
      });
    }
    latch.await();
    executorService.shutdown();

    for (Message result : results) {
      assertEquals("Vasya", result.getContent().get("firstName"));
      assertEquals("Ivanov", result.getContent().get("lastName"));
    }
  }
}
