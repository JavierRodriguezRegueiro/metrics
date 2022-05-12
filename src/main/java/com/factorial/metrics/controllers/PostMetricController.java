package com.factorial.metrics.controllers;

import com.factorial.metrics.metric.application.MetricCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostMetricController {
    private final MetricCreator metricCreator;

    @Autowired
    public PostMetricController(MetricCreator metricCreator) {
        this.metricCreator = metricCreator;
    }

    @PostMapping(path = "/metrics")
    public ResponseEntity<String> run(@RequestParam("timestamp") String timestamp, @RequestParam("name") String name, @RequestParam("value") String value) {
        try {
            this.metricCreator.create(timestamp, name, value);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
