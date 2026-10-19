import java.util.Scanner;

public class TAKE_ORDER {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("PIZZA ORDERING SYSTEM");
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
        System.out.printf("Change: PHP %.2f%n", received - amountDue);
        System.out.println("========================================");
    }

    private static PIZZA askPizzaType() {
        System.out.println("Enter Pizza Type:\n1. Regular Pizza\n2. Special Pizza");
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
