package com.factorial.metrics.metric.domain;

import com.factorial.metrics.shared.domain.InvalidArgumentException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
