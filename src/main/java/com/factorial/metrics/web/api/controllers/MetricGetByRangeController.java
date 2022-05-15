package com.factorial.metrics.web.api.controllers;

import com.factorial.metrics.src.metric.application.MetricFinderByRange;
import com.factorial.metrics.src.metric.domain.MetricDTO;
import com.factorial.metrics.src.metric.domain.MetricTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MetricGetByRangeController {
    private final MetricFinderByRange finder;

    @Autowired
    public MetricGetByRangeController(MetricFinderByRange finder) {
        this.finder = finder;
    }

    @CrossOrigin
    @GetMapping(path = "/metrics")
    public ResponseEntity<ArrayList<MetricDTO>> run(@RequestParam("init") String init, @RequestParam("end") String end)  {
        try {
            ArrayList<MetricDTO> metrics = new ArrayList<>();
            finder.find(new MetricTimestamp(init), new MetricTimestamp(end))
                   .forEach(metric -> metrics.add(new MetricDTO(metric.getId().toString(), metric.getTimestamp().getTimestamp(), metric.getName().getName(), metric.getValue().getValue())));
            return ResponseEntity.ok().body(metrics);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(new ArrayList<>());
        }
    }
}
