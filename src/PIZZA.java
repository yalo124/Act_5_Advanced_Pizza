import java.util.LinkedHashMap;
import java.util.Map;

public class PIZZA extends PizzaBase implements Discountable {
    private static final double CM_PER_INCH = 2.54;
    private static final double SIZE_CHARGE_PER_CM = 5.00;

    private static final Map<String, Double> TOPPING_PRICES = new LinkedHashMap<>();
    private static final Map<String, Double> DISCOUNT_RATES = new LinkedHashMap<>();
    static {
        TOPPING_PRICES.put("Pepperoni", 100.00);
        TOPPING_PRICES.put("Ham and Cheese", 150.00);
        TOPPING_PRICES.put("Hawaiian", 200.00);
        DISCOUNT_RATES.put("Senior Citizen", 0.20);
        DISCOUNT_RATES.put("VIPCard", 0.12);
        DISCOUNT_RATES.put("No Discount", 0.0);
    }

    private String toppings;
    private String discount = "No Discount";
    private int diameter;    
    private int howMany;
    private double price;

    public PIZZA() {
        super("Regular Pizza");
    }

    protected PIZZA(String pizzaType) {
        super(pizzaType);
    }

    private static String match(Map<String, Double> map, String value) {
        if (value == null) return null;
        for (String key : map.keySet()) {
            if (key.equalsIgnoreCase(value.trim())) return key;
        }
        return null;
    }

    public void setToppings(String t) {
        String key = match(TOPPING_PRICES, t);
        if (key == null) throw new IllegalArgumentException("Invalid topping! Choose Pepperoni, Ham and Cheese, or Hawaiian.");
        toppings = key;
    }

    public void setDiameter(int inches) {
        if (inches <= 0) throw new IllegalArgumentException("Diameter must be positive.");
        diameter = inches;
    }

    public void setHowMany(int h) {
        if (h <= 0) throw new IllegalArgumentException("Quantity must be positive.");
        howMany = h;
    }

    public void setDiscount(String d) {
        String key = match(DISCOUNT_RATES, d);
        if (key == null) throw new IllegalArgumentException("Invalid discount! Choose Senior Citizen, VIPCard, or No Discount.");
        discount = key;
    }

    public String getToppings() { return toppings; }
    public int getDiameter() { return diameter; } // no usage
    public double getDiameterCm() { return diameter * CM_PER_INCH; } // put the cm_per_inch in getDiameter
    public int getHowMany() { return howMany; }
    public String getDiscount() { return discount; }
    public double getPrice() { return price; }

    @Override
    public double getDiscountRate() {
        return DISCOUNT_RATES.get(discount);
    }

    protected double getBaseAmount() {
        double sizeCharge = getDiameterCm() * SIZE_CHARGE_PER_CM;
        return (TOPPING_PRICES.get(toppings) + sizeCharge) * howMany;
    }

    protected double finalizePrice(double amountBeforeDiscount) {
        price = amountBeforeDiscount - amountBeforeDiscount * getDiscountRate();
        return price;
    }

    @Override
    public double calculatePrice() {
        return finalizePrice(getBaseAmount());
    }
}

// add comment documentation for how the computation works