package expenseReport;

public abstract class Expense {
  public int amount;

  public Expense(int amount) {
    this.amount = amount;
  }

  abstract boolean isOverage();

  abstract boolean isMeal();
}
