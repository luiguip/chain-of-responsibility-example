package com.github.luiguip.chainofresponsabilityexample.freight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ImportantTextHandler implements Handler{

  private static final Logger log = LoggerFactory.getLogger(ImportantTextHandler.class);

  @Value("${text-handler.important.order}")
  private int order;

  @Override
  public void accept(Message message) {
    log.info("Call client. message: {}", message.text());
  }

  @Override
  public boolean test(Message message) {
    return message.important();
  }

  @Override
  public int getOrder() {
    return order;
  }
}
