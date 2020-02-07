package HomeWork07;

public class Plate extends Storage {
    private String type;
    private int maxVolum;
    private int volum;

    public Plate(String type, int maxVolum) {
        super(type, maxVolum);
    }

    @Override
    public int arrival(int add) {
        if(volum + add > maxVolum) {
            System.out.println("В тарелку столько не поместится!");
        } else {
            volum += add;
        }
        return volum;
    }

    @Override
    public int consumption(int take) {
        if (volum - take < 0) {
            System.out.println("В тарелки недостаточно еды!");
        } else {
            volum -= take;
        }
        return volum;
    }

    @Override
    public int balance() {
        return 0;
    }
}
