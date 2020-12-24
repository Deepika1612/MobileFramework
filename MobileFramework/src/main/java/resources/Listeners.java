package resources;

import appium.mobileframework.Base;
import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

  @Override
  public void onTestStart(ITestResult result) {
    // TODO Auto-generated method stub
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    // TODO Auto-generated method stub
    System.out.println("***** PASSED  " + result.getName() + " test has passed *****");
    String methodName = result.getName().toString().trim();
    try {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      Base.getScreenshot(methodName);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  @Override
  public void onTestFailure(ITestResult result) {
    // TODO Auto-generated method stub
    System.out.println("***** ERROR " + result.getName() + " test has failed *****");
    String methodName = result.getName().toString().trim();
    try {
      Base.getScreenshot(methodName);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  @Override
  public void onTestSkipped(ITestResult result) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onStart(ITestContext context) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onFinish(ITestContext context) {
    // TODO Auto-generated method stub

  }

}
