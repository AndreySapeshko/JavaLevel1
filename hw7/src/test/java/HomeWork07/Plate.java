package HomeWork07;

public class Plate extends Storage {
    private String type;
    private boolean eatOrNot;
//    private int maxVolum;
//    private int volum;

    public Plate(String type, int maxVolum) {
        super(type, maxVolum);
    }

    @Override
    public int arrival(int add) {
        if(super.getVolume() + add > super.getMaxVolum()) {
            System.out.println("В тарелку столько не поместится!");
        } else {
            super.setVolume(super.getVolume() + add);
        }
        return super.getVolume();
    }

    @Override
    public int consumption(int take) {
        if (super.getVolume() - take < 0) {
            System.out.println("В тарелки недостаточно еды!");
        } else {
            super.setVolume(super.getVolume() - take);
            eatOrNot = true;
        }
        return super.getVolume();
    }

    @Override
    public int balance() {
        return super.getVolume();
    }

    public int getMaxVolum() {
        return super.getMaxVolum();
    }

    public boolean getEatOrNot() {
        return eatOrNot;
    }

    public void setEatOrNot(boolean b) {
        eatOrNot = b;
    }
}
