package com.github.luiguip.chainofresponsabilityexample.freight;

import java.util.function.Consumer;
import java.util.function.Predicate;
import org.springframework.core.Ordered;

public interface Handler extends Consumer<Message>, Predicate<Message>, Ordered {
}
