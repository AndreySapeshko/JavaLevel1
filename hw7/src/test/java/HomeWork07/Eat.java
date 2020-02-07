package HomeWork07;

public class Eat extends Actions {
    private Cat cat;

    @Override
    public void action(int appetit, Plate plate, Cat cat) {
        plate.consumption(appetit);
        if (plate.consumption(0) > plate.consumption(appetit)) {
            cat.setFullOrHungry(true);
        }
    }
}
