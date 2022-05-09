package com.factorial.metrics.metric.domain;

import java.sql.Timestamp;

public class Metric {
    private final Timestamp timestamp;
    private final String name;
    private final String value;

    public Metric(Timestamp timestamp, String name, String value) {
        this.timestamp = timestamp;
        this.name = name;
        this.value = value;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
