package hw05.parser.enrichment;

import hw05.database.models.UserModel;
import hw05.database.repositories.UserRepository;
import hw05.parser.messages.ConcurrentMessage;
import hw05.parser.messages.Message;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserInfoEnricherTest {

  @Test
  void shouldAddUserInfoIfPhoneExists() {
    UserRepository repository = mock(UserRepository.class);
    when(repository.findByPhoneNumber("123456789"))
        .thenReturn(new UserModel("Alice", "Smith", "123456789"));

    UserInfoEnricher enricher = new UserInfoEnricher(repository);
    Message message = new ConcurrentMessage();
    message.put("phone", "123456789");

    enricher.enrich(message);

    assertEquals("Alice", message.get("firstName"));
    assertEquals("Smith", message.get("lastName"));
  }

  @Test
  void shouldDoNothingIfPhoneNotInMessage() {
    UserRepository repository = mock(UserRepository.class);
    UserInfoEnricher enricher = new UserInfoEnricher(repository);
    Message message = new ConcurrentMessage();

    enricher.enrich(message);

    assertFalse(message.containsKey("firstName"));
    assertFalse(message.containsKey("lastName"));
  }

  @Test
  void shouldDoNothingIfUserNotFound() {
    UserRepository repository = mock(UserRepository.class);
    when(repository.findByPhoneNumber("000000000")).thenReturn(null);

    UserInfoEnricher enricher = new UserInfoEnricher(repository);
    Message message = new ConcurrentMessage();
    message.put("phone", "000000000");

    enricher.enrich(message);

    assertFalse(message.containsKey("firstName"));
    assertFalse(message.containsKey("lastName"));
  }
}
