package info.seleniumcucumber.pageObjects;

import info.seleniumcucumber.utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PhoneOTP extends AbstractPage {
  @FindBy(how = How.CSS, using = ".digit-input__box div")
  private List<WebElement> lstPhoneOTP;

  @FindBy(how = How.CSS, using = "[data-cy='verify-otp-request-new']")
  private WebElement btnContinue;

	public void inputPhoneOTP(String phoneOPT) throws NoSuchFieldException
	{
		getDriverWait().waitForElementToLoad(btnContinue);

		Actions action = new Actions(getDriver());
//		for (int i = 0; i <= phoneOPT.length(); i++) {
//		for (int i = 0; i <= lstPhoneOTP.size(); i++) {
//			action.moveToElement(lstPhoneOTP.get(i)).sendKeys(String.valueOf(phoneOPT.charAt(i))).build().perform();
//		}
			action.moveToElement(lstPhoneOTP.get(0)).sendKeys(String.valueOf(phoneOPT.charAt(0))).build().perform();
			action.moveToElement(lstPhoneOTP.get(1)).sendKeys(String.valueOf(phoneOPT.charAt(1))).build().perform();
			action.moveToElement(lstPhoneOTP.get(2)).sendKeys(String.valueOf(phoneOPT.charAt(2))).build().perform();
			action.moveToElement(lstPhoneOTP.get(3)).sendKeys(String.valueOf(phoneOPT.charAt(3))).build().perform();
	}

}
