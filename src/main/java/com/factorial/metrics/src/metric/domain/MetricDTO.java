package com.factorial.metrics.src.metric.domain;

public class MetricDTO {
    private final String id;
    private final String timestamp;
    private final String name;
    private final String value;

    public MetricDTO(String id, String timestamp, String name, String value) {
        this.id = id;
        this.timestamp = timestamp;
        this.name = name;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
