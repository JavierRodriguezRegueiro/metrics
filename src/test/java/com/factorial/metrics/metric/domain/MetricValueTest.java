package com.factorial.metrics.metric.domain;
import com.factorial.metrics.shared.domain.InvalidArgumentException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
