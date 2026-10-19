public class BILL_ORDER {
    public double OUT(PizzaBase pizza) {
        double amountDue = pizza.calculatePrice();

        PIZZA pie = (PIZZA) pizza;

        System.out.println("\n-------- ORDER DETAILS ------\n");
        System.out.println("Pizza Type: " + pizza.getPizzaType());
        System.out.println("Toppings: " + pie.getToppings());
        System.out.printf("Diameter: %.2f cm\n", pie.getDiameterInCm());
        System.out.println("Quantity: " + pie.getHowMany());

        String discountName = pie.getDiscount();
        if(discountName == null || discountName.isEmpty() || discountName.equalsIgnoreCase("None")) {
            discountName = "No Discount";
        }
        System.out.println("Discount: " + discountName);
        System.out.println("Discount Rate: " + (int)(pie.getDiscountRate() * 100) + "%");
        System.out.println("Amount Due: PHP " + (int) Math.round(amountDue));
        return amountDue;
    }
}