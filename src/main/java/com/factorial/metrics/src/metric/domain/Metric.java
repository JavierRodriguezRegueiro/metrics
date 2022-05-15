package com.factorial.metrics.src.metric.domain;

import com.factorial.metrics.src.shared.domain.Id;

public class Metric {
    private final Id id;
    private final MetricTimestamp timestamp;
    private final MetricName name;
    private final MetricValue value;

    public Metric(Id id, MetricTimestamp timestamp, MetricName name, MetricValue value) {
        this.id = id;
        this.timestamp = timestamp;
        this.name = name;
        this.value = value;
    }

    public Id getId() { return id; }

    public MetricTimestamp getTimestamp() {
        return timestamp;
    }

    public MetricName getName() {
        return name;
    }

    public MetricValue getValue() {
        return value;
    }
}
