package HomeWork07;

public class Cat {
    private String name;
    private int appetit;
    private boolean fullOrHungry;
    static int score;
    private String id;

    public Cat(String name, int appetit, boolean fullOrHungry) {
        this.name = name;
        this.appetit = appetit;
        this.fullOrHungry = fullOrHungry;
        score++;
        id = "Cat" + score;
    }

    public void setFullOrHungry(boolean b) {
        this.fullOrHungry = b;
    }

    public boolean getFullOrHungry() {
        return  fullOrHungry;
    }

    public int getAppetit() {
        return appetit;
    }

    public String getName() {
        return name;
    }
}
