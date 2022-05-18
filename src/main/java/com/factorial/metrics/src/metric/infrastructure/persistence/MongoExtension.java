package com.factorial.metrics.src.metric.infrastructure.persistence;

import com.factorial.metrics.src.metric.domain.Metric;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MongoExtension extends MongoRepository<Metric, String> {}
