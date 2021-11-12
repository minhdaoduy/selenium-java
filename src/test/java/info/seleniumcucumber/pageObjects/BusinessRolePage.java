package info.seleniumcucumber.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BusinessRolePage extends AbstractPage {
  @FindBy(how = How.XPATH, using = "//div[text()='I want to open an Aspire account']")
  private WebElement lblBusinessRole;
//  @FindBy(how = How.XPATH, using = "//div[contains(@class,'business')]/div[2]")
@FindBy(how = How.XPATH, using = "//div[text()='I am a registered director of the company']")
  private WebElement btnDirector;

  @FindBy(how = How.CSS, using = ".country-select__wrapper [src='img/flags/sg.svg']")
  private WebElement imgFlag;

  @FindBy(how = How.XPATH, using = "//*[contains(@class,'product-requests--multiple')]")
  private WebElement drlPayment;

  @FindBy(how = How.XPATH, using = "//*[contains(text(),'Debit Card')]")
  private WebElement optPayment;

  @FindBy(how = How.XPATH, using = "//div[contains(text(),'selected')]")
  private WebElement itmSelectedPayment;

  @FindBy(how = How.XPATH, using = "//div[contains(text(),'Additional details')]")
  private WebElement itmTitleAdditional;

  @FindBy(how = How.CSS, using = "aspire-header__titles")
  private WebElement itmTitleRole;

  @FindBy(how = How.CSS, using = ".q-btn__content")
  private WebElement btnContinue;

  @FindBy(how = How.CSS, using = "button.bg-secondary")
  private WebElement btnStandardGetStart;

	public void chooseDirectorOption() throws NoSuchFieldException
	{
		getDriverWait().waitForElementToLoad(lblBusinessRole);
		clickObj.click(btnDirector);
	}

	public void choosePayment() throws NoSuchFieldException
	{
		getDriverWait().waitForElementVisible(imgFlag);
		clickObj.click(drlPayment);
		clickObj.click(optPayment);
		// close drop down
		getDriverWait().waitForElementToLoad(itmSelectedPayment);
		clickObj.click(itmTitleAdditional);
	}

	public void clickContinue() throws NoSuchFieldException
	{
		clickObj.click(btnContinue);
	}

	public void clickStandardGetStart() throws NoSuchFieldException
	{
		clickObj.click(btnStandardGetStart);
	}

}
