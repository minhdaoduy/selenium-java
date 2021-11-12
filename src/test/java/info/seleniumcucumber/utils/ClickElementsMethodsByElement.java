package info.seleniumcucumber.utils;

import info.seleniumcucumber.pageObjects.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

import static java.lang.Integer.parseInt;

public class ClickElementsMethodsByElement extends AbstractPage implements BaseTest {
    private WebElement element = null;

    /**
     * Method to click on an element
     *
     * @param element : WebElement : WebElement type
     */
    public void click(WebElement element) throws NoSuchFieldException {
//        getDriverWait().waitForElementToLoad(element);
//        element.click();
        for (int i = 0; i <= 15; i++) {
            try {
                getDriverWait().waitForElementToLoad(element);
                element.click();
                return;
            } catch (Throwable e) {
                if (i == 15)
                    throw new NoSuchFieldException("could not interact with the element " + element);
            }
        }
    }

    public void clickByType(String accessType, String accessName) throws NoSuchFieldException {

        for (int i = 0; i <= 5; i++) {
            try {
                element = getDriverWait().waitLong().until(ExpectedConditions.elementToBeClickable(getelementbytype(accessType, accessName)));
                element.click();
                return;
            } catch (Throwable e) {
                if (i == 5)
                    throw new NoSuchFieldException("could not interact with the element " + element);
            }
        }
    }
    public void selectOption(WebElement ele,String text) throws NoSuchFieldException {
        String accessName = "//div[contains(@class,'q-item__section')]//span[text()='"+text+"']";
        String result = "//span[text()='"+text+"']";
//        clickObj.clickByType("xpath", "//div[contains(@class,'q-item__section')]//span[text()='"+text+"']");
        getDriverWait().waitForElementToLoad(ele);

        for (int i = 0; i <= 100; i++) {
            try {
                ele.click();
                element = getDriverWait().waitShort().until(ExpectedConditions.elementToBeClickable(getelementbytype("xpath", accessName)));
                element.click();
                getDriverWait().waitShort().until(ExpectedConditions.elementToBeClickable(getelementbytype("xpath", result)));
                return;
            } catch (Throwable e) {
//                if (i == 100)
//                    throw new NoSuchFieldException("could not interact with the element " + element);
            }
        }

    }

    public void chooseYear(int year) throws NoSuchFieldException, InterruptedException {
        Thread.sleep(350);
        WebElement lblYear = getDriver().findElement(By.xpath("//*[contains(@class,'q-date__navigation')]/div[5]"));
        if (year<parseInt(lblYear.getText())) {
            clickObj.click(getDriver().findElement(By.xpath("//*[contains(@class,'q-date__navigation')]/div[4]")));
            chooseYear(year);
        } else if (year>parseInt(lblYear.getText())) {
            clickObj.click(getDriver().findElement(By.xpath("//*[contains(@class,'q-date__navigation')]/div[6]")));
            chooseYear(year);
        }

    }

    public void chooseMonth(String month) throws NoSuchFieldException, InterruptedException {
        Thread.sleep(300);
        WebElement lblMonth = getDriver().findElement(By.xpath("//*[contains(@class,'q-date__navigation')]/div[2]"));
        if (!Objects.equals(month, lblMonth.getText())) {
            clickObj.click(getDriver().findElement(By.xpath("//*[contains(@class,'q-date__navigation')]/div[1]")));
            chooseMonth(month);
        }

    }

    public void chooseDateOfBirth(String date, String month, int year) throws NoSuchFieldException, InterruptedException {
        chooseMonth(month);
        chooseYear(year);
        clickObj.click(getDriver().findElement(By.xpath("//span[@class='block' and text()='"+date+"']")));
    }

    /**
     * Method to forcefully click on an element
     *
     * @param element : WebElement : WebElement type
     */
    public void clickForcefully(WebElement element)  throws NoSuchFieldException {
        getDriverWait().waitForElementToLoad(element);
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * Method to Double click on an element
     *
     * @param element : WebElement : WebElement type
     */
    public void doubleClick(WebElement element)  throws NoSuchFieldException {
        getDriverWait().waitForElementToLoad(element);

        Actions action = new Actions(getDriver());
        action.moveToElement(element).doubleClick().perform();
    }

    /**
     * Method to select element 'by' type
     *
     * @param type        : String : 'By' type
     * @param access_name : String : Locator value
     * @return By
     */
    public By getelementbytype(String type, String access_name) {
        switch (type) {
            case "id":
                return By.id(access_name);
            case "name":
                return By.name(access_name);
            case "class":
                return By.className(access_name);
            case "xpath":
                return By.xpath(access_name);
            case "css":
                return By.cssSelector(access_name);
            case "linkText":
                return By.linkText(access_name);
            case "partialLinkText":
                return By.partialLinkText(access_name);
            case "tagName":
                return By.tagName(access_name);
            default:
                return null;

        }
    }
}