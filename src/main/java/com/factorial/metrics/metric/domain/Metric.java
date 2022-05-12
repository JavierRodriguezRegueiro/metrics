package com.factorial.metrics.metric.domain;

public class Metric {
    private final MetricTimestamp timestamp;
    private final MetricName name;
    private final MetricValue value;

    public Metric(MetricTimestamp timestamp, MetricName name, MetricValue value) {
        this.timestamp = timestamp;
        this.name = name;
        this.value = value;
    }

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
