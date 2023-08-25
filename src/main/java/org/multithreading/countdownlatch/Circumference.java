package org.multithreading.countdownlatch;

class Circumference {

    private final Double value;

    public Circumference(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
