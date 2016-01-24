package com.tom.zombie;

public class Zombie implements Compares<Zombie> {

    public enum Type {
        WALKER, RUNNER,
        FATTY,  ABOMINATION;
    }
    Type type;

    public Zombie(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public int compareTo(Zombie other) {
        return type.compareTo(other.getType());
    }
}
