package hw05.database.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserModelTest {

  @Test
  void shouldCreateUserWithValidData() {
    UserModel user = new UserModel("John", "Doe", "123456789");
    assertEquals("John", user.getFirstName());
    assertEquals("Doe", user.getLastName());
    assertEquals("123456789", user.getPhoneNumber());
  }

  @Test
  void shouldThrowExceptionIfAnyFieldIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new UserModel(null, "Doe", "123456789"));
    assertThrows(IllegalArgumentException.class, () -> new UserModel("John", null, "123456789"));
    assertThrows(IllegalArgumentException.class, () -> new UserModel("John", "Doe", null));
  }

  @Test
  void testEqualsAndHashCode() {
    UserModel user1 = new UserModel("Alice", "Smith", "987654321");
    UserModel user2 = new UserModel("Alice", "Smith", "987654321");

    assertEquals(user1, user2);
    assertNotSame(user1, user2);
  }

  @Test
  void testToString() {
    UserModel user = new UserModel("Jane", "Doe", "555123456");
    assertTrue(user.toString().contains("Jane"));
    assertTrue(user.toString().contains("Doe"));
    assertTrue(user.toString().contains("555123456"));
  }
}
