package assignmentrestaurant;

import java.util.*;

import static assignmentrestaurant.AssignmentRestaurant.loadTables;
import static assignmentrestaurant.AssignmentRestaurant.tableList;
import static assignmentrestaurant.AssignmentRestaurant.findTables;
import static assignmentrestaurant.AssignmentRestaurant.updateTables;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Table {
    
    static Scanner console= new Scanner(System.in);
    
    private int tableNo;
    private boolean tableavailable;

public Table(){
    
}

    public Table (int tableNo, boolean roomsavailable) {
        this.tableNo = tableNo;
        this.tableavailable = roomsavailable;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public boolean isTableavailable() {
        return tableavailable;
    }

    public void setTableavailable(boolean tableavailable) {
        this.tableavailable = tableavailable;
    }

       @Override 
        public String toString(){
           
           return String.format("%s\n%b",tableNo,tableavailable);
       } 
        
        public boolean search(int tableNo){
            return getTableNo() == tableNo;
        }
        
        
        
        public static void printTable() throws FileNotFoundException{
            
        loadTables();
        System.out.println("\nEnter the table number:  ");
           
            
        int tableNo = console.nextInt();
        int tableInd = findTables(tableNo);
        System.out.println(tableList.get(tableInd).toString());
            
        
        if(tableInd !=-1){
            if((tableList.get(tableInd).isTableavailable())==false){
                System.out.println("\nSorry table have been booked");
                printTable();
            
        }else{
                tableList.get(tableInd).setTableavailable(false);
                updateTables();
                System.out.println("\nBook successful for table "+ tableNo +"!");
                
            }
        }
        else{
            
            System.out.println("\nSorry Incorrect Table Number.");   
            printTable();
        }
        }
}