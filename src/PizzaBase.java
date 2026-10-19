public abstract class PizzaBase {
     protected String pizzaType;

     public String getPizzaType() {
        return pizzaType;
     }
     public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
     }
     public abstract double calculatePrice();
}