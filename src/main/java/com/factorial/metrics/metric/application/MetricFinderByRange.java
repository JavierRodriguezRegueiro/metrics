package com.factorial.metrics.metric.application;

import com.factorial.metrics.metric.domain.Metric;
import com.factorial.metrics.metric.domain.MetricRepository;
import com.factorial.metrics.metric.domain.MetricTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MetricFinderByRange {
    private final MetricRepository repository;

    @Autowired
    public MetricFinderByRange(MetricRepository repository) {
        this.repository = repository;
    }

    public ArrayList<Metric> find(MetricTimestamp init, MetricTimestamp end) {
        return repository.findByRange(init, end);
    }
}
