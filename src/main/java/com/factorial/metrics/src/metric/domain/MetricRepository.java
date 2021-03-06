package com.factorial.metrics.src.metric.domain;

import java.util.ArrayList;

public interface MetricRepository {
    void save(Metric metric);
    ArrayList<Metric> findByRange(MetricTimestamp init, MetricTimestamp end);
}
