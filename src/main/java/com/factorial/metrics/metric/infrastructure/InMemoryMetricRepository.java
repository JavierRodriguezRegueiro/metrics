package com.factorial.metrics.metric.infrastructure;

import com.factorial.metrics.metric.domain.Metric;
import com.factorial.metrics.metric.domain.MetricRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class InMemoryMetricRepository implements MetricRepository {
    private final ArrayList<Metric> metrics = new ArrayList<>();
    @Override
    public void save(Metric metric) {
        metrics.add(metric);
        System.out.println(metrics);
    }
}
