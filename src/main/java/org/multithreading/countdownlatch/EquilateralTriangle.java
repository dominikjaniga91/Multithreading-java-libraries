package org.multithreading.countdownlatch;

class EquilateralTriangle implements Shape {

    private final Double base;
    private final Double height;

    public EquilateralTriangle(Double base, Double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public Circumference calculateCircumference() {
        return new Circumference(3 * base);
    }

    @Override
    public Field calculateField() {
        return new Field(base * height / 2);
    }
}
