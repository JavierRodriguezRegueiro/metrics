package com.factorial.metrics.shared.domain;

public class IdMother {
    public static Id create(String id) throws InvalidArgumentException {
        return Id.createIdFromString(id);
    }

    public static Id random() throws InvalidArgumentException {
        return create("a1f4b01a-3ba3-47d8-8fa9-4be04abff077");
    }
}
