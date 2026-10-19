import java.util.Scanner;

public class TAKE_ORDER {
    public static void main(String[] args){
        PIZZA PIE = null;
        BILL_ORDER bill = new BILL_ORDER();
        String toppings;
        String discount = " ";
        int diameter = 0, howmany = 0, choice1 = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("============================");
        System.out.println("\t PIZZA ORDERING SYSTEM");
        System.out.println("============================");

        while (choice1 <=0 || choice1 > 2) {
            System.out.println("Enter Pizza Type");
            System.out.println("1. Regular Pizza");
            System.out.println("2. Special Pizza");
            System.out.print("Choice: ");
            choice1 = scan.nextByte();
            scan.nextLine();
            if (choice1 <= 0 || choice1 > 2) {
                System.out.println("Invalid input ");
            }
        }


        switch (choice1){
            case 1:
                PIE  = new PIZZA();
                break;
            case 2:
                PIE = new SPECIAL_PIZZA();
                System.out.println("Special offers: Stuffed Crust, Extra Cheese");
                while(true){
                    System.out.print("Pick: ");
                    if(((SPECIAL_PIZZA) PIE).setspecial(scan.nextLine().trim())){
                        break;
                    }
                    System.out.println("Invalid Offer.");
                }

                break;
            default:
                System.out.println("Invalid option");
                break;
        }
        System.out.println("========MENU========");
        System.out.println("TOPPINGS ========== PRICE");
        System.out.println("PEPPERONI ========= 100");
        System.out.println("HAM AND CHEESE ==== 150");
        System.out.println("HAWAIIAN ========== 200\n");

        System.out.println("=====ORDER=====");
        while(true) {
            System.out.print("Enter toppings: ");
            toppings = scan.nextLine().trim();
            if (toppings.equalsIgnoreCase("PEPPERONI") ||
                    toppings.equalsIgnoreCase("HAM AND CHEESE") ||
                    toppings.equalsIgnoreCase("HAWAIIAN")) {
                PIE.setToppings(toppings);
                break;
            } else {
                System.out.println("Invalid topping. Choose from the menu.");
            }
        }
        while(diameter <= 0){
            System.out.print("Enter size in inches: ");
            diameter = scan.nextInt();
            scan.nextLine();
            if(diameter <= 0){
                System.out.println("Invalid Diameter");
            }
        }


        PIE.setDiameter(diameter);
        while(howmany < 1){
            System.out.print("How many: ");
            howmany = scan.nextInt();
            if(howmany < 1){
                System.out.println("Minimum quantity: 1");
            }
        }

        scan.nextLine();
        PIE.setHowMany(howmany);
        String choice;

        while (true) {
            System.out.print("Have discount card? (Y/N): ");
            choice = scan.nextLine().trim();
            if (choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N")) {
                break;
            }
            System.out.println("Invalid input. Enter Y or N.");
        }

        if (choice.equalsIgnoreCase("N")) {
            PIE.setDiscount("No Discount");
        } else {
            while(!(discount.equalsIgnoreCase("Senior Citizen") || discount.equalsIgnoreCase("VIPCard"))) {
                System.out.println("Discount type:\nSenior Citizen\nVIPCard");
                System.out.print("Enter discount: ");
                discount = scan.nextLine().trim();
                PIE.setDiscount(discount);

                if (!(discount.equalsIgnoreCase("Senior Citizen") || discount.equalsIgnoreCase("VIPCard"))){
                    System.out.println("Invalid Discount Input");
                }
            }
        }

        double amountDue = bill.OUT(PIE);

        double amountReceived = 0;
        while (amountReceived <= amountDue) {
            System.out.print("Enter amount received: ");
            amountReceived = scan.nextDouble();
            scan.nextLine();
            if (amountReceived <= amountDue) {
                System.out.println("Amount Received must be greater than Amount Due.");
            }
        }

        System.out.println("Amount Received: PHP " + amountReceived);
        System.out.printf("Change: PHP %.2f%n", amountReceived - amountDue);

        scan.close();
    }
}
