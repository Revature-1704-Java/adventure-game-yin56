//package com.revature.app.GameMap;
package com.revature.app;


import java.util.EventListenerProxy;
//import com.revature.app.GameMap;
import java.util.Scanner;
import com.revature.beans.Monster;


public class App {
    static boolean done = false;

    public static void main( String[] args )
    {
        System.out.println( "A Text Adventure!\n" );
        GameMap m = new GameMap(3,3);
        //Get all rooms in map and set name;
        Room r1 = m.getRoom(0, 0);
        r1.setName("Empty Room");
        String s1 = "You wake up in an empty room. It is very dark but you can see 2 doors.";
        r1.setDescription(s1);

        Room r2 = m.getRoom(0, 1);
        r2.setName("Kitchen");
        String s2 = "You walk into the kitchen. You can smell traces of cooked meat. Someone has been here recently.";
        r2.setDescription(s2);

        Room r3 = m.getRoom(0, 2);
        r2.setName("Dining Hall");
        String s3 = "You walk into a large dining hall. There is plate with a human skull on a large table.";
        r3.setDescription(s3);

        Room r4 = m.getRoom(1, 0);
        r4.setName("Library");
        String s4 = "You step into a small library. The books are all dusty but they all seem to be joke books";
        r4.setDescription(s4);

        Room r5 = m.getRoom(1, 1);
        r5.setName("Parlor");
        String s5 = "You are inside the parlor. There are a few torn up couches.";
        r5.setDescription(s5);

        Room r6 = m.getRoom(1, 2);
        r6.setName("Gallery");
        String s6 = "You step into the gallery. All the painting here have red ink spilled on them.";
        r6.setDescription(s6);

        Room r7 = m.getRoom(2, 0);
        r7.setName("Bed room");
        String s7 = "You are in the bedroom. The bed here actuall seem well taken care of.";
        r7.setDescription(s7);

        Room r8 = m.getRoom(2, 1);
        r8.setName("Storage Room");
        String s8 = "You are in the storage room. Mounds of spider web covers the items here.";
        r8.setDescription(s8);

        Room r9 = m.getRoom(2, 2);
        r9.setName("Portal Room");
        String s9 = "You find a portal! You go through the portal and wake up! It was all a dream";
        r9.setDescription(s9);


        //set r9 as the exit
        r9.setExit();

        //setup Room Descriptions from File IO
        
        
        //m.printMap();
        //m.printRooms();

        //Game loop
        
        Scanner sc = new Scanner(System.in);

        //set player starting position (always top left for now)
        Player p = new Player(m.getRoom(0, 0));
        Monster mon = new Monster(m.getRoom(2, 2));
        boolean foundExit = false;
        while(done == false){

            //play turn
            p.playRoomEvent();

            boolean validDecision = false;
            while(validDecision == false){
                String nr = sc.nextLine();
                Room nextRoom = p.getNextRoom(nr);
                if(nextRoom != null && nextRoom.isExit()){
                    //found the exit
                    System.out.println("\n\n--------------------------------------------\n\n");
                    nextRoom.printRoomDesc();
                    System.out.println("You made it out! Try again?");  
                    System.out.println("Yes\tNo");
                    while(true){
                        String con = sc.nextLine();
                        con = con.toLowerCase();
                        if(con.equals("yes")){
                            p.setCurrentRoom(m.getRoom(0, 0));
                            mon.setRoom(m.getRoom(2, 2));
                            //continue;

                            System.out.println("\n\n--------------------------------------------\n\n");
                            p.playRoomEvent();
                            foundExit = false;
                            
                            break;
                        }
                        else if(con.equals("no")){
                            done = true;
                            System.out.println("Good bye!");
                            return;
                        }
                        else{
                            System.out.println("Invalid Answer");
                        }
                    }
                    
                }
                else if(nextRoom != null && !nextRoom.isExit()){
                    p.setCurrentRoom(nextRoom);
                    validDecision = true;
                }
                else{
                    System.out.println("You cannot go there!");
                }

            }

             //check if player has moved into monster room
            if(foundExit == false && done == false){
                if(mon.monsterRoom().equals(p.getCurrentRoom())){
                    mon.meetPlayerBefore();
                    System.out.println("You died! Try again?");  
                    System.out.println("Yes\tNo");
                    while(true){
                        String con = sc.nextLine();
                        con = con.toLowerCase();
                        if(con.equals("yes")){
                            p.setCurrentRoom(m.getRoom(0, 0));
                            mon.setRoom(m.getRoom(2, 2));
                            break;
                        }
                        else if(con.equals("no")){
                            done = true;
                            System.out.println("Good bye!");
                            break;
                        }
                        else{
                            System.out.println("Invalid Answer");
                        }
                    }
                    
                }
                else{
                    System.out.println("\n");
                    //monster turn
                    mon.move();
                    //check if monster has moved into player room
                    if(mon.monsterRoom().equals(p.getCurrentRoom())){
                        mon.meetPlayerAfter();
                        System.out.println("You died! Try again?");  
                        System.out.println("Yes\tNo");
                        while(true){
                            String con = sc.nextLine();
                            con = con.toLowerCase();
                            if(con.equals("yes")){
                                p.setCurrentRoom(m.getRoom(0, 0));
                                mon.setRoom(m.getRoom(2, 2));
                                break;
                            }
                            else if(con.equals("no")){
                                done = true;
                                System.out.println("Good bye!");
                                break;
                            }
                            else{
                                System.out.println("Invalid Answer");
                            }
                        }
                    }
                       
                }
            }
            
            System.out.println("\n\n--------------------------------------------\n\n");
           
        
        }
        

    }

    public static boolean checkRoomValid(Room r){
       if(r == null){
           return false;
       }
       else{
           return true;
       }
    }


    public static int getRoomCount(int width, int length){
        return width * length;
    }
}
