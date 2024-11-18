package hw05.parser.enrichment;

import hw05.parser.messages.Message;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Добавляет временную метку к сообщению, если она отсутствует.
 */
public class DatetimeEnricher implements MessageEnricher {
  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  @Override
  public void enrich(Message message) {
    if (!message.containsKey("timestamp")) {
      message.put("timestamp", LocalDateTime.now().format(FORMATTER));
    }
  }
}
