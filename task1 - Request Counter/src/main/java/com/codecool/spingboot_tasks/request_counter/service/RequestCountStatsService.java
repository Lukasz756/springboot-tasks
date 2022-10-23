package com.codecool.spingboot_tasks.request_counter.service;

import com.codecool.spingboot_tasks.request_counter.controller.RequestCounterController;
import com.codecool.spingboot_tasks.request_counter.model.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class RequestCountStatsService {

    public static String GET = "GET";
    public static String POST = "POST";
    public static String PUT = "PUT";
    public static String DELETE = "DELETE";
    public static String PATCH = "PATCH";
    /*
     * Map holding statistics of methods execution. key is method name: GET,PUT etc.
     * value is and integer number representing number of executions
     */
    private final Map<String, Integer> stats = new HashMap<>();


    public void increaseCounter(String method) throws Exception {
        if (stats.get(method) == null) {
            stats.put(method, 1);
        } else {
            int counter = stats.get(method);
            counter++;
            stats.replace(method, counter);
        }

    }

    public List<Statistics> getStatistics() {
        List<Statistics> result = new LinkedList<>();
        for(String key: stats.keySet()){
            result.add(new  Statistics(key,stats.get(key)));
        }
        return result;
    }
}