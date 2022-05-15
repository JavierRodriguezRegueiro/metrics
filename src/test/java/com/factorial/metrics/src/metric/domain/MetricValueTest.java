package com.factorial.metrics.src.metric.domain;

import com.factorial.metrics.src.shared.domain.InvalidArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MetricValueTest {
    @Test
    void createValueWithoutError() throws InvalidArgumentException {
        String stringValue = "value";
        MetricValue value = new MetricValue(stringValue);
        assertEquals(value.getValue(), stringValue);
    }

    @Test
    void shouldThrowIfValueLengthIsLowerThanThree() {
        assertThrows(InvalidArgumentException.class, () -> {
            new MetricValue("");
        });
    }
}
