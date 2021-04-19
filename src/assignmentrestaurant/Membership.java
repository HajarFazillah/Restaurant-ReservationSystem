package assignmentrestaurant;

import java.util.Scanner;
import static assignmentrestaurant.AssignmentRestaurant.loadRooms;
import static assignmentrestaurant.AssignmentRestaurant.roomList;
import static assignmentrestaurant.AssignmentRestaurant.findRooms;
import java.io.FileNotFoundException;

    public class Membership { 
        
        private String membershipID;
        private Reservation reserve;
        
    

    public void setMembership(String membershipID) {
        this.membershipID = membershipID;
    }
    
    public String getMembership(){
        return this.membershipID;
    }
    

    public static void printMemberInfo () throws FileNotFoundException { 
        Scanner input = new Scanner(System.in);
        int resp;
        System.out.println("\nWould you like a room?\nPlease select yes(1) / no(2)");
        resp = input.nextInt();
       //if yes then check room availability, if room available "book successfully"
       //if all booked "all rooms r booked"

       
       if(resp==1) {
           Room.printRoom();
           }
       else
           if(resp==2){ 
               Table.printTable();
               System.out.println("-----------------------------");
           }
           else{
                System.out.println("Incorrect option");
           }
    }
    
}