package info.seleniumcucumber.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EmailVerificationPage extends AbstractPage {
  @FindBy(how = How.CSS, using = ".aspire-button")
  private WebElement btnContinue;

	public void clickContinue() throws NoSuchFieldException
	{
		clickObj.click(btnContinue);
	}

}
