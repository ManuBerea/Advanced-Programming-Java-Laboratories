package com.company;

public class Computer extends Node implements Identifiable, Storage{
    private String address;
    private int storageCapacity;

    public Computer(String name, String macAddress, String mapLocation){
        super(name, macAddress, mapLocation);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    @Override
    public int getStorageCapacity() {
        return storageCapacity;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", mapLocation='" + mapIpLocation + '\'' +
                '}' + "\n";
    }
}

