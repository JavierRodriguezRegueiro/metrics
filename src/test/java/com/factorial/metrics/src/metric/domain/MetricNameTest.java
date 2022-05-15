package com.factorial.metrics.src.metric.domain;

import com.factorial.metrics.src.shared.domain.InvalidArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MetricNameTest {
    @Test
    void createNameWithoutError() throws InvalidArgumentException {
        String stringName = "Name";
        MetricName name = new MetricName(stringName);
        assertEquals(name.getName(), stringName);
    }

    @Test
    void shouldThrowIfNameLengthIsLowerThanThree() {
        assertThrows(InvalidArgumentException.class, () -> {
            new MetricName("");
        });
    }
}
