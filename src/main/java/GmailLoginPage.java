import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

  public GmailLoginPage enterLogin(String login) {
    loginField.clear();
    loginField.sendKeys(login);
    nextButton.click();
    return new GmailLoginPage(getDriver());
  }

  public GmailInboxPage enterPassword(String pass) {
    passwordField.sendKeys(pass);
    signInButton.click();
    return new GmailInboxPage(getDriver());
  }

  public boolean errorMsgEmailExist() {
    return errorMessageEmail.isDisplayed();
  }

  public boolean errorMsgPassExist() {
//    System.out.println("pass error isDisplayed = " + errorMessagePass.isDisplayed());
//    System.out.println("pass isEnabled = " + errorMessagePass.isEnabled());
//    System.out.println("pass getText = " + errorMessagePass.getText());
//    System.out.println("pass equals null = " + errorMessagePass.equals(null));
    return errorMessagePass.isDisplayed();
  }

}
