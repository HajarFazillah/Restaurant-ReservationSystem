package assignmentrestaurant;


import static assignmentrestaurant.AssignmentRestaurant.loadMember;
import static assignmentrestaurant.AssignmentRestaurant.findMember;
import static assignmentrestaurant.AssignmentRestaurant.mList;

import java.io.*;
import java.util.Scanner;

    public class Customer {
        
        static Scanner console = new Scanner(System.in);
        
        private String Name;
        private String Contact;
        private int NumOfPax;
        private Membership memberID;

    public Customer(){
        Name = null;
        Contact = null;
        NumOfPax = 0; 
       
    }

    /**
     *
     * @param Name
     * @param Contact
     * @param NumOfPax
     * @param memberID
     */
    public Customer(String Name, String Contact, int NumOfPax, Membership memberID) {
        this.Name = Name;
        this.Contact = Contact;
        this.NumOfPax = NumOfPax;
        this.memberID = memberID;
        
    }

    public void Cust() throws FileNotFoundException{  
       int resp;
            Scanner input = new Scanner(System.in);
            
            System.out.println("\nAre you a member?(1-Yes / 2-No)");
            resp = input.nextInt();
            
            OUTER:
            for (int i = 0; i<resp; i++) {
                switch (resp) {
                    case 1:
                        loadMember();
                        System.out.println("\nEnter your Member ID: ");
                        int MemberID;
                        MemberID = console.nextInt();
                        int memberInd = findMember(MemberID);
                        System.out.println("\n--------------");
                        System.out.println("Member Details");
                        System.out.println("--------------");
                        System.out.println(mList.get(memberInd).toString());
                        
                        if (memberInd !=-1) {
                            System.out.println("\n------------------------------");
                            System.out.println("Dearest Member, Welcome Back!!");
                            System.out.println("------------------------------");
                            
                            System.out.println("Enter Number Of Pax: ");
                            NumOfPax = input.nextInt();
                            
                            Reservation r1 = new Reservation();
                            r1.reserve();
                            Membership m1 = new Membership();
                            m1.printMemberInfo();
                            r1.printReserved();
                            break OUTER;
                        } else {
                            System.out.println("\nInvalid User. Try again");
                        }
                        break;
                        
                    case 2:
                        System.out.println("\nEnter Customer Name:");
                        Name = input.nextLine();
                        Name = input.nextLine();
                        System.out.println("Enter Customer Contact: ");
                        Contact = input.nextLine();
                        System.out.println("Enter Number Of Pax: ");
                        NumOfPax = input.nextInt();
                       
                        printDetails();
                       
                        Reservation r1 = new Reservation();
                        r1.reserve();
                        Table.printTable();
                        r1.printReserved();
                        break OUTER;
                        
                    default:
                        Cust();
                        break;
                }
            }
            }
    
    public void printDetails(){
        System.out.println("\n------------------------------");
        System.out.println("     Customer's Details       ");
        System.out.println("------------------------------");
        System.out.println("Name: "+ Name +"\nContact: "+ Contact +"\nNumOfPax: "
                +NumOfPax);
    }
    
     public String getName() {
        return Name;
    }

    public String getContact() {
        return Contact;
    }

    public int getNumOfPax() {
        return NumOfPax;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }
   
    public void setNumOfPax(int NumOfPax) {
        this.NumOfPax = NumOfPax;
    }

}