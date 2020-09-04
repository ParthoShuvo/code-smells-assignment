package classlevel.refactoring.beverage;

abstract public class NormalDrink extends Beverage {
    @Override
    public boolean isEligibleForStudentDiscount() {
        return true;
    }
}
