package com.factorial.metrics.metric.application;

import com.factorial.metrics.metric.infrastructure.InMemoryMetricRepository;
import com.factorial.metrics.shared.domain.InvalidArgumentException;
import org.junit.jupiter.api.Test;

public class MetricCreatorTest {
    @Test
    void shouldCreateNewMetric() throws InvalidArgumentException {
        InMemoryMetricRepository repository = new InMemoryMetricRepository();
        MetricCreator creator = new MetricCreator(repository);
        creator.create("1234", "name", "value");
    }
}
