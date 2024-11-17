package hw05.parser.messages;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMessage extends ConcurrentHashMap<String, String> implements Message {
  public ConcurrentMessage() {
    super();
  }

  public ConcurrentMessage(Map<String, String> original) {
    super(original);
  }
}
