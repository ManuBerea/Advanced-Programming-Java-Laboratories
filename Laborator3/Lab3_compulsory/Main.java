package com.company;

public class Main {
    public static void main(String[] args) {
        Network network = new Network();

        Node computer1 = new Computer("Computer1", "56-AC-BB-B6-33-77", "79.112.44.193");
        Node computer2 = new Computer("Computer2", "80-4E-62-FD-FE-C7", "213.25.236.103");
        Node computer3 = new Computer("Computer3", "AB-73-BC-23-30-1A","61.178.135.105");

        Node router1 = new Router("Router1", "5B-11-BC-DF-D9-6E", "235.205.192.248");
        Node router2 = new Router("Router2", "B6-9E-16-6A-C0-8C", "235.205.192.248");

        Node switch1 = new Switch("Switch1", "C8-C7-C5-BD-1A-CC", "235.205.192.248");
        Node switch2 = new Switch("Switch2", "63-2A-45-86-E8-8C", "235.205.192.248");

        network.addNode(computer1);
        network.addNode(computer2);
        network.addNode(computer3);

        network.addNode(router1);
        network.addNode(router2);

        network.addNode(switch1);
        network.addNode(switch2);

        //network.sortNodes();
        System.out.println(network);
    }
}
