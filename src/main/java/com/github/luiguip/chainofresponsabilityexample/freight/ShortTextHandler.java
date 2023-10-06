package com.github.luiguip.chainofresponsabilityexample.freight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ShortTextHandler implements Handler{

  private static final Logger log = LoggerFactory.getLogger(ShortTextHandler.class);

  @Value("${text-handler.short.order}")
  private int order;

  @Override
  public void accept(Message message) {
    log.info("Send a message via WhatsApp. message: {}", message.text());
  }

  @Override
  public boolean test(Message message) {
    return message.text().length() < 500;
  }

  @Override
  public int getOrder() {
    return order;
  }
}
