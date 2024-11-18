package hw05.parser.enrichment;

import hw05.parser.messages.ConcurrentMessage;
import hw05.parser.messages.Message;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatetimeEnricherTest {

  @Test
  void shouldAddTimestampIfMissing() {
    DatetimeEnricher enricher = new DatetimeEnricher();
    Message message = new ConcurrentMessage();

    enricher.enrich(message);

    assertTrue(message.containsKey("timestamp"));
    assertNotNull(message.get("timestamp"));
  }

  @Test
  void shouldNotOverrideExistingTimestamp() {
    DatetimeEnricher enricher = new DatetimeEnricher();
    Message message = new ConcurrentMessage();
    message.put("timestamp", "2024-11-17 12:00:00");

    enricher.enrich(message);

    assertEquals("2024-11-17 12:00:00", message.get("timestamp"));
  }
}
