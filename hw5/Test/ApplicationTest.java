import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest {

  @Test
  void shouldReturnEnrichedMessage() {
    UserRepository userRepository = new InMemoryUserRepository();
    userRepository.updateUserByMsisdn("88005553535", new User("Vasya", "Ivanov"));

    EnrichmentService enrichmentService = new EnrichmentService(userRepository);

    Map<String, String> content = new HashMap<>();
    content.put("action", "button_click");
    content.put("page", "book_card");
    content.put("msisdn", "88005553535");

    Message message = new Message(content, Message.EnrichmentType.MSISDN);
    Message enrichedMessage = enrichmentService.enrich(message);

    assertEquals("Vasya", enrichedMessage.getContent().get("firstName"));
    assertEquals("Ivanov", enrichedMessage.getContent().get("lastName"));
  }
}
