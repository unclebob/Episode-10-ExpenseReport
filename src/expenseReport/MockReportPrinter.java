package expenseReport;/*
 * Created by IntelliJ IDEA.
 * User: Michael Feathers
 * Date: Jul 29, 2002
 * Time: 1:31:51 PM
 * To change template for new class use 
 * Code Style | Class Templates options (Tools | IDE Options).
 */

public class MockReportPrinter implements ReportPrinter {

    private String printedText = "";

    public void print(String text) {
        printedText += text;
    }

    public String getText() {
        return printedText;
    }

}
