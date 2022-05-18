package com.factorial.metrics.src.metric.infrastructure.persistence;

import com.factorial.metrics.src.metric.domain.Metric;
import com.factorial.metrics.src.metric.domain.MetricRepository;
import com.factorial.metrics.src.metric.domain.MetricTimestamp;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class InMemoryMetricRepository implements MetricRepository {
    private final ArrayList<Metric> metrics = new ArrayList<>();

    @Override
    public void save(Metric metric) {
        metrics.add(metric);
        System.out.println(metrics);
    }
    @Override
    public ArrayList<Metric> findByRange(MetricTimestamp init, MetricTimestamp end) {
        return (ArrayList<Metric>) metrics.stream()
                .filter(metric -> Long.parseLong(metric.getTimestamp().getTimestamp()) <= Long.parseLong(end.getTimestamp())
                        && Long.parseLong(metric.getTimestamp().getTimestamp()) >= Long.parseLong(init.getTimestamp()))
                .collect(Collectors.toList());
    }
}
