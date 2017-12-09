package com.revature.app;


public class Player{
    
    Room curRoom;
    boolean isDone = false;
    public Player(Room curRoom){
        this.curRoom = curRoom;
    }

    public void playRoomEvent(){
        System.out.println("Playing room even of " + curRoom.getName());
        //show room descriptions
        //curRoom.printRoomDesc();

        //show options


        //get player decision

    }

    public void movePlayerTo(Room r){
        curRoom = r;
    }

    public void printOptions(){
        System.out.println("Which way do you want to go?");
        if(curRoom.getNorth() != null){
            System.out.print("North");
        }
        if(curRoom.getSouth() != null){
            System.out.print("South");
        }
        if(curRoom.getEast() != null){
            System.out.print("East");
        }
        if(curRoom.getWest() != null){
            System.out.print("West");
        }
    }
}