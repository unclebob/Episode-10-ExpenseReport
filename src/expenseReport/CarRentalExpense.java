package expenseReport;

public class CarRentalExpense extends Expense {
  public CarRentalExpense(int amount) {
    super(amount);
  }

  boolean isOverage() {
    return false;
  }

  boolean isMeal() {
    return false;
  }
}
