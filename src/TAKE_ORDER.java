import java.util.Scanner;

public class TAKE_ORDER {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BILL_ORDER bill = new BILL_ORDER();

        System.out.println("\n-------- PIZZA ORDERING SYSTEM -------\n");
        System.out.println("Enter Pizza Type:");
        System.out.println("1. Regular Pizza:");
        System.out.println("2. Special Pizza:");

        int choice;
        while(true) {
            System.out.print("Choice: ");
            if(sc.hasNextInt()) {
                choice = sc.nextInt();
                if(choice == 1 || choice == 2) {
                    break;
                }
                System.out.println("Invalid choice! Enter 1 for Regular Pizza or 2 for Special Pizza.");
            } else {
                System.out.println("Invalid input! Please enter 1 or 2.");
                sc.next();
            }
        }
        sc.nextLine();

        PizzaBase pizza;
        PIZZA pizzaReference;

        if(choice == 1) {
            pizzaReference = new PIZZA();
        } else {
            pizzaReference = new SPECIAL_PIZZA();
        }
        pizza = pizzaReference;
        
        System.out.println("\nToppings       | Price");
        System.out.println("Pepperoni      | PHP 100.00");
        System.out.println("Ham and Cheese | PHP 150.00");
        System.out.println("Hawaiian        | PHP 200.00\n");

        while (true) {
            System.out.print("Enter Toppings: ");
            String toppingInput = sc.nextLine();
            if(toppingInput.equalsIgnoreCase("Pepperoni") || toppingInput.equalsIgnoreCase("Ham and Cheese") || toppingInput.equalsIgnoreCase("Hawaiian")) {
                pizzaReference.setToppings(toppingInput);
                break;
            }
            System.out.println("Invalid topping! Input Pepperoni, Ham and Cheese, Hawaiian toppings only.");
        }

        while(true) {
            System.out.print("Enter Diameter in inches: ");
            if(sc.hasNextInt()) {
                int diameterInput = sc.nextInt();
                if(diameterInput > 0) {
                    pizzaReference.setDiameter(diameterInput);
                    break;
                }
                System.out.println("Invalid diameter! Diameter must be greater than 0.");
            } else {
                System.out.println("Invalid input! Please enter a whole number.");
                sc.next();
            }
        }
        
        while(true) {
            System.out.print("Enter How Many?: ");
            if(sc.hasNextInt()) {
                int quantityInput = sc.nextInt();
                if(quantityInput > 0) {
                    pizzaReference.setHowMany(quantityInput);
                    break;
                }
                System.out.println("Invalid quantity! Quantity must be greater than 0.");
            } else {
                System.out.println("Invalid input! Please enter a whole number.");
                sc.next();
            }            
        }
        sc.nextLine();

        while(true) {
            System.out.print("Enter Type of Discount: ");
            String discountInput = sc.nextLine();
            if(discountInput.equalsIgnoreCase("Senior Citizen") || 
            discountInput.equalsIgnoreCase("Senior") || 
            discountInput.equalsIgnoreCase("VIPCard") || 
            discountInput.equalsIgnoreCase("VIPCard Holder") || 
            discountInput.equalsIgnoreCase("VIP") ||
            discountInput.equalsIgnoreCase("No Discount") ||
            discountInput.equalsIgnoreCase("None") ||
            discountInput.isEmpty()) {
            
            pizzaReference.setDiscount(discountInput);
            break;
            }
            System.out.println("Invalid discount! Accepted types are Senior Citizen, VIPCard, No Discount.");
        }
        
        double amountDue = bill.OUT(pizza);

        double amountReceived;

        while (true) {
            System.out.print("Enter Amount Received: ");
            if(sc.hasNextDouble()) {
                amountReceived = sc.nextDouble();
                if(amountReceived > amountDue) {
                    break;
                }
                System.out.println("Amount Received must be greater than Amount Due.");
            } else {
                System.out.println("Invalid input! Pleaes enter a numeric amount.");
                sc.next();
            }
        }

        double change = amountReceived - amountDue;
        System.out.println("Change: PHP " + (int) Math.round(change));

        sc.close();
    }
}