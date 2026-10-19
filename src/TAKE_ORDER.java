import java.util.Scanner;

public class TAKE_ORDER {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("\t\tPIZZA ORDERING SYSTEM");
        System.out.println("========================================");

        PIZZA pie = askPizzaType();
        askToppings(pie);
        askDiameter(pie);
        askHowMany(pie);
        askDiscount(pie);

        PizzaBase pizza = pie;         
        pizza.calculatePrice();       

        BILL_ORDER bill = new BILL_ORDER();
        double amountDue = bill.OUT(pie);

        double received = askPayment(amountDue);
        System.out.printf("\nAmount Received: PHP %.2f%n", received);
        System.out.printf("Change: PHP %.2f%n", received - amountDue);
        System.out.println("========================================");
    }

    private static PIZZA askPizzaType() {
        System.out.println("Enter Pizza Type:\n1. Regular Pizza\n2. Special Pizza (Extra Toppings Additional PHP 50 per pizza)");
        while (true) {
            System.out.print("Choice: ");
            String c = sc.nextLine().trim();
            if (c.equals("1")) return new PIZZA();
            if (c.equals("2")) return new SPECIAL_PIZZA();
            System.out.println("Invalid choice! Enter 1 or 2.");
        }
    }

    private static void askToppings(PIZZA p) {
        while (true) {
            System.out.println("\n========MENU========");
            System.out.println("TOPPINGS ========== PRICE");
            System.out.println("PEPPERONI ========= 100");
            System.out.println("HAM AND CHEESE ==== 150");
            System.out.println("HAWAIIAN ========== 200");
            System.out.print("Enter Toppings: ");
            try { p.setToppings(sc.nextLine()); return; }
            catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
        }
    }

    private static void askDiameter(PIZZA p) {
        while (true) {
            System.out.print("Enter Diameter in inches: ");
            try { p.setDiameter(Integer.parseInt(sc.nextLine().trim())); return; }
            catch (NumberFormatException e) { System.out.println("Please enter a whole number."); }
            catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
        }
    }

    private static void askHowMany(PIZZA p) {
        while (true) {
            System.out.print("Enter How Many?: ");
            try { p.setHowMany(Integer.parseInt(sc.nextLine().trim())); return; }
            catch (NumberFormatException e) { System.out.println("Please enter a whole number."); }
            catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
        }
    }

    private static void askDiscount(PIZZA p) {
        while (true) {
            System.out.println("\nAvailable Discounts:");
            System.out.println("Senior Citizen (20%)");
            System.out.println("VIPCard (12%)");
            System.out.println("No Discount");
            System.out.print("Enter Type of Discount: ");
            try { p.setDiscount(sc.nextLine()); return; }
            catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
        }
    }

    private static double askPayment(double amountDue) {
        while (true) {
            System.out.print("Enter Amount Received: ");
            try {
                double r = Double.parseDouble(sc.nextLine().trim());
                if (r > amountDue) return r;
                System.out.println("Amount Received must be greater than Amount Due.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
