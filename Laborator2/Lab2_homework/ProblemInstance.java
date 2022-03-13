package com.Lab2_compulsory;

public class ProblemInstance {
    private Room[] room;
    private Event[] event;
    private int numberOfRooms = 0, numberOfEvents = 0;

    public void addRoom (Room newRoom) {
        if(numberOfRooms == 0){
            room = new Room[500];
        }
        for(int i = 0; i <= numberOfRooms; ++i){
            if(newRoom.equals(room[i])) {
                System.out.println("The room you wanted to add already exists!");
                System.exit(-1);
            }
        }
        room[numberOfRooms] = newRoom;
        numberOfRooms++;
    }

    public void addEvent (Event newEvent) {
        if(numberOfEvents == 0) {
            event = new Event[500];
        }
        for(int i = 0; i <= numberOfEvents; ++i){
            if(newEvent.equals(event[i])) {
                System.out.println("The event you wanted to add already exists!");
                System.exit(-1);
            }
        }
        event[numberOfEvents] = newEvent;
        numberOfEvents++;
    }

    public void printEvents(){
        System.out.println("The existing events are: ");
        for(int i = 0; i < numberOfEvents; ++i) {
            System.out.println(event[i]);
        }
    }

    public void printRooms(){
        System.out.println("The existing rooms are: ");
        for(int i=0;i<numberOfRooms;i++){
            System.out.println(room[i]);
        }
    }
    public int getNrEvent() {
        return numberOfEvents;
    }

    public int getNrRooms() {
        return numberOfRooms;
    }
}
