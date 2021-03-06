package HomeWork07;

public abstract class Storage {
    private String type;
    private int maxVolum;
    private int volume;
    private int add;
    private int take;

    public Storage(String type, int maxVolum) {
        this.type = type;
        this.maxVolum = maxVolum;
    }

    public int getMaxVolum() {
        return maxVolum;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int i) {
        volume = i;
    }

    public abstract int arrival(int add);

    public abstract int consumption(int take);

    public abstract int balance();
}
