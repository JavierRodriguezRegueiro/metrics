package com.factorial.metrics.web.api.controllers;

import com.factorial.metrics.src.metric.application.MetricCreator;
import com.factorial.metrics.src.metric.domain.MetricName;
import com.factorial.metrics.src.metric.domain.MetricTimestamp;
import com.factorial.metrics.src.metric.domain.MetricValue;
import com.factorial.metrics.src.shared.domain.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
public class MetricPutController {
    private final MetricCreator metricCreator;

    @Autowired
    public MetricPutController(MetricCreator metricCreator) {
        this.metricCreator = metricCreator;
    }

    @CrossOrigin
    @PutMapping(path = "/metrics/{id}")
    public ResponseEntity<String> run(@PathVariable String id, @RequestBody Request request) {
        try {
            this.metricCreator.create(Id.createIdFromString(id), new MetricTimestamp(request.getTimestamp()), new MetricName(request.getName()), new MetricValue(request.getValue()));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

final class Request {
    private String timestamp;
    private String name;
    private String value;

    public String getTimestamp() {
        return timestamp;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
