package com.Lab2_compulsory;

public class Event {
    protected String name;
    protected int size;
    protected int start;
    protected int end;

    public Event(String name, int size, int start, int end) {
        this.name = name;
        this.size = size;
        this.start = start;
        this.end = end;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setSize(int size){
        this.size = size;
    }

    public int getSize(){
        return size;
    }

    public void setStart(int start){
        this.start = start;
    }

    public int getStart(){
        return start;
    }

    public void setEnd(int end){
        this.end = end;
    }

    public int getEnd(){
        return end;
    }

    @Override // cele doua metode toString au acelasi nume, dar continut diferit
    public String toString() {
        return "Event(" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", start=" + start +
                ", end=" + end +
                ')';
    }
