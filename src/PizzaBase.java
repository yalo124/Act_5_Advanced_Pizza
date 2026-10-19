public abstract class PizzaBase {
    private final String pizzaType;                

    public PizzaBase(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public String getPizzaType() {                  
        return pizzaType;
    }

    public abstract double calculatePrice();       
}
