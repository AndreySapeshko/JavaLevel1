public class Animal {
    public String name;
    public int weight;
    public int runSpeed;
    public int swimSpeed;
    private static int totalAnimal;

    public Animal(String name, int weight) {
        this.name = name;
        this.weight = weight;
        totalAnimal++;
        System.out.println("Констроктор Animal(name, weight)");
    }
    public Animal(String name) {
        totalAnimal++;
        this.name = name;
    }
    public Animal(int weight) {
        this.weight = weight;
        totalAnimal++;
    }
    public Animal() {
        totalAnimal++;
        System.out.println("Конструктор Animal()");
    }
    public String run(int distance){
        String s = "Не известно может ли " + name + " бегать и как быстро.";
        return s;
    }
    public String swim(int distance) {
        String s = "Не известно умеет ли " + name + " плавать и как долго.";
        return s;
    }
    public void printInfo() {
        System.out.println("Name: " + name + ". Weight: " + weight + ". RunSpeed: " + runSpeed + ". SwimSpeed: " + swimSpeed);
    }

    public int getTotalAnimal() {
        return totalAnimal;
    }
}
