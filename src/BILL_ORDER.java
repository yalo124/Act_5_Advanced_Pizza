public class BILL_ORDER {
    public double OUT(PIZZA p) {
        double bill = p.getPrice();
        System.out.println("----------------------------------------");
        System.out.println("ORDER DETAILS");
        System.out.println("----------------------------------------");
        System.out.println("Pizza Type: " + p.getPizzaType());
        System.out.println("Toppings: " + p.getToppings());
        System.out.printf("Diameter: %.2f cm%n", p.getDiameterCm());
        System.out.println("Quantity: " + p.getHowMany());
        if(p.getPizzaType().equalsIgnoreCase("Special Pizza")) {
            System.out.println("Extra Toppings: PHP " + p.getHowMany() * 50);
        }
        System.out.println("Discount: " + p.getDiscount());
        System.out.printf("Discount Rate: %.0f%%%n", p.getDiscountRate() * 100);
        System.out.printf("Amount Due: PHP %.2f%n", bill);
        return bill;
    }
}
