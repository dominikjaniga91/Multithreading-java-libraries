package org.multithreading.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class ShapeAnalyzer {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Shape> shapes = List.of(new EquilateralTriangle(2d, 4d), new Square(4d));
        CountDownLatch countDownLatch = new CountDownLatch(shapes.size());
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<ShapeCalculationSummary>> shapeSummaryTaskList = new ArrayList<>();
        for (Shape shape : shapes) {
            Future<ShapeCalculationSummary> summaryFuture = executorService.submit(new ShapeCalculationTask(countDownLatch, shape));
            shapeSummaryTaskList.add(summaryFuture);
        }
        countDownLatch.await();
        executorService.shutdown();

        for (Future<ShapeCalculationSummary> future : shapeSummaryTaskList) {
            ShapeCalculationSummary shapeSummary = future.get();
            System.out.println(shapeSummary);
        }
    }
}
