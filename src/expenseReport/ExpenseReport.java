package expenseReport;

import java.util.ArrayList;
import java.util.List;

public class ExpenseReport {
  private List<Expense> expenses = new ArrayList<Expense>();
  private int total;
  private int mealExpenses;

  public ExpenseReport() {
    total = 0;
    mealExpenses = 0;
  }

  void totalUpExpenses() {
    for (Expense expense : expenses)
      addToTotals(expense);
  }

  void addToTotals(Expense expense) {
    if (expense.isMeal())
      mealExpenses += expense.getAmount();
    total += expense.getAmount();
  }

  public int getMealExpenses() {
    return mealExpenses;
  }

  public int getTotal() {
    return total;
  }

  public void addExpense(Expense expense) {
    expenses.add(expense);
  }

  public List<Expense> getExpenses() {
    return expenses;
  }
}