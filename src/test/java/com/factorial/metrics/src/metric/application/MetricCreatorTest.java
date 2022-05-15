package com.factorial.metrics.src.metric.application;

import com.factorial.metrics.src.metric.domain.MetricNameMother;
import com.factorial.metrics.src.metric.domain.MetricTimestampMother;
import com.factorial.metrics.src.metric.domain.MetricValueMother;
import com.factorial.metrics.src.metric.infrastructure.InMemoryMetricRepository;
import com.factorial.metrics.src.shared.domain.IdMother;
import com.factorial.metrics.src.shared.domain.InvalidArgumentException;
import org.junit.jupiter.api.Test;

public class MetricCreatorTest {
    @Test
    void shouldCreateNewMetric() throws InvalidArgumentException {
        InMemoryMetricRepository repository = new InMemoryMetricRepository();
        MetricCreator creator = new MetricCreator(repository);
        creator.create(IdMother.random(), MetricTimestampMother.random(), MetricNameMother.random(), MetricValueMother.random());
    }
}
