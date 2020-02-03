public class Dog extends Animal {
    public  int height;
    private static int totalDog;

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

    public String run(int distance) {
        String s = "Dog " + name + " пробежал " + distance;
        if (distance < 500) {
            if (runSpeed > 0) {
                s += " за " + distance/runSpeed + " с.";
            }
        } else {
            s = "Так далеко собаки не бегают!";
        }
        return s;
    }

    public String swim(int distance) {
        String s = "Dog " + name + "проплыл " + distance;
        if (distance < 10) {
            if (runSpeed > 0) {
                s += " за " + distance/swimSpeed + " с.";
            }
        } else {
            s = "Так далеко собаки не плавают!";
        }
        return s;
    }
    public int getTotalDog() {
        return totalDog;
    }
}
