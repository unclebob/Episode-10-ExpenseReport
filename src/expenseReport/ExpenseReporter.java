package expenseReport;

public class ExpenseReporter {
  ReportPrinter printer;
  private ExpenseReport report;
  private ExpenseNamer namer = new ExpenseReportNamer();

  public ExpenseReporter(ExpenseReport report) {
    this.report = report;
  }

  public void printReport(ReportPrinter printer) {
    this.printer = printer;
    report.totalUpExpenses();
    printExpensesAndTotals();
  }

  private void printExpensesAndTotals() {
    printHeader();
    printExpenses();
    printTotals();
  }

  private void printHeader() {
    printer.print("Expenses " + getDate() + "\n");
  }

  private void printExpenses() {
    for (Expense expense : report.getExpenses())
      printExpense(expense);
  }

  private void printExpense(Expense expense) {
    printer.print(String.format("%s\t%s\t$%.02f\n",
      expense.isOverage() ? "X" : " ",
      namer.getName(expense),
      penniesToDollars(expense.amount)));
  }

  private void printTotals() {
    printer.print(String.format("\nMeal expenses $%.02f", penniesToDollars(report.getMealExpenses())));
    printer.print(String.format("\nTotal $%.02f", penniesToDollars(report.getTotal())));
  }

  private double penniesToDollars(int pennies) {
    return pennies / 100.0;
  }

  private String getName(Expense expense) {
    return namer.getName(expense);
  }

  private String getDate() {
    return "9/12/2002";
  }

}
