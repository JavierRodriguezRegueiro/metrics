package com.factorial.metrics.metric.domain;

import com.factorial.metrics.shared.domain.InvalidArgumentException;

public class MetricValueMother {
    public static MetricValue create(String value) throws InvalidArgumentException {
        return new MetricValue(value);
    }

    public static MetricValue random() throws InvalidArgumentException {
        return create("value");
    }
}
