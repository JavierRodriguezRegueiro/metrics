package com.factorial.metrics.src.metric.domain;

import com.factorial.metrics.src.shared.domain.InvalidArgumentException;

public class MetricTimestampMother {
    public static MetricTimestamp create(String timestamp) throws InvalidArgumentException {
        return new MetricTimestamp(timestamp);
    }

    public static MetricTimestamp random() throws InvalidArgumentException {
        return create("1652365506043");
    }
}
