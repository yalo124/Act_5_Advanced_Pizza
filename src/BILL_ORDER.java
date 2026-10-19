public class BILL_ORDER {
    public double OUT(PIZZA pie) {
        double price = pie.calculatePrice();

        System.out.println("\nYou ordered " + pie.getToppings()
                + " Pizza, size " + pie.getDiameterInCm()
                + " cm, for PHP " + (int) price + ".");

        return price;
    }
}