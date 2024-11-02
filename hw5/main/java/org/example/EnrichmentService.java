import java.util.HashMap;
import java.util.Map;

public class EnrichmentService {
  private final Map<Message.EnrichmentType, Enricher> enrichers = new HashMap<>();

  public EnrichmentService(UserRepository userRepository) {
    enrichers.put(Message.EnrichmentType.MSISDN, new MsisdnEnricher(userRepository));
  }

  public Message enrich(Message message) {
    Enricher enricher = enrichers.get(message.getEnrichmentType());
    if (enricher != null) {
      enricher.enrich(message);
    }
    return message;
  }
}
