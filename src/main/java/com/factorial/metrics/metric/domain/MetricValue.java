package com.factorial.metrics.metric.domain;

import com.factorial.metrics.shared.domain.InvalidArgumentException;

public class MetricValue {
    private final String value;

    public MetricValue(String value) throws InvalidArgumentException {
        ensureIsValidValue(value);
        this.value = value;
    }

    private void ensureIsValidValue(String value) throws InvalidArgumentException {
        if(value.length() < 3) {
            throw new InvalidArgumentException("<Value should be longer than 3 characters (" + value + ")");
        }
    }

    public String getValue() {
        return value;
    }
}
