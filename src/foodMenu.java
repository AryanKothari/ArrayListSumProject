public class foodMenu {
    private String name;
    private double price;
    private boolean isFood;

    foodMenu(String _name, double _price, boolean _isFood) {
        name = _name;
        price = _price;
        isFood = _isFood;
    }



    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public boolean getisFood() {
        return isFood;
    }

}
