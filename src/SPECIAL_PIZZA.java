public class SPECIAL_PIZZA extends PIZZA {
    private double specialPizzaCharge = 50.0;

    public SPECIAL_PIZZA() {
        setPizzaType("Special Pizza (+50 PhP per piece)");
    } // confusing. not per piece, per pizza
    public double getSpecialPizzaCharge() {
        return specialPizzaCharge;
    } // no usage

    @Override 
    public double calculatePrice() {
        double basePrice = super.calculatePrice();

        double totalPizzaCharge = (specialPizzaCharge /*use getSpecialPizzaCharge if you want*/ * getHowMany()) * (1.0 - getDiscountRate());

        double finalPrice = basePrice + totalPizzaCharge;
        setPrice(finalPrice);
        return finalPrice;
    }
}

// suggestion: specialPizza should have description what special about it.

//add documentation on how the formula works. do also in PIZZA class