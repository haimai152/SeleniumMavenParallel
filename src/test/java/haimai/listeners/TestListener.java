package haimai.listeners;

import com.aventstack.extentreports.Status;
import haimai.helpers.CaptureHelpers;
import haimai.helpers.PropertiesHelpers;
import haimai.reports.AllureManager;
import haimai.reports.ExtentReportManager;
import haimai.reports.ExtentTestManager;
import haimai.utils.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }


    @Override
    public void onStart(ITestContext result) {
        PropertiesHelpers.loadAllFiles();
        System.out.println("Start Suite: " + result.getStartDate());
        CaptureHelpers.startRecord(result.getName());
    }

    @Override
    public void onFinish(ITestContext result) {
        System.out.println("Finish Suite: " + result.getEndDate());
        CaptureHelpers.stopRecord();
        ExtentReportManager.getExtentReports().flush(); //Kết thúc và thực thi xuất report ra file

    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.saveToReport(getTestName(result), getTestDescription(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info(result.getName() + " is pass.");
        ExtentTestManager.logMessage(Status.PASS, result.getName() + " is passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //System.out.println(result.getName() + " is fail.");
        CaptureHelpers.takeScreenshot(result); //Chụp màn hình khi Fail
        Log.error(result.getName() + " is fail.");

        //Extent report
        ExtentTestManager.addScreenShot(result.getName());
        ExtentTestManager.logMessage(Status.FAIL, result.getName() + " is failed.");
        // In log error into report
        ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());

        //Allure report
        AllureManager.saveTextLog(result.getName() + " is fail.");
        AllureManager.saveScreenshotPNG();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getName() + " is skip.");
        ExtentTestManager.logMessage(Status.SKIP, result.getName() + " is skipped.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }
}
