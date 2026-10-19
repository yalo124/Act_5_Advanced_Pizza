public abstract class PizzaBase {
    private String toppings;
    private int diameter;
    private int howMany;

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public void setHowMany(int howMany) {
        this.howMany = howMany;
    }

    public String getToppings() {
        return toppings;
    }

    public int getDiameterInCm() {
        return (int) Math.round(diameter * 2.54);
    }

    public int getHowMany() {
        return howMany;
    }

    protected double getToppingPrice() {
        if (toppings.equalsIgnoreCase("Pepperoni")) {
            return 100;
        }
        if (toppings.equalsIgnoreCase("Ham and Cheese")) {
            return 150;
        }
        return 200;
    }

    public abstract double calculatePrice();
}