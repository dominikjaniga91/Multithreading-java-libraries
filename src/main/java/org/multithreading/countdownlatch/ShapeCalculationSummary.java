package org.multithreading.countdownlatch;

class ShapeCalculationSummary {
    private final String shapeName;
    private final Circumference circumference;
    private final Field field;

    ShapeCalculationSummary(String shapeName, Circumference circumference, Field field) {
        this.shapeName = shapeName;
        this.circumference = circumference;
        this.field = field;
    }

    @Override
    public String toString() {
        return String.format("shape name: %s, circumference: %s, field: %s", shapeName, circumference, field);
    }
}
