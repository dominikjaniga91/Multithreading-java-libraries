package cyclicbarrier;

import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Program {

    public static void main(String[] args) {

        Student mark = new Student("Mark", List.of(1, 2, 3, 4, 1, 5, 6));
        Student tom = new Student("Tom", List.of(1, 2, 3, 4, 1, 5, 6));
        Student henry = new Student("Henry", List.of(1, 2, 3, 4, 1, 5, 6));
        List<Student> students = List.of(mark, tom, henry);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new SummaryTask(students));

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        long timeToWaitInMillis = 1000;
        for (int i = 1; i <= students.size(); i++) {
            executorService.execute(new StudentSummaryTask(timeToWaitInMillis * i,
                    students.get(i - 1),
                    cyclicBarrier));
        }
        executorService.shutdown();
    }
}
