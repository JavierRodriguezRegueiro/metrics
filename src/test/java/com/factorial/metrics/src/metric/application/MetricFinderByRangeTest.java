package com.factorial.metrics.src.metric.application;

import com.factorial.metrics.src.metric.domain.Metric;
import com.factorial.metrics.src.metric.domain.MetricMother;
import com.factorial.metrics.src.metric.infrastructure.persistence.InMemoryMetricRepository;
import com.factorial.metrics.src.shared.domain.InvalidArgumentException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MetricFinderByRangeTest {

    @Test
    void shouldFindMetricByRange() throws InvalidArgumentException {
        InMemoryMetricRepository repository = new InMemoryMetricRepository();
        Metric metric = MetricMother.random();
        MetricCreator creator = new MetricCreator(repository);
        MetricFinderByRange finder = new MetricFinderByRange(repository);
        creator.create(metric.getId(), metric.getTimestamp(), metric.getName(), metric.getValue());
        Metric savedMetric = finder.find(metric.getTimestamp(), metric.getTimestamp()).get(0);
        assertEquals(metric.getTimestamp(), savedMetric.getTimestamp());
    }
}
