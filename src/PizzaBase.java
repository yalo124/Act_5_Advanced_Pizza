
public abstract class PizzaBase {
    protected static final double INCH_TO_CM = 2.54;

    public double toCentimeters(int inches){
        return inches * INCH_TO_CM;
    }

    public abstract double calculatePrice();
}
