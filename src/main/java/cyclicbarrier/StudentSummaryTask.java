package cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class StudentSummaryTask implements Runnable {

    private final long timeToWaitInMillis;
    private final Student student;
    private final CyclicBarrier cyclicBarrier;

    public StudentSummaryTask(long timeToWaitInMillis, Student student, CyclicBarrier cyclicBarrier) {
        this.timeToWaitInMillis = timeToWaitInMillis;
        this.student = student;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Thread " + threadName + " computation");
        int drunkBeers = this.student.sumBeers();
        this.student.setNumberOfDrankBeers(drunkBeers);
        System.out.println("Student " + student.getName() + " drunk " + drunkBeers + " beers");
        try {
            Thread.sleep(timeToWaitInMillis);
            System.out.println("Thread " + threadName + " finished");
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
