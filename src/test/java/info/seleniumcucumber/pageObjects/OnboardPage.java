package info.seleniumcucumber.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Objects;

import static java.lang.Integer.parseInt;

public class OnboardPage extends AbstractPage {
  @FindBy(how = How.CSS, using = "[label=\"Date of birth\"] input")
  private WebElement cldDateOfBirth;

  @FindBy(how = How.CSS, using = "[url='countries/all']")
  private WebElement drlCountry;

  @FindBy(how = How.CSS, using = "[data-cy='kyc-gender'] input")
  private WebElement drlGender;

  @FindBy(how = How.CSS, using = ".aspire-cta-box button")
  private WebElement btnContinue;

    //Business detail

  @FindBy(how = How.CSS, using = "input[data-cy='register-business-name']")
  private WebElement txtBusinessLegal;

  //  @FindBy(
  //      how = How.XPATH,
  //      using = "//div[@data-cy='register-business-registration-type' and ./span]")
  //  private WebElement drlCategory;

  @FindBy(how = How.XPATH, using = "//input[@data-cy=\"register-business-registration-type\"]")
  private WebElement txtCategory;

    @FindBy(
            how = How.XPATH,
            using = "//div[@data-cy=\"register-business-sub-registration-type\" and ./span]")
    private WebElement drlEntityType;

  @FindBy(how = How.CSS, using = "input[data-cy='register-business-registration-number']")
  private WebElement txtBusinessRegistrationNumber;

  @FindBy(how = How.XPATH, using = "//div[@data-cy=\"register-business-industry\" and ./span]")
  private WebElement drlIndustry;

  @FindBy(how = How.XPATH, using = "//div[@data-cy=\"register-business-sub-industry\" and ./span]")
  private WebElement drlSubIndustry;

  // Identity detail

  @FindBy(how = How.CSS, using = "[label=\"Business activity\"] input")
  private WebElement txtBusinessActivity;

  @FindBy(how = How.XPATH, using = "//div[contains(@label,'Detailed')]//input")
  private WebElement txtDetailServices;

  @FindBy(
      how = How.CSS,
      using = "input[data-cy='register-business-registration-website-url']")
  private WebElement txtWebsite;

  @FindBy(
      how = How.XPATH,
      using = "//div[@label='Number of employees']//input")
  private WebElement drlNumberEmployees;

  @FindBy(how = How.XPATH, using = "//div[@label=\"Annual revenue\"]//input")
  private WebElement drlAnnualRevenue;

  @FindBy(
      how = How.XPATH,
      using = "//div[contains(@label,'spend')]//input")
  private WebElement drlTotalSpend;

  @FindBy(
      how = How.XPATH,
      using = "//span[text()='A photo or a scan of your passport or identity card']")
  private WebElement lblConfirmTitle;

  @FindBy(
      how = How.CSS,
      using = ".q-dialog__inner button")
  private WebElement btnContinueOfDialog;

  @FindBy(
      how = How.CSS,
//      using = "input.q-uploader__input")
      using = "[class='q-uploader__header bg-transparent']")
  private WebElement updPassport;

  @FindBy(how = How.XPATH, using = "//*[text()='or Upload file']")
  private WebElement btnUploadFile;

  @FindBy(how = How.XPATH, using = "//div[text()='Thank you']")
  private WebElement lblThankYouTitle;

	public void chooseDateOfBirth(String date, String month, int year) throws NoSuchFieldException, InterruptedException {
		clickObj.click(cldDateOfBirth);
		clickObj.chooseDateOfBirth("5", "May", 2000);
	}


	public void selectCountry(String country) throws NoSuchFieldException, InterruptedException {
//		clickObj.click(drlCountry);
        clickObj.selectOption(drlCountry,"Anguilla");
	}

	public void selectGender(String gender) throws NoSuchFieldException, InterruptedException {
//		clickObj.click(drlGender);
        clickObj.selectOption(drlGender,"Male");
	}


	public void clickContinue() throws NoSuchFieldException
	{
		clickObj.click(btnContinue);
	}

    public void inputBusinessLegal(String businessLegal) throws NoSuchFieldException
    {
        inputObj.enterText(txtBusinessLegal,businessLegal);
    }

    public void inputCategory(String category) throws NoSuchFieldException, InterruptedException {
//        clickObj.click(drlCategory);
        clickObj.selectOption(txtCategory,"Limited companies");
//          inputObj.enterText(txtCategory,"Limited companies");
    }

    public void selectIndustry(String industry) throws NoSuchFieldException, InterruptedException {
//        clickObj.click(drlIndustry);
        clickObj.selectOption(drlIndustry,"Business Services");
    }

    public void selectEntityType(String entityType) throws NoSuchFieldException, InterruptedException {
//        clickObj.click(drlEntityType);
        clickObj.selectOption(drlEntityType,"Limited partnership");
    }

    public void selectSubIndustry(String subIndustry) throws NoSuchFieldException, InterruptedException {
//        clickObj.click(drlSubIndustry);
        clickObj.selectOption(drlSubIndustry,"Holding Companies");
    }

    public void inputBusinessRegistrationNumber(String businessRegistrationNumber) throws NoSuchFieldException
    {
        inputObj.enterText(txtBusinessRegistrationNumber,businessRegistrationNumber);
    }

    public void inputBusinessActivity(String businessActivity) throws NoSuchFieldException
    {
        inputObj.enterText(txtBusinessActivity,"test test test test test test test test test test test");
    }

    public void inputDetailServices(String detailServices) throws NoSuchFieldException
    {
        inputObj.enterText(txtDetailServices,"test test test test test test test test test test test");
    }

    public void inputWebsite(String website) throws NoSuchFieldException
    {
        inputObj.enterText(txtWebsite,"https://www.google.com/");
    }

    public void selectNumberEmployees(String numberEmployees) throws NoSuchFieldException, InterruptedException {
//        clickObj.click(drlNumberEmployees);
        clickObj.selectOption(drlNumberEmployees,"1");
    }

    public void selectAnnualRevenue(String annualRevenue) throws NoSuchFieldException, InterruptedException {
//        clickObj.click(drlAnnualRevenue);
        clickObj.selectOption(drlAnnualRevenue,"S$0 - S$50,000");
    }

    public void selectTotalSpend(String totalSpend) throws NoSuchFieldException, InterruptedException {
//        clickObj.click(drlTotalSpend);
        clickObj.selectOption(drlTotalSpend,"1-5k");
    }

    public void selectKindOfIdentity(String text) throws NoSuchFieldException
    {
    //        clickObj.clickByType("xpath", "//div[text()='"+text+"']");
    clickObj.clickByType("xpath", "//div[./div[text()='"+text+"']]/div/*[2]");
    }

    public void waitThankYouPageDisplaying() throws NoSuchFieldException
    {
        getDriverWait().waitForElementVisible(lblThankYouTitle);
    }

    public void openUploadFilePage() throws NoSuchFieldException
    {
        int halfOfHeight = btnUploadFile.getSize().getHeight()/2;
// moveToElement* method moves to the middle of element, so we'll also move on half of element and click on the 3rd pix from the bottom
        int offset = halfOfHeight - 3;

        Actions actions = new Actions(getDriver());
        actions
                .moveToElement(btnUploadFile)
                .moveByOffset(0, offset)
                .click()
                .build()
                .perform();
        clickObj.click(btnContinueOfDialog);
    }

    public void uploadImage() throws NoSuchFieldException, AWTException, InterruptedException {
//        inputObj.enterText(updPassport,"src/test/resources/testDataResources/Customer.json");
        // Specify the file location with extension
//        StringSelection sel = new StringSelection("/Users/minhdao/Minh-selenium-java/src/test/resources/testDataResources/passport.png");
       String path = (new File("src/test/resources/testDataResources/passport.png")).getAbsolutePath();
        StringSelection sel = new StringSelection(path);
        // Copy to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
        System.out.println("selection" +sel);

        clickObj.click(updPassport);
        // Create object of Robot class
        Robot robot = new Robot();
        Thread.sleep(1000);

        // Cmd + Tab is needed since it launches a Java app and the browser looses focus

        robot.keyPress(KeyEvent.VK_META);

        robot.keyPress(KeyEvent.VK_TAB);

        robot.keyRelease(KeyEvent.VK_META);

        robot.keyRelease(KeyEvent.VK_TAB);

        robot.delay(500);

        //Open Goto window

        robot.keyPress(KeyEvent.VK_META);

        robot.keyPress(KeyEvent.VK_SHIFT);

        robot.keyPress(KeyEvent.VK_G);

        robot.keyRelease(KeyEvent.VK_META);

        robot.keyRelease(KeyEvent.VK_SHIFT);

        robot.keyRelease(KeyEvent.VK_G);

//Paste the clipboard value

        robot.keyPress(KeyEvent.VK_META);

        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_META);

        robot.keyRelease(KeyEvent.VK_V);

//Press Enter key to close the Goto window and Upload window

        robot.keyPress(KeyEvent.VK_ENTER);

        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.delay(1500);

        robot.keyPress(KeyEvent.VK_ENTER);

        robot.keyRelease(KeyEvent.VK_ENTER);
    }

}
