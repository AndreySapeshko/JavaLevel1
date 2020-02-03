public class Cat extends Animal {
    public int tailLength;
    private static int totalCat;

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

    public String run(int distance) {
        String s = "Cat " + name + " пробежал " + distance;
        if (distance < 200) {
            if (runSpeed > 0) {
                s += " за " + distance/runSpeed + " с.";
            }
        } else {
            s = "Так далеко коты не бегают!";
        }
        return s;
    }

    public String swim(int distance) {
        String s = "Коты не плавают!";
        return s;
    }

    public int getTotalCat() {
        return totalCat;
    }
}
