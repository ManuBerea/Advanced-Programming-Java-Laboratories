package com.Lab2_compulsory;

public class Room {
    protected int capacity;
    protected Type type;

    public Room(int capacity, Type type) {
        this.capacity = capacity;
        this.type = type;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public Type getType() {
        return type;
    }

    @Override // cele doua metode toString au acelasi nume, dar continut diferit
    public String toString() {
        return "Room(" +
                "capacity=" + capacity +
                ", type=" + type +
                ')';
    }

}
