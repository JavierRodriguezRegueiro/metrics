package com.factorial.metrics.src.metric.domain;

import com.factorial.metrics.src.shared.domain.InvalidArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MetricTimestampTest {
    @Test
    void createTimestampWithoutError() throws InvalidArgumentException {
        String stringTimestamp = "12345";
        MetricTimestamp timestamp = new MetricTimestamp(stringTimestamp);
        assertEquals(timestamp.getTimestamp(), stringTimestamp);
    }

    @Test
    void shouldThrowErrorIfTimestampLengthIsZero() {
        assertThrows(InvalidArgumentException.class, () -> {
            new MetricTimestamp("");
        });
    }

    @Test
    void shouldThrowErrorIfTimestampHasCharacters() {
        assertThrows(InvalidArgumentException.class, () -> {
            new MetricTimestamp("123s");
        });
    }
}
