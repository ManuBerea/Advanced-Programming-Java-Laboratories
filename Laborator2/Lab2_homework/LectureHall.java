package com.Lab2_compulsory;

public class LectureHall extends Room {
    private final boolean existsVideoProjector;

    public LectureHall(String name, int capacity, boolean existsVideoProjector ) {
        this.name = name;
        this.capacity = capacity;
        this.existsVideoProjector = existsVideoProjector;
    }

    @Override
    public String toString() {
        return "LectureHall{" +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", existsVideoProjector=" + existsVideoProjector +
                '}';
    }
}
