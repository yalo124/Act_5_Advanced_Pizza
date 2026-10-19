public class SPECIAL_PIZZA extends PIZZA {
    private boolean extraCheese;

    public SPECIAL_PIZZA(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    @Override
    public double calculatePrice() {
        double price = super.calculatePrice();

        if (extraCheese) {
            price += 30 * getHowMany();
        }

        return price;
    }
}