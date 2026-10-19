public class PIZZA extends PizzaBase implements Discountable {
    private String discount = "N";

    @Override
    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @Override
    public double getDiscountRate() {
        if (discount.equalsIgnoreCase("SC")) {
            return 0.20;
        }
        if (discount.equalsIgnoreCase("V")) {
            return 0.12;
        }
        return 0;
    }

    @Override
    public double calculatePrice() {
        double subtotal =
                (getToppingPrice() + getDiameterInCm() * 5.0)
                * getHowMany();

        return Math.round(subtotal * (1 - getDiscountRate()));
    }
}