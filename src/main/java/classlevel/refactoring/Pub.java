package classlevel.refactoring;

import classlevel.refactoring.beverage.*;

import java.util.HashMap;
import java.util.Map;


public class Pub {

    public static final String ONE_BEER = "hansa";
    public static final String ONE_CIDER = "grans";
    public static final String A_PROPER_CIDER = "strongbow";
    public static final String GT = "gt";
    public static final String BACARDI_SPECIAL = "bacardi special";

    public static final int STUDENT_DISCOUNT = 10;
    public static final int MAX_NUMBER_OF_DRINKS = 2;
    public static final double AMOUNT_FULL = 1;
    public static final double AMOUNT_HALF = 0.5;

    private Map<String, Beverage> menu;

    public Pub() {
        this.menu = createMenu();
    }

    private Map<String, Beverage> createMenu() {
        Map<String, Beverage> menu = new HashMap<>();
        menu.put(ONE_BEER, new Beer());
        menu.put(ONE_CIDER, new Cider());
        menu.put(A_PROPER_CIDER, new ProperCider());
        menu.put(GT, new Cocktail()
                .withIngredient(Cocktail.Ingredient.Gin, AMOUNT_FULL)
                .withIngredient(Cocktail.Ingredient.TONIC_WATER, AMOUNT_FULL)
                .withIngredient(Cocktail.Ingredient.GREEN_STUFF, AMOUNT_FULL)
        );
        menu.put(BACARDI_SPECIAL, new Cocktail()
                .withIngredient(Cocktail.Ingredient.Gin, AMOUNT_HALF)
                .withIngredient(Cocktail.Ingredient.RUM, AMOUNT_FULL)
                .withIngredient(Cocktail.Ingredient.GRENADINE, AMOUNT_FULL)
                .withIngredient(Cocktail.Ingredient.LIME_JUICE, AMOUNT_FULL)
        );
        return menu;
    }

    public int computeCost(String drink, boolean student, int amount) {
        final Beverage beverage = menu.get(drink);
        if (beverage == null) {
            throw new RuntimeException("No such drink exists");
        }

        if (amount > MAX_NUMBER_OF_DRINKS && beverage.isAmountLimited()) {
            throw new RuntimeException("Too many drinks, max " + MAX_NUMBER_OF_DRINKS + ".");
        }
        int price = beverage.price() * amount;
        if (student && beverage.isEligibleForStudentDiscount()) {
            return getStudentDiscountPrice(price);
        }
        return beverage.price();
    }

    private int getStudentDiscountPrice(int price) {
        return price - (price / STUDENT_DISCOUNT);
    }
}
