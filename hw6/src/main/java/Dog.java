public class Dog extends Animal {
    public  int height;
    private static int totalDog;

    public Dog(String type, String name, int weight, int runSpeed, int swimSpeed, int maxDistanceRun, int maxDistanceSwim, int height) {
        super(type, name, weight, runSpeed, swimSpeed, maxDistanceRun, maxDistanceSwim);
        this.height = height;
        totalDog++;
    }

    public Dog(String name, int weight, int height) {
        super(name, weight);
        this.height = height;
        totalDog++;
    }

    public Dog(String name, int weight) {
        super(name, weight);
        totalDog++;
    }

    public Dog(String name) {
        super(name);
        totalDog++;
    }

    public Dog(int weight) {
        super(weight);
        totalDog++;
    }

    public Dog() {
        totalDog++;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Height: " + height);
    }

    @Override
    public String run(int distance) {
        return super.run(distance);
    }

    @Override
    public String swim(int distance) {
        return super.swim(distance);
    }

    public int getTotalDog() {
        return totalDog;
    }
}
