package classlevel.refactoring.beverage;

public class Cocktail extends Beverage {

    public enum Ingredient {
        Gin (85),
        TONIC_WATER (20),
        GREEN_STUFF (10),
        RUM(65),
        GRENADINE (10),
        LIME_JUICE (10);

        private int price;

        Ingredient(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }

    private int price;

    public Cocktail() {}

    public Cocktail withIngredient(Ingredient ingredient, double amount) {
        this.price += (ingredient.getPrice() * amount);
        return this;
    }

    @Override
    public int price() {
        return this.price;
    }

    @Override
    public boolean isAmountLimited() {
        return true;
    }
}
