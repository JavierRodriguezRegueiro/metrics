package com.factorial.metrics.src.metric.application;

import com.factorial.metrics.src.metric.domain.*;
import com.factorial.metrics.src.shared.domain.Id;
import com.factorial.metrics.src.shared.domain.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MetricCreator {
    private final MetricRepository repository;

    @Autowired
    public MetricCreator(MetricRepository repository) {
        this.repository = repository;
    }

    public void create(Id id, MetricTimestamp timestamp, MetricName name, MetricValue value) throws InvalidArgumentException {
        repository.save(new Metric(id, timestamp, name, value));
    }
}
