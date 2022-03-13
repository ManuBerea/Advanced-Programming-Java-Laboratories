package com.Lab2_compulsory;

public abstract class Room {
    protected int capacity;
    protected Type type;
    protected String name;

    public Room(String name, int capacity, Type type) {
        this.name = name;
        this.capacity = capacity;
        this.type = type;
    }
    public Room(){}

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override // cele doua metode toString au acelasi nume, dar continut diferit
    public String toString() {
        return "Room(" +
                "capacity=" + capacity +
                ", type=" + type +
                ')';
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Room other)) {
            return false;
        }
        return name.equals(other.name);
    }
}
