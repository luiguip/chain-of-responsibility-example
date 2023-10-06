package com.github.luiguip.chainofresponsabilityexample.freight;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TextHandlerChain {

  private final List<Handler> textHandlers;


  public TextHandlerChain(List<Handler> textHandlers) {
    this.textHandlers = textHandlers;
  }

  public void send(Message message) {
    textHandlers.stream()
        .filter(h -> h.test(message))
        .findFirst()
        .ifPresent(h -> h.accept(message));
  }
}
