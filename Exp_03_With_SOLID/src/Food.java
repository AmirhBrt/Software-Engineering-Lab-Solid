public enum Food {

    SANDWICH("sandwich", 1000, 1), 
    PIZZA("pizza", 2000, 2);

    final int itemNumber;
    final String foodName;
    final int price;
    final int quantity = 1;

    Food(String foodName, int foodPrice, int itemNumber){
        this.foodName = foodName;
        this.price = foodPrice;
        this.itemNumber = itemNumber;
    }

    public int getPrice() {
        return price;
    }

    public String getFoodName() {
        return foodName;
    }

    public static Food getFoodByItemNumber(int itemNumber){
        for (Food f: Food.values()) {
            if (f.itemNumber == itemNumber) return f;
        }
        return null;
    }
}
