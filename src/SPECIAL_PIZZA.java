public class SPECIAL_PIZZA extends PIZZA {
    private double specialPizzaCharge = 50.0;

    public SPECIAL_PIZZA() {
        setPizzaType("Special Pizza (+50 PhP per piece)");
    }
    public double getSpecialPizzaCharge() {
        return specialPizzaCharge;
    }

    @Override 
    public double calculatePrice() {
        double basePrice = super.calculatePrice();

        double totalPizzaCharge = (specialPizzaCharge * getHowMany()) * (1.0 - getDiscountRate());

        double finalPrice = basePrice + totalPizzaCharge;
        setPrice(finalPrice);
        return finalPrice;
    }
}