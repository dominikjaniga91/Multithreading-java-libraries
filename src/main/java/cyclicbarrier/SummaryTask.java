package cyclicbarrier;

import java.util.List;

class SummaryTask implements Runnable {

    private final List<Student> students;

    public SummaryTask(List<Student> students) {
        this.students = students;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Thread " + threadName + " computation");
        Integer numberOfAllStudentsDrunkBeers = students.stream()
                .map(Student::getNumberOfDrankBeers)
                .reduce(0, Integer::sum);
        System.out.println("Students drunk " + numberOfAllStudentsDrunkBeers + " beers");
    }
}
