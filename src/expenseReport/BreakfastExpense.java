package expenseReport;

public class BreakfastExpense extends Expense {
  public BreakfastExpense(int amount) {
    super(amount);
  }

  boolean isOverage() {
    return amount > 1000;
  }

  boolean isMeal() {
    return true;
  }
}
