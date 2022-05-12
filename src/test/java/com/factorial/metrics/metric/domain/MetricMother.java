package com.factorial.metrics.metric.domain;

import com.factorial.metrics.shared.domain.Id;
import com.factorial.metrics.shared.domain.IdMother;
import com.factorial.metrics.shared.domain.InvalidArgumentException;

public class MetricMother {
    private static Metric create(Id id, MetricTimestamp timestamp, MetricName name, MetricValue value) {
        return new Metric(id, timestamp, name, value);
    }

    private static Metric random() throws InvalidArgumentException {
        return create(IdMother.random(), MetricTimestampMother.random(), MetricNameMother.random(), MetricValueMother.random());
    }
}
