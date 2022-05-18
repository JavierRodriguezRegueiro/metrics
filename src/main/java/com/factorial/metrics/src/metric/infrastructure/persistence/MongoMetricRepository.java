package com.factorial.metrics.src.metric.infrastructure.persistence;

import com.factorial.metrics.src.metric.domain.Metric;
import com.factorial.metrics.src.metric.domain.MetricRepository;
import com.factorial.metrics.src.metric.domain.MetricTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MongoMetricRepository implements MetricRepository {
    private final MongoExtension mongo;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public MongoMetricRepository(MongoExtension mongo, MongoTemplate mongoTemplate) {
        this.mongo = mongo;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void save(Metric metric) {
        this.mongo.save(metric);
    }

    @Override
    public ArrayList<Metric> findByRange(MetricTimestamp init, MetricTimestamp end) {
        Query query = new Query();
        query.addCriteria(Criteria.where("timestamp").gte(init).lt(end));
        return  (ArrayList<Metric>) this.mongoTemplate.find(query, Metric.class);
    }
}
