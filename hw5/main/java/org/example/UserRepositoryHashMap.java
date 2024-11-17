package hw05.database.repositories;

import hw05.database.models.UserModel;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Реализация интерфейса репозитория пользователей.
 * <p>Используется временное хранилище на основе ConcurrentHashMap.</p>
 */
public class UserRepositoryHashMap implements UserRepository {
  private final ConcurrentHashMap<String, UserModel> userStorage = new ConcurrentHashMap<>();

  @Override
  public UserModel findByPhoneNumber(String phoneNumber) {
    return userStorage.get(phoneNumber);
  }

  @Override
  public void saveOrUpdate(UserModel user) {
    userStorage.put(user.getPhoneNumber(), user);
  }
}
