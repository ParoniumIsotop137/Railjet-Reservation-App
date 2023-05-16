package com.example.ferenc.railjet_reservation_app.train;

public enum ClassType {

    PREMIUM("Premium class"), BUSINESS("Business class"), ECONOMY("Economy class");

    private final String className;

    ClassType(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return className;
    }
}
