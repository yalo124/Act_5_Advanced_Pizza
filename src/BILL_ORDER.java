public class BILL_ORDER{

    public double OUT(PIZZA PIE){
        System.out.println("\n=============RECEIPT=============");
        System.out.println("Pizza Type: " +  PIE.getPizzaType() );
        System.out.println("Toppings: " + PIE.getToppings().substring(0,1).toUpperCase() + PIE.getToppings().substring(1).toLowerCase());
        if (PIE.getExtraCharge() > 0) {
            System.out.println("Special: " + PIE.getSpecialOffer() );
            System.out.printf("Extra charge: PHP %.2f%n", PIE.getExtraCharge());
        }
        System.out.printf("Diamater: %.2f cm\n", PIE.toCentimeters(PIE.getDiameter()));
        System.out.println("Quantity: " + PIE.getHowMany());
        System.out.printf("Original Price: PHP %.2f\n", PIE.calculatePrice());
        System.out.println("Discount Type: " + PIE.getDiscount());
        System.out.println("Discount Rate: " + PIE.getDiscountRatePercentage());
        System.out.printf("Total Amount Due:  PHP %.2f\n", PIE.getDiscountRate());

        return PIE.getDiscountRate();
    }
}
