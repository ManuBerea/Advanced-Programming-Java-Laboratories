package com.Lab2_compulsory;

public class Solution {

    public void assignRoom(ProblemInstance newInstance, Event[] events, Room[] rooms) {
        Room[] assignment = new Room[newInstance.getNrEvent()];
        for(int i = 0; i < newInstance.getNrEvent(); i++) {
            for(int j = 0; j < newInstance.getNrRooms(); j++) {
                if(events[i].getSize() == rooms[j].getCapacity())
                    assignment[i] = rooms[j];
            }
        }
        for(int i=0;i < newInstance.getNrEvent();i++) {
            System.out.println(events[i].getName()+ " takes placed in the room " + assignment[i].getName());
        }
    }
}
