package info.seleniumcucumber.tests;

import com.mifmif.common.regex.Generex;
import info.seleniumcucumber.pageObjects.*;
import io.cucumber.java.Scenario;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.*;

import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class OnboardNPS extends AbstractPage {
    Registration registration;
    PhoneOTP phoneOTP;
    EmailVerificationPage emailVerificationPage;
    BusinessRolePage businessRolePage;
    OnboardPage onboardPage;

    public OnboardNPS()
    {
        registration = getRegistrationPage();
        phoneOTP = getPhoneOTP();
        emailVerificationPage = getEmailVerificationPage();
        businessRolePage = getBusinessRolePage();
        onboardPage = getOnboardPage();
    }

    @BeforeTest
    public void beforeScenario() {
        setUp();
    }

    @Test
    public void RegistrationAndOnboardNPS() throws NoSuchFieldException, InterruptedException, AWTException {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String personName = RandomStringUtils.randomAlphabetic(8);
        String personPhone = String.valueOf((int)Math.floor(Math.random()*(999999999-100000000+1)+100000000));
        String personEmail = personName+"@gmail.com";
        String phoneOTPCode = "1234";
        String emailOTPCode = "1234";
        String date = "05";
        String month = "May";
        int year = 2000;
        String gender = "05 May 1987";
        String country = "05 May 1987";
        String category = "Limited companies";
        Generex generex = new Generex("([0-9]{8,9}[a-zA-Z]{1})");
        String businessRegistrationNumber = generex.getMatchedString((int)Math.floor(Math.random()*(999999999+1)+0));
        String industry = "Business Services";
        String entityType = "Limited partnership";
        String subIndustry = "Holding Companies";
        String businessActivity = "test test test test test test test test test test test";

        registration.navigateToRegistrationPage();

        registration.enterPersonName(personName);
        registration.enterPersonEmail(personEmail);
        registration.enterPersonPhone(personPhone);
        registration.clickPersonPrivacy();
        registration.clickContinue();

        phoneOTP.inputPhoneOTP(phoneOTPCode);

        emailVerificationPage.clickContinue();

        businessRolePage.chooseDirectorOption();
        businessRolePage.choosePayment();
        businessRolePage.clickContinue();
        businessRolePage.clickStandardGetStart();

        onboardPage.selectGender(gender);
        onboardPage.chooseDateOfBirth(date, month, year);
        onboardPage.selectCountry(country);
        onboardPage.clickContinue();

        phoneOTP.inputPhoneOTP(emailOTPCode);

        onboardPage.inputBusinessLegal(personName);
        onboardPage.inputBusinessRegistrationNumber(businessRegistrationNumber);
        onboardPage.inputCategory(category);
        onboardPage.selectEntityType(entityType);
        onboardPage.selectIndustry(industry);
        onboardPage.selectSubIndustry(subIndustry);
        onboardPage.clickContinue();

        onboardPage.selectTotalSpend("");

        onboardPage.inputBusinessActivity(businessActivity);
        onboardPage.inputDetailServices("");
        onboardPage.inputWebsite("");
        onboardPage.clickContinue();

        onboardPage.selectKindOfIdentity("Identification number");
        onboardPage.clickContinue();

        onboardPage.selectKindOfIdentity("International Passport");
        onboardPage.clickContinue();

        onboardPage.openUploadFilePage();
        onboardPage.uploadImage();
        onboardPage.clickContinue();
        onboardPage.waitThankYouPageDisplaying();
        onboardPage.clickContinue();
        onboardPage.clickContinue();

    }

    @AfterTest
    public void afterScenario(Scenario scenario) throws IOException {
        getDriver().close();
        getDriver().quit();
    }
}
