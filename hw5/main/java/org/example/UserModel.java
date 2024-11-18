package hw05.database.models;

/**
 * Модель данных пользователя.
 * <p>Класс описывает строку таблицы базы данных. Все поля обязательны для заполнения.</p>
 */
public class UserModel {
  private final String firstName;
  private final String lastName;
  private final String phoneNumber;

  /**
   * Конструктор пользователя.
   *
   * @param firstName имя пользователя.
   * @param lastName фамилия пользователя.
   * @param phoneNumber номер телефона пользователя.
   * @throws IllegalArgumentException если одно из полей не заполнено.
   */
  public UserModel(String firstName, String lastName, String phoneNumber) {
    if (firstName == null || lastName == null || phoneNumber == null) {
      throw new IllegalArgumentException("Все поля пользователя должны быть заполнены.");
    }
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof UserModel)) {
      return false;
    }
    UserModel otherUser = (UserModel) obj;
    return this.firstName.equals(otherUser.firstName) &&
        this.lastName.equals(otherUser.lastName) &&
        this.phoneNumber.equals(otherUser.phoneNumber);
  }

  @Override
  public String toString() {
    return "UserModel{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        '}';
  }
}
