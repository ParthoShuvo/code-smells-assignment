package classlevel.refactoring.beverage;


public abstract class Beverage {

    public Beverage() { }

    public abstract int price();
    public boolean isAmountLimited() {
        return false;
    }

    public boolean isEligibleForStudentDiscount() {
        return false;
    }
}
