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

    public abstract int arrival(int add);

    public abstract int consumption(int take);

    public abstract int balance();
}
