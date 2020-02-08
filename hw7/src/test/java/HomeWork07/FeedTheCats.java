package HomeWork07;

import java.util.ArrayList;

public class FeedTheCats implements FeedTheCatsIF {

    public static void main(String[] args) {

        FeedTheCats feedCats = new FeedTheCats();

        ArrayList<Cat> cats = new ArrayList<Cat>();
        cats.add(new Cat("Кузя",5, false));
        cats.add(new Cat("Стас",11, true));
        cats.add(new Cat("Рысь",7, false));
        cats.add(new Cat("Дрон",8, true));
        cats.add(new Cat("Маруся",3, false));

        for (int i = 0; i < cats.size(); i++) {
            System.out.println(i + 1 + " " + feedCats.fullOrHungryCat(cats.get(i)));
        }

        Plate plate = new Plate("Plate for Cats", 50);
        feedCats.verifyPlate(plate);

        Eat eat = new Eat();

        for (int i = 0; i < cats.size(); i++) {
            feedCats.feedCats(cats.get(i), plate, eat);
        }

        for (int i = 0; i < cats.size(); i++) {
            System.out.println(i + 1 + " " + feedCats.fullOrHungryCat(cats.get(i)));
        }
        System.out.println(plate.balance());

    }
    @Override
    public void verifyPlate(Plate plate) {
        if (plate.getMaxVolum() / 2 > plate.balance()) {
            plate.arrival((plate.getMaxVolum() - plate.balance()));
        }
        System.out.println("В тарелке есть корм. Можно кормить котов. Корма: " + plate.balance());
    }

    @Override
    public String fullOrHungryCat(Cat cat) {
        String msg = "Кот " + cat.getName();
        msg = (cat.getFullOrHungry()) ? msg  + " сыт." : msg + " голоден.";
        return msg;
    }

    @Override
    public void feedCats(Cat cat, Plate plate) {
        while (!cat.getFullOrHungry()) {
            new Eat(cat).action(plate, cat.getAppetit());
            verifyPlate(plate);
        }

    }

    public void feedCats(Cat cat, Plate plate, Eat eat) {
        if (!cat.getFullOrHungry()) {
            if (plate.balance() < cat.getAppetit()) {
                System.out.println("В тарелке мало корма. Нужно добавить.");
                verifyPlate(plate);
            }
            eat.action(plate, cat);
        }
    }
}
