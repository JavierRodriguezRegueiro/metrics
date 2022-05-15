package com.factorial.metrics.metric.infrastructure;

import com.factorial.metrics.metric.domain.Metric;
import com.factorial.metrics.metric.domain.MetricRepository;
import com.factorial.metrics.metric.domain.MetricTimestamp;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
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
