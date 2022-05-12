package com.factorial.metrics.shared.domain;

import java.util.UUID;

public class Id {
    private final UUID id;

    private Id(UUID id) {
        this.id = id;
    }

    public static Id createIdFromString(String value) throws InvalidArgumentException {
        if(!isValidId(value)) {
            throw new  InvalidArgumentException("Invalid UUID value ("+value+")");
        }
        return new Id(UUID.fromString(value));
    }

    private static boolean isValidId(String id) {
        try {
            UUID.fromString(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public UUID getId() {
        return id;
    }
}
