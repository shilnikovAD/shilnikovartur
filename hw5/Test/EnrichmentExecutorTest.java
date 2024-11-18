package hw05.parser.enrichment;

import hw05.parser.messages.ConcurrentMessage;
import hw05.parser.messages.Message;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EnrichmentExecutorTest {

  @Test
  void shouldApplyAllEnrichersToMessage() {
    MessageEnricher enricher1 = mock(MessageEnricher.class);
    MessageEnricher enricher2 = mock(MessageEnricher.class);

    EnrichmentExecutor executor = new EnrichmentExecutor(List.of(enricher1, enricher2));
    Message message = new ConcurrentMessage();

    executor.enrichMessage(message);

    verify(enricher1, times(1)).enrich(message);
    verify(enricher2, times(1)).enrich(message);
  }

  @Test
  void shouldReturnEnrichedMessage() {
    MessageEnricher enricher = mock(MessageEnricher.class);
    EnrichmentExecutor executor = new EnrichmentExecutor(List.of(enricher));
    Message inputMessage = new ConcurrentMessage();

    Message outputMessage = executor.enrichMessage(inputMessage);

    assertNotNull(outputMessage);
    assertEquals(inputMessage, outputMessage);
  }
}
