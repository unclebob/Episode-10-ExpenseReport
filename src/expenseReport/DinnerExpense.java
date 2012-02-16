package expenseReport;

public class DinnerExpense extends Expense {
  public DinnerExpense(int amount) {
    super(amount);
  }

  boolean isOverage() {
    return amount > 5000;
  }

  boolean isMeal() {
    return true;
  }
}
