package com.company;

import java.util.ArrayList;
import java.util.List;
//import java.util.Collections;

public class Network {
    private final List<Node> nodes = new ArrayList<>();

    public List<Node> getNodes() {
        return nodes;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    @Override
    public String toString() {
        return "Network{" + "nodes=" + "\n" + nodes + '}';
    }
}
