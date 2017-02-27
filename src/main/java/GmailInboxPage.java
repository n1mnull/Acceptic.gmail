import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailInboxPage extends BasePageObject{

  @FindBy(xpath = "//div[@class='aio UKr6le']//a")
  private WebElement inboxLink;

  public GmailInboxPage(WebDriver driver) {
    super(driver);
  }

  public int getAmountUnreadMessage() {
    String title = inboxLink.getAttribute("title");
    int amountUnreadMessage = 0;
    if (title.contains("(")) {
      String substring = title.substring(title.indexOf("(") + 1, title.indexOf(")"));
      amountUnreadMessage = Integer.parseInt(substring);
    }

    return amountUnreadMessage;
  }




}
