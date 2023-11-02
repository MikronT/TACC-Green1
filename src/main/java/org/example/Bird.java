package org.example;

abstract class Bird {
    protected boolean feathers;
    protected boolean layEggs;

    abstract public void fly();

    public String getInfo() {
        return "Has feather: " + feathers + '\n' + "Lay eggs: " + layEggs;
    }
}
