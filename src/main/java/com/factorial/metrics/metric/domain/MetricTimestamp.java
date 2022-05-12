package com.factorial.metrics.metric.domain;

import com.factorial.metrics.shared.domain.InvalidArgumentException;

public class MetricTimestamp {
    private final String timestamp;

    public MetricTimestamp(String timestamp) throws InvalidArgumentException {
        ensureIsValidTimestamp(timestamp);
        this.timestamp = timestamp;
    }

    private void ensureIsValidTimestamp(String timestamp) throws InvalidArgumentException {
        if(timestamp.length() < 1 || !isNumeric(timestamp)) {
            throw new InvalidArgumentException("<Timestamp should receive a valid value (" + timestamp + ")");
        }
    }

    private boolean isNumeric(String timestamp) {
        try {
            Long.parseLong(timestamp);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String getTimestamp() {
        return timestamp;
    }
}
