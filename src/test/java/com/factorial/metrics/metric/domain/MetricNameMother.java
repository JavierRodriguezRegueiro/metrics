package com.factorial.metrics.metric.domain;

import com.factorial.metrics.shared.domain.InvalidArgumentException;

public class MetricNameMother {
    public static MetricName create(String name) throws InvalidArgumentException {
        return new MetricName(name);
    }

    public static MetricName random() throws InvalidArgumentException {
        return create("Name");
    }
}
