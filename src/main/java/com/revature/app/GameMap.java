package com.revature.app;

import java.util.*;

public class GameMap{
    int width; 
    int length; 
    LinkedList<LinkedList<Room>> gm = new LinkedList<LinkedList<Room>>();

    //Gamemap Constructor
    public GameMap(LinkedList<LinkedList<Room>> m, int width, int length){
        //copy the 2d array rooms into the 2d linked list
        this.width = width; //i
        this.length = length; //j
        
        //add each room indiviually
        for(int i = 0; i < width; i++){
            //may not work
           for(int j = 0; j < length; j++){
               gm.get(i).add(m.get(i).get(j));;
           }
        }

    }

    //create a game map with empty rooms
    public GameMap(int width, int length){
        this.width = width;
        this.length = length;
        for(int i = 0; i < width; i++){
            LinkedList<Room> l = new LinkedList<Room>(); //create a whole column
            for(int j = 0; j < length; j++){
                Room r = new Room(i, j);
                l.add(r);
            }
            gm.add(l);
        }

        //set adjacent Rooms
        setAdjRoom();

    }

    //set adjacent Rooms for Gamemap
    public void setAdjRoom(){
        for(int i = 0; i < width; i++){
            for(int j = 0; j < length; j++){
                Room r = gm.get(i).get(j);
                //get left room, if i then current room is on the most left,
                //there is no left room for current room
                if(i != 0){
                    Room left = gm.get(i - 1).get(j);
                    r.addAdjRoom(left);
                    r.setWest(left);
                }

                //get north room, if i then current room is on the most north,
                //there is no north room for current room
                if(j != 0){
                    Room north = gm.get(i).get(j - 1);
                    r.addAdjRoom(north);
                    r.setNorth(north);
                }


                //get right room, if i then current room is on the most right,
                //there is no right room for current room
                if(i != (width - 1)){
                    Room right = gm.get(i + 1).get(j);
                    r.addAdjRoom(right);
                    r.setEast(right);
                }

                //get north room, if i then current room is on the most north,
                //there is no north room for current room
                if(j != (length - 1)){
                    Room south = gm.get(i).get(j + 1);
                    r.addAdjRoom(south);
                    r.setSouth(south);
                }
                
            }
           
        }
    }

    

    //Do Something
    public void getAdjRoom(int x, int y){

    }

    public void printMap(){
      for(int i = 0; i < width; i++){
          for(int j = 0; j < length; j++){
              System.out.print(gm.get(j).get(i).getName() + " ");
          }
          System.out.print("\n");
      }
    }

    public void printRooms(){
        for(int i = 0; i < width; i++){
            for(int j = 0; j < length; j++){
                System.out.print(gm.get(i).get(j).getName() + ": ");
                gm.get(i).get(j).printAdjRooms();
                System.out.print("\n");
            }
            
        }
      }

    //retrieve the room at the given location
    public Room getRoom(int x, int y){
        return gm.get(x).get(y);
    }

    

   
}