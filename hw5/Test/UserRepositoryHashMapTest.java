package hw05.database.repositories;

import hw05.database.models.UserModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryHashMapTest {

  @Test
  void shouldSaveAndFindUserByPhoneNumber() {
    UserRepository repository = new UserRepositoryHashMap();
    UserModel user = new UserModel("John", "Doe", "123456789");

    repository.saveOrUpdate(user);
    UserModel foundUser = repository.findByPhoneNumber("123456789");

    assertNotNull(foundUser);
    assertEquals("John", foundUser.getFirstName());
    assertEquals("Doe", foundUser.getLastName());
  }

  @Test
  void shouldUpdateExistingUser() {
    UserRepository repository = new UserRepositoryHashMap();
    UserModel user = new UserModel("John", "Doe", "123456789");
    repository.saveOrUpdate(user);

    UserModel updatedUser = new UserModel("John", "Smith", "123456789");
    repository.saveOrUpdate(updatedUser);

    UserModel foundUser = repository.findByPhoneNumber("123456789");
    assertEquals("Smith", foundUser.getLastName());
  }

  @Test
  void shouldReturnNullIfUserNotFound() {
    UserRepository repository = new UserRepositoryHashMap();
    assertNull(repository.findByPhoneNumber("000000000"));
  }
}
