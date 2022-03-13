package com.Lab2_compulsory;

public class ComputerLab extends Room {
    private final String operatingSystem;

    public ComputerLab(String name, int capacity, String operatingSystem) {
        this.name = name;
        this.capacity=capacity;
        this.operatingSystem=operatingSystem;
    }

    @Override
    public String toString() {
        return "ComputerLab{" +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", operatingSystem='" + operatingSystem + '\'' +
                '}';
    }
}
