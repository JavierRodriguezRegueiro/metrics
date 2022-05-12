package com.factorial.metrics.metric.domain;

import com.factorial.metrics.shared.domain.InvalidArgumentException;

public class MetricTimestampMother {
    public static MetricTimestamp create(String timestamp) throws InvalidArgumentException {
        return new MetricTimestamp(timestamp);
    }

    public static MetricTimestamp random() throws InvalidArgumentException {
        return create("1652365506043");
    }
}
