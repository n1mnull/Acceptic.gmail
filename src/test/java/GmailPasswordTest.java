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

public class GmailPasswordTest {

    WebDriver driver;

    @BeforeTest
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "Y:\\Drivers\\chromedriver.exe");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                {"acceptic.ivan.poddubny@gmail.com", "qwerty13", true},
                {"acceptic.ivan.poddubny@gmail.com", "qwerty", false}
        };
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


    @Test(dataProvider = "dataProvider")
    public void loginVerificationTest(String login, String pass, boolean expectedResult) throws InterruptedException {

        GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);
        gmailLoginPage.enterLogin(login);
        TimeUnit.SECONDS.sleep(1);
        gmailLoginPage.enterPassword(pass);
        TimeUnit.SECONDS.sleep(3);

        GmailInboxPage gmailInboxPage = new GmailInboxPage(driver);

        if (expectedResult) {
//            System.out.println("Positive test");
            int amountUnreadMessage = gmailInboxPage.getAmountUnreadMessage();
            System.out.println("Inbox = " + amountUnreadMessage +" unread message");
            Assert.assertTrue(amountUnreadMessage >= 0);

        } else {
//            System.out.println("Negative test");
            boolean isErrorMsgPassExist = gmailLoginPage.errorMsgPassExist();
            Assert.assertEquals(!isErrorMsgPassExist, expectedResult);
        }
    }
}
