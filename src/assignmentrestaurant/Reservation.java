package assignmentrestaurant;

import java.util.*;
import java.io.*;


public class Reservation {
    static ArrayList<Reservation> reserveList = new ArrayList<Reservation>();
    static final String RESERVEFILE = "Reserve.txt";
   
    private static int reservationID;
    private static int rev=3;
    public String specialRequested;
    public String reservationTime;
    private Table table;
    
    public Reservation(String reservationID, String specialRequested,String NoOfPax, String reservationTime
    ,String TableNo) {
        this.specialRequested = specialRequested;
        this.reservationTime = reservationTime;
        
    }
    
    Reservation() {
        
    }

 
    public void reserve() throws FileNotFoundException{
        Scanner input = new Scanner(System.in);
        System.out.println("\nReservation Time(dd/mm time):  ");
        reservationTime = input.nextLine();
        System.out.println("\nAny Special Request?:  ");
        specialRequested = input.nextLine();
        updateReserve();
    }
    
    
    public void printReserved() throws FileNotFoundException{
        for(int x = 1; x <= rev; x++)
        {
            System.out.print("\nReservedID: "+x+"\nReserved Time: "+reservationTime+"\nSpecial Request: "
            +specialRequested);
            MenuItem o1 = new MenuItem();
            o1.menu();
            break;
        }
            updateReserve();
    }
     
    public static String cancelReservation(){
        Reservation cr = new Reservation();
        Scanner reserve = new Scanner(System.in);
        System.out.println("\nEnter ReservationID:  ");
        reservationID = reserve.nextInt();
         
        if(rev == reservationID){
            return("\nYour reservation has been cancelled.");    
        }
        else{
            return ("\nInvalid ReservationID."); 
        }
    }
     
    public static void updateReserve() throws FileNotFoundException{
        try (PrintWriter write = new PrintWriter(RESERVEFILE)) {
            reserveList.forEach((r) -> {
                write.println(r.toString());
            });
        }
    }
    
    @Override
    public String toString(){
        return String.format("%s\n%s\n%s\n%s",reservationID,specialRequested,reservationTime,table);
    }
      
}