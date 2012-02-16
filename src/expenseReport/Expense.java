package expenseReport;

public abstract class Expense {
  private int amount;

  public Expense(int amount) {
    this.amount = amount;
  }

  public int getAmount() {
    return amount;
  }

  abstract boolean isOverage();

  abstract boolean isMeal();
}
