package HomeWork07;

public class Cat {
    private String name;
    private int appetit;
    private boolean fullOrHungry;

    public Cat(String name, int appetit, boolean fullOrHungry) {
        this.name = name;
        this.appetit = appetit;
        this.fullOrHungry = fullOrHungry;
    }

    public void setFullOrHungry(boolean b) {
        this.fullOrHungry = b;
    }
}
