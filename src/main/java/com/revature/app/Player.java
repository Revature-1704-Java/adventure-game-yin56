package com.revature.app;


public class Player{
    
    private Room curRoom;
    boolean isDone = false;
    public Player(Room curRoom){
        this.curRoom = curRoom;
    }

    public void playRoomEvent(){
        System.out.println("Playing room event of " + curRoom.getName());
        //show room descriptions
        //curRoom.printRoomDesc();

        //show options
        printOptions();


        //get player decision

    }

    public void setCurrentRoom(Room r){
        System.out.println("Moving to :" +  r.getName());
        this.curRoom = r;
    }

    public Room getNextRoom(String direction){
        direction = direction.toLowerCase();
        if(direction.equals("north")){
            return curRoom.getNorth();
        }
        else if(direction.equals("south")){
            return curRoom.getSouth();
        }
        else if(direction.equals("east")){
            return curRoom.getEast();
        }
        else if(direction.equals("west")){
            return curRoom.getWest();
        }
        else{
            return null;
        }
    }

    public void printOptions(){
        System.out.println("Which way do you want to go?");
        if(curRoom.getNorth() != null){
            System.out.print("North    ");
        }
        if(curRoom.getSouth() != null){
            System.out.print("South    ");
        }
        if(curRoom.getEast() != null){
            System.out.print("East    ");
        }
        if(curRoom.getWest() != null){
            System.out.print("West");
        }
        System.out.print("\n");
    }
}