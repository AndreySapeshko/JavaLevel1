public class Cat extends Animal {
    public int tailLength;
    private static int totalCat;

    public Cat(String type, String name, int weight, int runSpeed, int swimSpeed, int maxDistanceRun, int maxDistanceSwim, int tailLength) {
        super(type, name, weight, runSpeed, swimSpeed, maxDistanceRun, maxDistanceSwim);
        this.tailLength = tailLength;
        totalCat++;
    }

    public Cat(String name) {
        super(name);
        totalCat++;
    }

    public Cat(String name, int weight) {
        super(name, weight);
        totalCat++;
    }

    public Cat(String name, int weight, int tailLength) {
        super(name, weight);
        this.tailLength = tailLength;
        totalCat++;
    }

    public Cat(int weight, int tailLength) {
        super(weight);
        this.tailLength = tailLength;
        totalCat++;
    }

    public Cat(int tailLength) {
        this.tailLength = tailLength;
        totalCat++;
    }
    public Cat() {
        totalCat++;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("TailLength: " + tailLength);
    }

    @Override
    public String run(int distance) {
        return super.run(distance);
    }

    @Override
    public String swim(int distance) {
        return super.swim(distance);
    }

    public int getTotalCat() {
        return totalCat;
    }
}
