package cyclicbarrier;

import java.util.List;

class Student {

    private final String name;
    private final List<Integer> drankBeers;
    private int numberOfDrankBeers;

    public Student(String name, List<Integer> drankBeers) {
        this.name = name;
        this.drankBeers = drankBeers;
    }

    public String getName() {
        return name;
    }

    public void setNumberOfDrankBeers(int numberOfDrankBeers) {
        this.numberOfDrankBeers = numberOfDrankBeers;
    }

    public int getNumberOfDrankBeers() {
        return numberOfDrankBeers;
    }

    int sumBeers() {
        return this.drankBeers.stream().reduce(0, Integer::sum);
    }
}

