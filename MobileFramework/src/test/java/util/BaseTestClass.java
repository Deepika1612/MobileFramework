package util;

import appium.mobileframework.Base;
import org.testng.annotations.AfterTest;

public class BaseTestClass extends Base {

  @AfterTest
  public void tearDown() {
    closure();
  }
}
