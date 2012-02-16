package expenseReport;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpenseReportTest {
  private ExpenseReport report;
  private ExpenseReporter reporter;
  private MockReportPrinter printer;

  @Before
  public void setUp() {
    report = new ExpenseReport();
    reporter = new ExpenseReporter(report);
    printer = new MockReportPrinter();
  }

  @Test
  public void printEmpty() {
    reporter.printReport(printer);

    assertEquals(
      "Expenses 9/12/2002\n" +
        "\n" +
        "Meal expenses $0.00\n" +
        "Total $0.00",
      printer.getText());
  }

  @Test
  public void printOneDinner() {
    report.addExpense(new DinnerExpense(1678));
    reporter.printReport(printer);

    assertEquals(
      "Expenses 9/12/2002\n" +
        " \tDinner\t$16.78\n" +
        "\n" +
        "Meal expenses $16.78\n" +
        "Total $16.78",
      printer.getText());
  }

  @Test
  public void twoMeals() throws Exception {
    report.addExpense(new DinnerExpense(1000));
    report.addExpense(new BreakfastExpense(500));
    reporter.printReport(printer);

    assertEquals(
      "Expenses 9/12/2002\n" +
        " \tDinner\t$10.00\n" +
        " \tBreakfast\t$5.00\n" +

        "\n" +
        "Meal expenses $15.00\n" +
        "Total $15.00",
      printer.getText());
  }

  @Test
  public void twoMealsAndCarRental() throws Exception {
    report.addExpense(new DinnerExpense(1000));
    report.addExpense(new BreakfastExpense(500));
    report.addExpense(new CarRentalExpense(50000));
    reporter.printReport(printer);

    assertEquals(
      "Expenses 9/12/2002\n" +
        " \tDinner\t$10.00\n" +
        " \tBreakfast\t$5.00\n" +
        " \tCar Rental\t$500.00\n" +
        "\n" +
        "Meal expenses $15.00\n" +
        "Total $515.00",
      printer.getText());
  }

  @Test
  public void overages() throws Exception {
    report.addExpense(new BreakfastExpense(1000));
    report.addExpense(new BreakfastExpense(1001));
    report.addExpense(new DinnerExpense(5000));
    report.addExpense(new DinnerExpense(5001));
    reporter.printReport(printer);

    assertEquals(
      "Expenses 9/12/2002\n" +
        " \tBreakfast\t$10.00\n" +
        "X\tBreakfast\t$10.01\n" +
        " \tDinner\t$50.00\n" +
        "X\tDinner\t$50.01\n" +
        "\n" +
        "Meal expenses $120.02\n" +
        "Total $120.02",
      printer.getText());
  }

}
