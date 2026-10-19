public class SPECIAL_PIZZA extends PIZZA {
    private static final double SPECIAL_CHARGE = 50.00;

    public SPECIAL_PIZZA() {
        super("Special Pizza");
    }

    public double getSpecialCharge() {
        return SPECIAL_CHARGE;
    } // no usage

    @Override
    public double calculatePrice() {
        return finalizePrice(getBaseAmount() + SPECIAL_CHARGE * getHowMany());
    }
}

// add comment documentation how the pizza charge affects the price