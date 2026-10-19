import java.util.Scanner;

public class TAKE_ORDER {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BILL_ORDER bo = new BILL_ORDER();

        String orderAgain;

        do {
            System.out.println("\n========== PIZZA PIE MENU ==========");
            System.out.println("Code | Toppings       | Price");
            System.out.println("P    | Pepperoni      | 100");
            System.out.println("H    | Hawaiian       | 200");
            System.out.println("C    | Ham and Cheese | 150");

            String toppings;

            while (true) {
                System.out.print("Enter Toppings (P/H/C): ");
                String choice = input.nextLine().trim();

                if (choice.equalsIgnoreCase("P")) {
                    toppings = "Pepperoni";
                    break;
                } else if (choice.equalsIgnoreCase("H")) {
                    toppings = "Hawaiian";
                    break;
                } else if (choice.equalsIgnoreCase("C")) {
                    toppings = "Ham and Cheese";
                    break;
                } else {
                    System.out.println(
                            "Invalid choice! Please enter P, H, or C.");
                }
            }

            int diameter;

            while (true) {
                System.out.print("Enter Diameter in inches: ");

                if (input.hasNextInt()) {
                    diameter = input.nextInt();
                    input.nextLine();

                    if (diameter > 0) {
                        break;
                    }
                    System.out.println("Diameter must be greater than 0.");
                } else {
                    System.out.println(
                            "Invalid input! Please enter a whole number.");
                    input.nextLine();
                }
            }

            int howMany;

            while (true) {
                System.out.print("How Many?: ");

                if (input.hasNextInt()) {
                    howMany = input.nextInt();
                    input.nextLine();

                    if (howMany > 0) {
                        break;
                    }
                    System.out.println("Quantity must be at least 1.");
                } else {
                    System.out.println(
                            "Invalid input! Please enter a whole number.");
                    input.nextLine();
                }
            }

            String discount;

            while (true) {
                System.out.println("\nAvailable Discounts:");
                System.out.println("SC - Senior Citizen (20%)");
                System.out.println("V  - VIP (12%)");
                System.out.println("N  - None (0%)");

                System.out.print("Enter Type of Discount (SC/V/N): ");
                discount = input.nextLine().trim();

                if (discount.equalsIgnoreCase("SC")) {
                    discount = "SC";
                    break;
                } else if (discount.equalsIgnoreCase("V")) {
                    discount = "V";
                    break;
                } else if (discount.equalsIgnoreCase("N")
                        || discount.isEmpty()) {
                    discount = "N";
                    break;
                } else {
                    System.out.println(
                            "Invalid discount! Enter SC, V, or N.\n");
                }
            }

            boolean extraCheese;

            while (true) {
                System.out.print("Add extra cheese? (yes/no): ");
                String cheeseChoice = input.nextLine().trim();

                if (cheeseChoice.equalsIgnoreCase("yes")) {
                    extraCheese = true;
                    break;
                } else if (cheeseChoice.equalsIgnoreCase("no")) {
                    extraCheese = false;
                    break;
                } else {
                    System.out.println("Invalid choice! Enter yes or no.");
                }
            }

            PIZZA pie;

            if (extraCheese) {
                pie = new SPECIAL_PIZZA(true);
            } else {
                pie = new PIZZA();
            }

            pie.setToppings(toppings);
            pie.setDiameter(diameter);
            pie.setHowMany(howMany);
            pie.setDiscount(discount);

            double amountDue = bo.OUT(pie);

            System.out.println("Amount Due: PHP " + (int) amountDue);

            double received;

            while (true) {
                System.out.print("Enter Amount Received: PHP ");

                if (input.hasNextDouble()) {
                    received = input.nextDouble();
                    input.nextLine();

                    if (received >= amountDue && received >= 0) {
                        System.out.println("Change: PHP "
                                + String.format("%.2f",
                                        received - amountDue));
                        break;
                    } else {
                        System.out.println(
                                "Insufficient payment! Please enter an "
                                + "amount equal to or greater than PHP "
                                + (int) amountDue + ".");
                    }
                } else {
                    System.out.println(
                            "Invalid input! Please enter a valid amount.");
                    input.nextLine();
                }
            }

            while (true) {
                System.out.print("\nWould you like to order again? (Y/N): ");
                orderAgain = input.nextLine().trim();

                if (orderAgain.equalsIgnoreCase("Y")
                        || orderAgain.equalsIgnoreCase("N")) {
                    break;
                } else {
                    System.out.println("Invalid choice! Please enter Y or N.");
                }
            }

        } while (orderAgain.equalsIgnoreCase("Y"));

        System.out.println("\nThank you for ordering at our Pizza Shop!");
        System.out.println("Have a great day!");

        input.close();
    }
}