package com.github.luiguip.chainofresponsabilityexample;

import com.github.luiguip.chainofresponsabilityexample.freight.Message;
import com.github.luiguip.chainofresponsabilityexample.freight.TextHandlerChain;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChainOfResponsibilityExampleApplication implements CommandLineRunner {

  private final TextHandlerChain textHandlerChain;

  public ChainOfResponsibilityExampleApplication(TextHandlerChain textHandlerChain) {
    this.textHandlerChain = textHandlerChain;
  }

  public static void main(String[] args) {
    SpringApplication.run(ChainOfResponsibilityExampleApplication.class, args);
  }

  @Override
  public void run(String... args) {
    var messages = List.of(
        new Message("Important text", true),
        new Message("Short text", false),
        new Message("Long text!".repeat(50), false)
    );
    messages.forEach(textHandlerChain::send);
  }
}
