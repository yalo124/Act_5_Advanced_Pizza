public abstract class PizzaBase {
    public double toCentimeters(int inches){
        return inches * 2.54;
    }

    public abstract double calculatePrice();
}
