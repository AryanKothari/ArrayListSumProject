public class orderedItems {
    private String name;
    private double price;
    private boolean isFood;
    private double taxedPrice;


    orderedItems(String _name,double _price, boolean _isFood) {
        name = _name;
        price = _price;
        isFood = _isFood;
    }

    public double getTaxedPrice() {
        if(isFood == true) {
            taxedPrice = 1.15*price;
        } else if (isFood == false) {
            taxedPrice = 1.20*price;
        }

        return taxedPrice;
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
