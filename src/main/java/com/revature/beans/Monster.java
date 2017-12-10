package com.revature.beans;

import com.revature.app.Room;
import java.lang.*;
import java.util.Random;

public class Monster implements NPC{
    private Room curRoom;
    
    public Monster(Room curRoom){
        this.curRoom = curRoom;
    }

    //monster will move randomly through the rooms, sometimes it wont move.
    public void move(){
        int r1 = (int) (Math.random() * 10);
        //System.out.println("An evil presence is deciding to move");
        //if r1 is > 3, monster will move to a different Room
        //System.out.println("Number genererated:" + r1 );
        if(r1 > 2){
            int options = curRoom.numOfAdjRooms();

            //randomly choose the index of an adj room to move
            int r2 = (int) (Math.random() * (options -1));
            curRoom = curRoom.getAdjRoom(r2);
            //System.out.println("The monster has moved to " + curRoom.getName());
            System.out.println("An evil presence is on the move...");

        }
        else{
            System.out.println("An evil presence still for now..");
        }
        
    }


    //what happens when the monster is in the same room
    public void meetPlayerBefore(){
        System.out.println("\n");
        System.out.println("You step into the room. It isn't empty");
        System.out.println("You see a figure in front of you and it slow turns around");
        System.out.println("A face of a clown becomes visible. It smiles.");
        System.out.println("\"Heeheehee\" he cackles. Suddenly you black out.");
    }

    //what happens when the monster is in the same room
    public void meetPlayerAfter(){
        System.out.println("\n");
        System.out.println("A figure enters the room.");
        System.out.println("The room suddenly feels cold and without life.");
        System.out.println("A face of a clown becomes visible. It smiles.");
        System.out.println("\"Heeheehee\" he cackles. Suddenly you black out.");
    }

    public Room monsterRoom(){
        return this.curRoom;
    }

    public void setRoom(Room r){
        curRoom = r;
    }
}