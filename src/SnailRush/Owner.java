package SnailRush;

public enum Owner {
    Red(0),
    Blue(1),
    Free(-1);

    private final int id;

    Owner(int id) {
        this.id = id;
    }

    public int get() {
        return this.id;
    }

}