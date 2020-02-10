package HomeWork07;

public class Eat extends Actions {
    private Object object;

    public Eat(Object object) {
        this.object = object;
    }

    public Eat() {

    }

    @Override
    public boolean action(Plate plate, int appetit) {
        plate.consumption(appetit);
        if (plate.consumption(0) > plate.consumption(appetit)) {
            return true;
        }
        return false;
    }

    public void action(Plate plate, Cat cat) {
        plate.consumption(cat.getAppetit());
        if (plate.getEatOrNot()) {
            cat.setFullOrHungry(true);
            System.out.println("Кот " + cat.getName() + " накормлен! Корма осталось: " + plate.balance());
        }
    }
}
