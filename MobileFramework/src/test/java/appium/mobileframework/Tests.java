package appium.mobileframework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.io.IOException;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.PreferencesDependenciesPage;
import pageobjects.PreferencesPage;
import util.BaseTestClass;

public class Tests extends BaseTestClass {

  @Test
  public void wifiSettings() throws IOException, InterruptedException {

    AndroidDriver<AndroidElement> driver = capabilities("FirstApp");

    HomePage homePage = new HomePage(driver);
    PreferencesPage preferencesPage = new PreferencesPage(driver);
    PreferencesDependenciesPage preferencesDependenciesPage = 
        new PreferencesDependenciesPage(driver);

    homePage.preferences.click();
    preferencesPage.preferencedependencies.click();
    preferencesDependenciesPage.wificheckbox.click();
    preferencesDependenciesPage.wifisettings.click();
    preferencesDependenciesPage.wifiname.sendKeys("HI");
    preferencesDependenciesPage.ok.click();
  }

}
