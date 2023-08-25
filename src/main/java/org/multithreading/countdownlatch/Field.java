package org.multithreading.countdownlatch;

class Field {

    private final Double value;

    public Field(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
