import static java.util.Locale.*;

public class SPECIAL_PIZZA extends PIZZA  {
    private String special = "";

    @Override
    public String getSpecialOffer(){
        return getspecial();
    }

    public String getspecial(){
        return special;
    }

    public boolean setspecial(String special){
        if(special.equalsIgnoreCase("Stuffed Crust") || special.equalsIgnoreCase("Extra Cheese")){
            this.special = special;
            return true;
        }
        return false;
    }

    @Override
    public String getPizzaType(){
        return "Special Pizza";
    }

    @Override
   public double getExtraCharge(){
       double extra = 0;
       switch (getspecial().toUpperCase(ROOT)) {
            case "STUFFED CRUST":
                extra = 50;
                break;
            case "EXTRA CHEESE":
                extra = 40;
                break;

            default: break;
        }

        extra *= getHowMany();

        return extra;
   }

    @Override
    public double calculatePrice() {
        double price = super.calculatePrice();

        price+=getExtraCharge();
        return price;
    }

}
