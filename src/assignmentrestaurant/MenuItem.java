package assignmentrestaurant;

import java.util.Scanner;

public class MenuItem {
    
    public static double runningTotal;
    private static double itemPrice;
    static boolean ordering = true;
    static Scanner input = new Scanner(System.in);
    static double j=0.0;
    
    public static double menu(){
        int foodItem;
        Scanner input = new Scanner(System.in);
        
        System.out.println("\n\n|----------------------------|");
        System.out.println("|      Food & Drinks Menu    |");
        System.out.println("|----------------------------|");
        System.out.println("| 1. Edamame       (RM8.50)  |");
        System.out.println("| 2. Chuka Wakame  (RM9.00)  |");
        System.out.println("| 3. Salmon        (RM15.50) |");
        System.out.println("| 4. Shishamo      (RM6.50)  |");
        System.out.println("| 5. Tuna Shashimi (RM16.50) |");
        System.out.println("| 6. Unagi Bento   (RM32.50) |");
        System.out.println("| 7. Salmon Bento  (RM20.50) |");
        System.out.println("| 8. Inari Bento   (RM15.50) |");
        System.out.println("|----------------------------|");
        System.out.println("| 9. Cold Green Tea (RM2.00) |");
        System.out.println("| 10. Hot Green Tea (RM1.50) |");
        System.out.println("| 11. Mineral Water (RM1.00) |");
        System.out.println(" ---------------------------- ");
        System.out.println("Please enter your choice:");
        foodItem = input.nextInt();
        
                if (foodItem == 1){
                    System.out.println("Chosen option: Edamame");
                    itemPrice = 8.50;
                }
                else if (foodItem == 2){
                    System.out.println("Chosen option: Chuka Wakame");
                    itemPrice = 9.00;
                }
                else if (foodItem == 3){
                    System.out.println("Chosen option: Salmon");
                    itemPrice = 15.50;
                }
                else if (foodItem == 4){
                    System.out.println("Chosen option: Shishamo");
                    itemPrice = 6.50;
                }
                else if (foodItem == 5){
                    System.out.println("Chosen option: Tuna Shashimi");
                    itemPrice = 16.50;
                }
                else if (foodItem == 6){
                    System.out.println("Chosen option: Unagi Bento");
                    itemPrice = 32.50;
                }
                else if (foodItem == 7){
                    System.out.println("Chosen option: Salmon Bento");
                    itemPrice = 20.50;
                    }
                else if (foodItem == 8){
                    System.out.println("Chosen option: Inari Bento");
                    itemPrice = 15.50;
                }
                else if (foodItem == 9){
                    System.out.println("Chosen option: Cold Green Tea");
                    itemPrice = 2.00;
                }
                else if (foodItem == 10){
                    System.out.println("Chosen option: Hot Green Tea");
                    itemPrice = 2.00;
                }
                else if (foodItem == 10){
                    System.out.println("Chosen option: Mineral Water");
                    itemPrice = 2.00;
                }
                else{
                    System.out.println("Invalid input. Please try again.");
                    menu();
                }
                quantity();
                return j;
       }
    
    public static double quantity(){
        System.out.println("Enter quantity: ");
        double quantity = input.nextDouble();
        price(quantity, itemPrice);
        addOn();
        return quantity;
    }
    
    public static void addOn(){
        int resp;
        System.out.println("\nPress 1 to continue order.\nPress 2 to complete order.");
        resp = input.nextInt();
        
        switch(resp){
            case 1:
                menu();
                break;
            case 2:
                done();
                break;
            default:
                System.out.println("\nInvalid input. Please try again.");
                addOn();
        }     
    }
    
    public static double price(double quantity, double itemPrice) {
        double price = quantity * itemPrice;
        System.out.println("Item Price: RM" + price);
        runningTotal += price;
        return price;
    }
    
    public static void done() {
        ordering = false;
        System.out.println("Total: RM" + runningTotal);
        System.out.println("Thank you! Your order have been placed.\n");
    }
}