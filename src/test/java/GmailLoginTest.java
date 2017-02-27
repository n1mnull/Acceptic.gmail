import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GmailLoginTest {

  WebDriver driver;

  @BeforeTest
  public void setDriver() {
    System.setProperty("webdriver.chrome.driver", "Y:\\Drivers\\chromedriver.exe");
  }

  @AfterTest
  public void tearDown() {
    driver.quit();
  }

  @BeforeMethod
  public void openApplication() {
    driver = new ChromeDriver();
    driver.get("https://gmail.com");
  }

  @AfterMethod
  public void closeBrowser() {
    driver.close();
  }

  @DataProvider
  public Object[][] dataProvider() {
    return new Object[][]{
        {"acceptic.ivan.poddubny@gmail.com", true},
        {"acceptic.ivan.poddubny13@gmail.com", false},
        {"poddubny.ivan@gmail.com", true}
    };
  }

  @Test(dataProvider = "dataProvider")
  public void loginVerificationTest(String login, boolean expectedResult) throws InterruptedException {
    GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);
    gmailLoginPage.enterLogin(login);
    TimeUnit.SECONDS.sleep(1);
    boolean isErrorMsgEmailExist = gmailLoginPage.errorMsgEmailExist();
    Assert.assertEquals(!isErrorMsgEmailExist, expectedResult);
  }


}
