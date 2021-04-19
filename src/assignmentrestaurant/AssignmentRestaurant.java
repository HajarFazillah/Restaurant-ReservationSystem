// 19072230
// 19067073
// 19056340
package assignmentrestaurant;

import java.util.*;
import java.io.*;

public class AssignmentRestaurant {
    static ArrayList<Table> tableList = new ArrayList<Table>();
    static ArrayList<Room> roomList = new ArrayList<Room>();
    static ArrayList<MembershipRenew> mList = new ArrayList<MembershipRenew>();
    
    static final String MEMBERFILE = "Member.txt";
    static final String TABLESFILE = "Table.txt";
    static final String ROOMFILE = "Room.txt";
    static Scanner console = new Scanner(System.in);
   

    public static void main(String[] args) throws FileNotFoundException{
        RestaurantMain();   
    }

    static void RestaurantMain() throws FileNotFoundException{
        System.out.println("\n------------------------------");
        System.out.println("Welcome to Secret Garden Food!");
        System.out.println("------------------------------");
        System.out.println("1. Reservation");
        System.out.println("2. Membership Renewal");
        System.out.println("3. Quit");
            
        int choice = console.nextInt();
            
            while(choice>3){
                System.out.println("Invalid");
                repeat();
            }
            
            switch(choice){
                case 1:
                    do{
                        ReservationMain();
                        choice = console.nextInt(); 
                    
                        switch(choice){
                            case 1:
                                Customer c1 = new Customer();
                                c1.Cust();
                                break;
                            case 2:
                                Reservation.cancelReservation();
                                break;   
                            case 0 :
                                RestaurantMain();
                                break;
                            default:
                                System.out.println("Invalid input. Please try again.");
                        } 
                    }while(choice!=0);
                     break;
                     
                case 2:
                    renew();
                    break;
                  
                case 3:
                    System.out.println("Thank You!");
                    break;  
                  
                default:
            }
            
        if (choice != 3){
            repeat();
        } else if (choice == 3){
            System.exit(0);
        }
    }
    
    static void ReservationMain() throws FileNotFoundException{
        System.out.println("\n---Reservation---");
        System.out.println("0. Back / Done");
        System.out.println("1. Make Reservation");
        System.out.println("2. Cancel Reservation");      
    }
    
    public static void renew() throws FileNotFoundException{
    
        int price = 20;
        loadMember();
        
        System.out.println("\nEnter your Member ID: ");
        int memberID = console.nextInt();
        int memberInd = findMember(memberID);
            System.out.println("\n--------------");
            System.out.println("Member Details");
            System.out.println("--------------");
            System.out.println(mList.get(memberInd).toString());
          
        if(memberInd !=-1){
            System.out.println("\nMemberID: "+ memberID);
            System.out.println("Renewal Price: RM"+ price);
        }else{
            System.out.println("ERROR. No records are found.");
            repeat();
        }
     
    }
       
    public static void loadMember() throws FileNotFoundException{        
        FileReader read = new FileReader(MEMBERFILE);
        Scanner input = new Scanner(read);
        
            while(input.hasNextLine()) {
            mList.add(new MembershipRenew(Integer.parseInt(input.nextLine()), input.nextLine(), input.nextLine(), input.nextLine()));
            }
                for(MembershipRenew mr: mList){
                break;
            }
        input.close();
    }
    
   public static int findMember(int memberID) throws FileNotFoundException{
        int index=-1;
        for(int i=0;i<mList.size();i++){
            if(mList.get(i).search(memberID)){
                index=i;
            }
        } return index;
        
    }

    static void repeat() throws FileNotFoundException{
        char repeat;
        System.out.println("\nWould you like to do something else?\n(Press 'y' for yes and 'n' for no)");
        repeat = console.next().charAt(0);
        
        switch (repeat) {
            case 'y':
                RestaurantMain();
                break;
            case 'n':
                System.out.println("\nThank you! Have a Good Day!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input. Please try again.");
        }
    }
    
    public static int findTables(int tableNo) throws FileNotFoundException{
        
        int index =-1;
        for(int i=0;i<tableList.size();i++){
            if(tableList.get(i).search(tableNo)){
            index = i;
        }
        }return index;
        
    }
    
    public static void updateTables() throws FileNotFoundException{
        PrintWriter write = new PrintWriter(TABLESFILE);
        for(Table t: tableList){
            write.println(t.toString());
        } write.close();
    }
    
    static void loadTables() throws FileNotFoundException{
        FileReader read = new FileReader(TABLESFILE);
        Scanner input = new Scanner(read);
        
        while(input.hasNextLine()){
            tableList.add(new Table(Integer.parseInt(input.nextLine()),Boolean.parseBoolean(input.nextLine())));
        }
        for(Table t:tableList){
            break;
        }
        input.close();
    }

    public static int findRooms(int roomNo) throws FileNotFoundException{
        
        int index =-1;
        for(int i=0;i<roomList.size();i++){
            if(roomList.get(i).search(roomNo)){
            index = i;
        }
        }return index;
        
    }

    public static void updateRooms() throws FileNotFoundException{
        PrintWriter write = new PrintWriter(ROOMFILE);
        for(Room r: roomList){
            write.println(r.toString());
        } write.close();
    }

    static void loadRooms() throws FileNotFoundException{
        FileReader read = new FileReader(ROOMFILE);
        Scanner input = new Scanner(read);
        
        while(input.hasNextLine()){
            roomList.add(new Room(Integer.parseInt(input.nextLine()),Boolean.parseBoolean(input.nextLine())));
        }
        for(Room r:roomList){
            break;
        }
        input.close();
        
    }


    }