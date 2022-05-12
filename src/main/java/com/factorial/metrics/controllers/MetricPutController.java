package com.factorial.metrics.controllers;

import com.factorial.metrics.metric.application.MetricCreator;
import com.factorial.metrics.metric.domain.MetricName;
import com.factorial.metrics.metric.domain.MetricTimestamp;
import com.factorial.metrics.metric.domain.MetricValue;
import com.factorial.metrics.shared.domain.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MetricPutController {
    private final MetricCreator metricCreator;

    @Autowired
    public MetricPutController(MetricCreator metricCreator) {
        this.metricCreator = metricCreator;
    }

    @PutMapping(path = "/metrics/{id}")
    public ResponseEntity<String> run(@PathVariable String id, @RequestParam("timestamp") String timestamp, @RequestParam("name") String name, @RequestParam("value") String value) {
        try {
            this.metricCreator.create(Id.createIdFromString(id), new MetricTimestamp(timestamp), new MetricName(name), new MetricValue(value));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
