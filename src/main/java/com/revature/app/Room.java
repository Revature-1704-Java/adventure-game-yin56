package com.revature.app;

import java.util.LinkedList;

public class Room{
    int x;
    int y;
    private String desc;
    private String name;
    private Room nRoom = null;
    private Room wRoom = null;
    private Room sRoom = null;
    private Room eRoom = null;
    private LinkedList<Room> adjRooms = new LinkedList<Room>();
    private boolean isExit = false;

    public Room(int x, int y){
        this.x = x;
        this.y = y;
        //this.name = name;
    }

    public Room(){

    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    //s
    public void addAdjRoom(Room adj){
        adjRooms.add(adj);
    }

    public void printAdjRooms(){
        System.out.print("Adj Rooms[ ");
        for(int i = 0; i < adjRooms.size(); i++){
            System.out.print(adjRooms.get(i).getName() + " ");
        }
        System.out.print("]");
    }

    public void printRoomDesc(){
        System.out.println(desc);
    }

    

    public Room getAdjRoom(int index){
        return adjRooms.get(index);
    }
    

    public void setNorth(Room r){
        this.nRoom = r;
    }

    public void setSouth(Room r){
        this.sRoom = r;
    }

    public void setEast(Room r){
        this.eRoom = r;
    }

    public void setWest(Room r){
        this.wRoom = r;
    }

    public Room getNorth(){
        return nRoom;
    }

    public Room getSouth(){
        return sRoom;
    }

    public Room getEast(){
        return eRoom;
    }

    public Room getWest(){
        return wRoom;
    }

    public int numOfAdjRooms(){
        return adjRooms.size();
    }

    public void setExit(){
        isExit = true;
    }

    public boolean isExit(){
        return this.isExit;
    }

    public void setDescription(String d){
        desc = d;
    }


}