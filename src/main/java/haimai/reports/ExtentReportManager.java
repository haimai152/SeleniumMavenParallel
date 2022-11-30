package haimai.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./target/ExtentReports/ExtentReport.html");
        reporter.config().setReportName("Demo Extent Report | Hai Tester");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Framework Name", "Selenium Java Framework | Hai Tester");
        extentReports.setSystemInfo("Author", "Anh Tester");
        return extentReports;
    }
}
