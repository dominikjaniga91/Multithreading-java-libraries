package org.multithreading.countdownlatch;

class Square implements Shape {

    private final Double side;

    public Square(Double side) {
        this.side = side;
    }

    @Override
    public Circumference calculateCircumference() {
        return new Circumference(4 * side);
    }

    @Override
    public Field calculateField() {
        return new Field(Math.pow(side, 2));
    }
}
