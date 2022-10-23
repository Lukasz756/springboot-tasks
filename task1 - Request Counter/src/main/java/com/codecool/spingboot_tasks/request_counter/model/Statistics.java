package com.codecool.spingboot_tasks.request_counter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class Statistics {
    private String methodName;
    private int usage;
}
