package org.multithreading.countdownlatch;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

class ShapeCalculationTask implements Callable<ShapeCalculationSummary> {

    private final CountDownLatch latch;
    private final Shape shape;

    ShapeCalculationTask(CountDownLatch latch, Shape shape) {
        this.latch = latch;
        this.shape = shape;
    }

    @Override
    public ShapeCalculationSummary call() {
        try {
            String shapeName = this.shape.getClass().getSimpleName();
            Circumference circumference = this.shape.calculateCircumference();
            Field field = this.shape.calculateField();
            return new ShapeCalculationSummary(shapeName, circumference, field);
        } finally {
            this.latch.countDown();
        }
    }
}
