package com.github.luiguip.chainofresponsabilityexample.freight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DefaultTextHandler implements Handler {

  private static final Logger log = LoggerFactory.getLogger(DefaultTextHandler.class);

  @Override
  public void accept(Message message) {
    log.info("Send message via email. message: {}", message.text());
  }

  @Override
  public boolean test(Message message) {
    return true;
  }

  @Override
  public int getOrder() {
    return LOWEST_PRECEDENCE;
  }
}
