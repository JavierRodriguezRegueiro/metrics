package com.factorial.metrics.metric.domain;

import com.factorial.metrics.shared.domain.InvalidArgumentException;

public class MetricMother {
    private static Metric create(MetricTimestamp timestamp, MetricName name, MetricValue value) {
        return new Metric(timestamp, name, value);
    }

    private static Metric random() throws InvalidArgumentException {
        return create(MetricTimestampMother.random(), MetricNameMother.random(), MetricValueMother.random());
    }
}
