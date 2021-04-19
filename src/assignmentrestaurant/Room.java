package assignmentrestaurant;

import static assignmentrestaurant.AssignmentRestaurant.loadRooms;
import static assignmentrestaurant.AssignmentRestaurant.roomList;
import static assignmentrestaurant.AssignmentRestaurant.findRooms;
import static assignmentrestaurant.AssignmentRestaurant.updateRooms;
import java.io.*;
import java.util.Scanner;

public class Room {
    
    static Scanner console= new Scanner(System.in);
    private int roomNo;
    private boolean roomsavailable;

    public Room(){
    
    }

    public Room(int roomNo, boolean roomsavailable) {
        this.roomNo = roomNo;
        this.roomsavailable = roomsavailable;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public boolean isRoomsavailable() {
        return roomsavailable;
    }

    public void setRoomsavailable(boolean roomsavailable) {
        this.roomsavailable = roomsavailable;
    }

        @Override 
        public String toString(){
           
           return String.format("%s\n%b",roomNo,roomsavailable);
       } 
        public boolean search(int roomNo){
            return getRoomNo() == roomNo;
        }
        
        public static void printRoom() throws FileNotFoundException{
            loadRooms();
            System.out.println("\nEnter the Room Number (1-3):  ");         
            System.out.println("(true = available)");
            System.out.println("(false = unavailable)");
            int roomNo = console.nextInt();
            int roomInd = findRooms(roomNo);
            System.out.println(roomList.get(roomInd).toString());
           
            if(roomInd !=-1){
                if((roomList.get(roomInd).isRoomsavailable())==false){
                    System.out.println("\nSorry, Room have been booked.");
                    printRoom();
                }else{
                    roomList.get(roomInd).setRoomsavailable(false);
                    updateRooms();
                    System.out.println("\nBook successful for Room "+ roomNo +"!");
                }
            }
            else{
                System.out.println("\nSorry, Incorrect Room Number.");   
                printRoom();
            }
        }
}