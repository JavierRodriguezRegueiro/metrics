package com.factorial.metrics.src.metric.domain;

import com.factorial.metrics.src.shared.domain.InvalidArgumentException;

public class MetricName {
    private final String name;

    public MetricName(String name) throws InvalidArgumentException {
        ensureIsValidName(name);
        this.name = name;
    }

    private void ensureIsValidName(String name) throws InvalidArgumentException {
        if(name.length() < 3) {
            throw new InvalidArgumentException("<Name should be longer than 3 characters (" + name + ")");
        }
    }

    public String getName() {
        return name;
    }
}
