import java.util.Map;

public interface Enricher {
  void enrich(Message message);
}

public class MsisdnEnricher implements Enricher {
  private final UserRepository userRepository;

  public MsisdnEnricher(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void enrich(Message message) {
    Map<String, String> content = message.getContent();
    String msisdn = content.get("msisdn");

    if (msisdn != null) {
      User user = userRepository.findByMsisdn(msisdn);
      if (user != null) {
        content.put("firstName", user.getFirstName());
        content.put("lastName", user.getLastName());
      }
    }
  }
}
