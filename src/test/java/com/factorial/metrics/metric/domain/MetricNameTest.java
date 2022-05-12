package com.factorial.metrics.metric.domain;
import com.factorial.metrics.shared.domain.InvalidArgumentException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
