import java.util.Scanner;

public class Decorater{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your coffee order");
        String coffeeOrder = scanner.nextLine();

        // Hardcoded branches leading to maintenance issues
        if (coffeeOrder.equalsIgnoreCase("Espresso with Milk and Sugar")) {
            System.out.println("Preparing Espresso with Milk and Sugar...");
            System.out.println("Total Cost: $2.75");
        } else if (coffeeOrder.equalsIgnoreCase("Cappuccino with Vanilla")) {
            System.out.println("Preparing Cappuccino with Vanilla...");
            System.out.println("Total Cost: $3.75");
        } else if (coffeeOrder.equalsIgnoreCase("Latte with Caramel")) {
            System.out.println("Preparing Latte with Caramel...");
            System.out.println("Total Cost: $4.50");
        } else {
            System.out.println("Order not recognized!");
        }
        
        scanner.close();
    }
}