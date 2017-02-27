import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageObject {

  private WebDriver driver;

  public BasePageObject(WebDriver driver) {
    this.driver = driver;
    this.init(driver);
  }

  public WebDriver getDriver() {
    return driver;
  }

  protected void init(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }
}
