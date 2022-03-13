package com.company;

import java.util.HashMap;
import java.util.Map;

public abstract class Node {
    protected String name;
    protected String macAddress;
    protected String mapIpLocation;
    private final Map<Node, Integer> cost = new HashMap<>();

    public Node(String name, String macAddress, String mapIpLocation){
        this.name=name;
        this.macAddress=macAddress;
        this.mapIpLocation=mapIpLocation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public String getMapLocation() {
        return mapIpLocation;
    }

    public void setMapLocation(String mapLocation) {
        this.mapIpLocation = mapLocation;
    }

    public void setCost(Node node, int value) {
        cost.put(node, value);
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                '}' + '\n';
    }

    //@Override
    public int compareTo(Node other) {
        if(name != null)
            return this.name.compareTo(other.name);
        return 0;
    }
}

