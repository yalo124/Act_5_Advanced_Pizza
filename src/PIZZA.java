
public class PIZZA extends PizzaBase implements Discountable {
    private String Toppings, Discount;
    private int Diameter, HowMany;
    private double Price;

    public String getToppings(){return Toppings;}
    public String getDiscount(){return Discount;}
    public int getDiameter(){return Diameter;}
    public int getHowMany(){return HowMany;}
    public double getPrice(){
        return Price;
    }
    public String getSpecialOffer(){
        return "None";
    }

    public void setToppings(String Toppings){
        this.Toppings = Toppings;
    }
    public void setDiscount(String Discount){
        this.Discount = Discount;
    }
    public void setDiameter(int Diameter){
        this.Diameter = Diameter;
    }
    public void setHowMany(int HowMany){
        this.HowMany = HowMany;
    }
    public void setPrice(double Price){this.Price = Price;}

    public String getPizzaType(){
        return "Regular Pizza";
    }
    @Override
    public double calculatePrice() {
        double diameter = toCentimeters(getDiameter());
        double total = diameter * 5;

        switch(getToppings().toUpperCase()){
            case "PEPPERONI":  total += 100; break;
            case "HAM AND CHEESE": total += 150; break;
            case "HAWAIIAN": total += 200; break;
            default: System.out.println("Unknown toppings"); break;
        }

        total *= getHowMany();
        return total;
    }

    public double getDiscountRate(){
        double discountPrice;

            if (getDiscount().equalsIgnoreCase("SENIOR CITIZEN")){
                discountPrice = calculatePrice() - (calculatePrice() * 0.2);
            } else if (getDiscount().equalsIgnoreCase("VIPCard")){
                discountPrice = calculatePrice() - (calculatePrice() * .12);
            } else {
                discountPrice = calculatePrice();
            }
        setPrice(discountPrice);
        return getPrice();
    }

    public String getDiscountRatePercentage(){
        double discount = 0;
            if (getDiscount().equalsIgnoreCase("SENIOR CITIZEN")){
                discount =  0.2;
            } else if (getDiscount().equalsIgnoreCase("VIPCard")){
                discount = 0.12;
            }


        return String.format("%.0f%%", discount * 100);
    }

    public double getExtraCharge() { return 0; }
}
