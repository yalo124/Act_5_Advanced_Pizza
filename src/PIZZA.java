public class PIZZA extends PizzaBase implements Discountable {
    private String toppings;
    private String discount;
    private int diameter;
    private int howMany;
    private double price;

    public PIZZA () {
        setPizzaType("Regular Pizza");
    }
    //Setters
    public void setToppings(String toppings) {
        this.toppings = toppings;
    }
    public void setDiscount(String discount) {
        this.discount = discount;
    }
    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }
    public void setHowMany(int howMany) {
        this.howMany = howMany;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    //Getters
    public String getToppings() {
        return toppings;
    }
    public String getDiscount() {
        return discount;
    }
    public int getDiameter() {
        return diameter;
    }
    public int getHowMany() {
        return howMany;
    }
    public double getPrice() {
        return price;
    }
    public double getDiameterInCm() {
        return diameter * 2.54;
    }////double check

    @Override
    public double getDiscountRate() {
        if(discount == null) return 0.0;

        if(discount.equalsIgnoreCase("Senior Citizen") || discount.equalsIgnoreCase("Senior")) {
            return 0.20;
        } else if (discount.equalsIgnoreCase("VIPCard") || discount.equalsIgnoreCase("VIPCard Holder") || discount.equalsIgnoreCase("VIP")) {
            return 0.12;
        }
        return 0.0;
    }

    @Override
    public double calculatePrice() {
        double toppingPrice = 0.0;
        if(toppings != null) {
            if(toppings.equalsIgnoreCase("Pepperoni")) {
                toppingPrice = 100.0;
            } else if(toppings.equalsIgnoreCase("Ham and Cheese")) {
                toppingPrice = 150.0;
            } else if(toppings.equalsIgnoreCase("Hawaiian")) {
                toppingPrice = 200.0;
            }
        }
        double sizeCost = getDiameterInCm() * 5.0;
        double subtotal = (toppingPrice + sizeCost) * howMany;

        this.price = subtotal * (1.0 - getDiscountRate());
        return this.price;
    }





}