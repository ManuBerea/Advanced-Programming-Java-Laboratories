package com.company;

public class Router extends Node implements  Identifiable {
    private String address;

    public Router (String name, String macAddress, String mapLocation){
        super(name, macAddress, mapLocation);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Router{" +
                "name='" + name + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", mapLocation='" + mapIpLocation + '\'' +
                '}' + "\n";
    }
}


