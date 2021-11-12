package info.seleniumcucumber.pageObjects;

import info.seleniumcucumber.utils.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Registration extends AbstractPage {

//  @FindBy(how = How.CSS, using = "input[data-cy='register-person-name']")
  @FindBy(how = How.XPATH, using = "//input[@data-cy='register-person-name']")
  private WebElement textPersonName;

  @FindBy(how = How.CSS, using = "input[data-cy='register-person-email']")
  private WebElement textPersonEmail;

  @FindBy(how = How.CSS, using = "input[data-cy='register-person-phone']")
  private WebElement textPersonPhone;

  @FindBy(how = How.CSS, using = "[data-cy='register-person-privacy']")
  private WebElement chkPersonPrivacy;

  @FindBy(how = How.XPATH, using = "//button")
  private WebElement btnContinue;

	public void navigateToRegistrationPage() throws NoSuchFieldException
	{
    	navigationObj.navigateTo(configFileReader.getRegisterURL());
	}

	public void enterPersonName(String keyword) throws NoSuchFieldException
	{
		inputObj.enterText(textPersonName, keyword);
	}

	public void enterPersonEmail(String keyword) throws NoSuchFieldException
	{
		inputObj.enterText(textPersonEmail, keyword);
	}

	public void enterPersonPhone(String keyword) throws NoSuchFieldException
	{
		inputObj.enterText(textPersonPhone, keyword);
	}

	public void clickPersonPrivacy() throws NoSuchFieldException
	{
		clickObj.click(chkPersonPrivacy);
	}

	public void clickContinue() throws NoSuchFieldException
	{
		clickObj.click(btnContinue);
	}

}
