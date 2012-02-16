package expenseReport;

public class ExpenseReportNamer implements ExpenseNamer {

  public String getName(Expense expense) {
    if (expense instanceof DinnerExpense)
      return "Dinner";
    else if (expense instanceof BreakfastExpense)
      return "Breakfast";
    else if (expense instanceof CarRentalExpense)
      return "Car Rental";
    else
      return "TILT";
  }
}