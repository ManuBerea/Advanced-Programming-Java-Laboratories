package com.Lab2_compulsory;

public class Main {
    public static void main(String[] args) {
        Event course1 = new Event("Course1", 100, 8, 10);
        Event course2 = new Event("Course2", 100, 10, 12);
        Event lab1 = new Event("Laboratory1", 30, 8, 10);
        Event lab2 = new Event("Laboratory2", 30, 8, 10);

        Room room1 = new ComputerLab("C2", 30, "Linux");
        Room room2 = new ComputerLab("C113", 30, "Windows");
        Room room3 = new LectureHall("C306", 90, false);
        Room room4 = new LectureHall("C144", 100, true);

        ProblemInstance newInstance = new ProblemInstance();
        newInstance.addEvent(course1);
        newInstance.addEvent(course2);
        newInstance.addEvent(lab1);
        newInstance.addEvent(lab2);
        newInstance.printEvents();

        newInstance.addRoom(room1);
        newInstance.addRoom(room2);
        newInstance.addRoom(room3);
        newInstance.addRoom(room4);
        newInstance.printRooms();

        Solution sol = new Solution();
        Event[] events = {course1, course2, lab1, lab2};
        Room[] rooms = {room1, room2, room3, room4};
        sol.assignRoom(newInstance, events, rooms);
    }
}