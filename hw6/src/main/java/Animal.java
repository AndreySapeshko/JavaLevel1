public class Animal {
    public String type;
    public String name;
    public int weight;
    public int runSpeed;
    public int swimSpeed;
    private static int totalAnimal;
    public int maxDistanceRun;
    public int maxDistanceSwim;

    public Animal(String type, String name, int weight, int runSpeed, int swimSpeed, int maxDistanceRun, int maxDistanceSwim) {
        this.type = type;
        this.name = name;
        this.weight = weight;
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
        this.maxDistanceRun = maxDistanceRun;
        this.maxDistanceSwim = maxDistanceSwim;
        totalAnimal++;
    }

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
        String s = type + " " + name + " пробежал " + distance + " m";
        if (maxDistanceRun <= 0) {
            s = type + " " + name + " не бегает.";
        } else if (distance > maxDistanceRun){
            s = "Так далеко не побежит!";
        } else if (runSpeed > 0) {
            s += " за " + distance/runSpeed + " с.";
        }
        return s;
    }
    public String swim(int distance) {
        String s = type + " " + name + " проплыл " + distance + " m";
        if (maxDistanceSwim <= 0) {
            s = type + " " + name + " не плавает.";
        } else if (distance > maxDistanceSwim){
            s = "Так далеко не поплывет!";
        } else if (swimSpeed > 0) {
            s += " за " + distance/swimSpeed + " с.";
        }
        return s;
    }
    public void printInfo() {
        System.out.println(type + " Name: " + name + ". Weight: " + weight + ". maxDistanceRun: " + maxDistanceRun + ". RunSpeed: " + runSpeed + ". maxDistanceSwim: " + maxDistanceSwim + ". SwimSpeed: " + swimSpeed);
    }

    public int getTotalAnimal() {
        return totalAnimal;
    }
}
