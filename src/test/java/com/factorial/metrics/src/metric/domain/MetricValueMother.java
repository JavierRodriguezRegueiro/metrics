package com.factorial.metrics.src.metric.domain;

import com.factorial.metrics.src.shared.domain.InvalidArgumentException;

public class MetricValueMother {
    public static MetricValue create(String value) throws InvalidArgumentException {
        return new MetricValue(value);
    }

    public static MetricValue random() throws InvalidArgumentException {
        return create("value");
    }
}
