package pageobjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class PreferencesDependenciesPage {

  public PreferencesDependenciesPage(AndroidDriver<AndroidElement> driver) {
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }

  @AndroidFindBy(xpath = "//android.widget.TextView[@text='WiFi']")
  public WebElement wificheckbox;

  @AndroidFindBy(xpath = "//android.widget.TextView[@text='WiFi settings']")
  public WebElement wifisettings;

  @AndroidFindBy(className = "android.widget.EditText")
  public WebElement wifiname;

  @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
  public WebElement ok;

  public WebElement getWifiCheckBox() {
    System.out.println("Find the WifiCheckBox element");
    return wificheckbox;
  }

  /**
   * This method to get the elements.
   */
  public WebElement getWifiSettings() {
    System.out.println("Find the WifiSettings element");
    return wifisettings;

  }

  /**
   * This method to get the elements.
   */
  public WebElement getWifiName() {
    System.out.println("Find the WifiName element");
    return wifiname;
  }

  /**
   * This method to get the elements.
   */
  public WebElement getOk() {
    System.out.println("Find the Ok element");
    return ok;
  }

}
