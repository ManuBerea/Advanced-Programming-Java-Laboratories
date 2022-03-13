package com.Lab2_compulsory;

public class Lab2 {
    public static void main(String args[]) {
        Lab2 lab2 = new Lab2();
        lab2.compulsory();
    }

    void compulsory() {
        Event todayEvent = new Event( "Course", 100, 10, 12);
        Event tomorrowEvent = new Event( "Laboratory", 200, 8, 10);
        Room room1 = new Room (100, Type.LECTURE_HALLS);
        Room room2 = new Room (200, Type.COMPUTER_LABS);

        System.out.println("Events:");
        System.out.println(todayEvent.toString());
        System.out.println(tomorrowEvent.toString());

        System.out.println();
        System.out.println("Rooms:");
        System.out.println(room1.toString());
        System.out.println(room2.toString());
    }
}