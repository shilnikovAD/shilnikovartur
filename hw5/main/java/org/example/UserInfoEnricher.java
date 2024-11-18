package hw05.parser.enrichment;

import hw05.database.models.UserModel;
import hw05.database.repositories.UserRepository;
import hw05.parser.messages.Message;

/**
 * Добавляет информацию о пользователе в сообщение на основе номера телефона.
 */
public class UserInfoEnricher implements MessageEnricher {
  private final UserRepository repository;

  public UserInfoEnricher(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public void enrich(Message message) {
    if (message.containsKey("phone")) {
      UserModel user = repository.findByPhoneNumber(message.get("phone"));
      if (user != null) {
        message.put("firstName", user.getFirstName());
        message.put("lastName", user.getLastName());
      }
    }
  }
}
