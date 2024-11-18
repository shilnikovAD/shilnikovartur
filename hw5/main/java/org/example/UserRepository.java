import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public interface UserRepository {
  User findByMsisdn(String msisdn);
  void updateUserByMsisdn(String msisdn, User user);
}

public class InMemoryUserRepository implements UserRepository {
  private final ConcurrentMap<String, User> userMap = new ConcurrentHashMap<>();

  @Override
  public User findByMsisdn(String msisdn) {
    return userMap.get(msisdn);
  }

  @Override
  public void updateUserByMsisdn(String msisdn, User user) {
    userMap.put(msisdn, user);
  }
}
