import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class GmailLoginPage extends BasePageObject{

  @FindBy(id = "Email")
  private WebElement loginField;

  @FindBy(id = "next")
  private WebElement nextButton;

  @FindBy(id = "Passwd")
  private WebElement passwordField;

  @FindBy(id = "signIn")
  private WebElement signInButton;

  @FindBy(id = "errormsg_0_Email")
  private WebElement errorMessageEmail;

  @FindBy(id = "errormsg_0_Passwd")
  private WebElement errorMessagePass;

  public GmailLoginPage(WebDriver driver) {
    super(driver);
  }

  public GmailLoginPage enterLogin(String login) throws InterruptedException {
    loginField.clear();
    loginField.sendKeys(login);
    clickOnNextButton();
    return new GmailLoginPage(getDriver());
  }

  public void clickOnNextButton() throws InterruptedException {
    nextButton.click();
    TimeUnit.SECONDS.sleep(1);
  }

  public GmailInboxPage enterPassword(String pass) throws InterruptedException {
    passwordField.sendKeys(pass);
    clickOnSignInButton();
    return new GmailInboxPage(getDriver());
  }

  public void clickOnSignInButton() throws InterruptedException {
    signInButton.click();
    TimeUnit.SECONDS.sleep(3);
  }

  public boolean errorMsgEmailExist() {
    return errorMessageEmail.isDisplayed();
  }

  public boolean errorMsgPassExist() {
    return errorMessagePass.isDisplayed();
  }

}
