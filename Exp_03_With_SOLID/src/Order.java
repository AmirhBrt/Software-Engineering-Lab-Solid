import java.util.ArrayList;

public class Order {
    String customerName;
    ArrayList<Food> foods = new ArrayList<>();

    public Order(String customerName) {
        this.customerName = customerName;
    }

    public void addItem(Food food) {
        if (food == null) return;
        this.foods.add(food);
    }

    public int getTotalPrice() {
        return this.foods.stream().mapToInt(Food::getPrice).sum();
    }

    @Override
    public String toString() {
        String orders = "";
        for (Food food : this.foods) {
            orders += food.getFoodName() + " -> " + food.price + "\n";
        }
        return "Customer : " + customerName + "\nOrders are : \n" + orders + "\nTotal Price : " + this.getTotalPrice();
    }
}
