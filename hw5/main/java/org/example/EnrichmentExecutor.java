package hw05.parser.enrichment;

import hw05.parser.messages.Message;
import hw05.parser.messages.ConcurrentMessage;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class EnrichmentExecutor {
  private final List<MessageEnricher> enrichers;

  public EnrichmentExecutor(List<MessageEnricher> enrichers) {
    this.enrichers = enrichers;
  }

  public Message enrichMessage(Message input) {
    Message enrichedMessage = new ConcurrentMessage(input);

    CompletableFuture<Void> allTasks = CompletableFuture.allOf(
        enrichers.stream()
            .map(enricher -> CompletableFuture.runAsync(() -> enricher.enrich(enrichedMessage)))
            .toArray(CompletableFuture[]::new)
    );

    allTasks.join();
    return enrichedMessage;
  }
}
