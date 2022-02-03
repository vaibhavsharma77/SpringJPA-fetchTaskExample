package com.spring.transtionsexample.util;

public enum ProcessingStatus {
    ONGOING("Ongoing"),
    DONE("done"),
    ERROR("error");

    private String name;

    ProcessingStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
