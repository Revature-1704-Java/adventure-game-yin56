//package com.revature.app.GameMap;
package com.revature.app;

//import com.revature.app.GameMap;
import java.util.Scanner;


public class App {
    public static void main( String[] args )
    {
        System.out.println( "A Text Adventure!" );
        GameMap m = new GameMap(3,3);
        //Get all rooms in map and set name;
        Room r1 = m.getRoom(0, 0);
        r1.setName("Room 1");
        Room r2 = m.getRoom(0, 1);
        r2.setName("Room 2");
        Room r3 = m.getRoom(0, 2);
        r3.setName("Room 3");
        Room r4 = m.getRoom(1, 0);
        r4.setName("Room 4");
        Room r5 = m.getRoom(1, 1);
        r5.setName("Room 5");
        Room r6 = m.getRoom(1, 2);
        r6.setName("Room 6");
        Room r7 = m.getRoom(2, 0);
        r7.setName("Room 7");
        Room r8 = m.getRoom(2, 1);
        r8.setName("Room 8");
        Room r9 = m.getRoom(2, 2);
        r9.setName("Room 9");
        
        
        m.printMap();
        m.printRooms();

        //Game loop
        boolean done = false;
        Scanner sc = new Scanner(System.in);

        //set player starting position (always top left for now)
        Player p = new Player(m.getRoom(0, 0));
        while(done == false){
            p.playRoomEvent();
            break;

        }
        

    }
}
