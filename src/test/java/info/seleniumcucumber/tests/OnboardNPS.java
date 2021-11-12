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
        Generex generex = new Generex("([0-9]{8,9}[a-zA-Z]{1})");
        String businessRegistrationNumber = generex.getMatchedString((int)Math.floor(Math.random()*(999999999+1)+0));

        String phoneOTPCode = configFileReader.getPhoneOTPCode();
        String emailOTPCode = configFileReader.getEmailOTPCode();
        String date = configFileReader.getDate();
        String month = configFileReader.getMonth();
        int year = Integer.parseInt(configFileReader.getYear()) ;
        String gender = configFileReader.getGender();
        String country = configFileReader.getCountry();
        String category = configFileReader.getCategory();
        String industry = configFileReader.getIndustry();
        String entityType = configFileReader.getEntityType();
        String subIndustry = configFileReader.getSubIndustry();
        String businessActivity = configFileReader.getBusinessActivity();
        String website = configFileReader.getWebsite();
        String totalSpend = configFileReader.getTotalSpend();
        String kindOfIdentity = configFileReader.getKindOfIdentity();
        String kindOfIdentity2 = configFileReader.getKindOfIdentity2();




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

        onboardPage.selectTotalSpend(totalSpend);

        onboardPage.inputBusinessActivity(businessActivity);
        onboardPage.inputDetailServices(businessActivity);
        onboardPage.inputWebsite(website);
        onboardPage.clickContinue();

        onboardPage.selectKindOfIdentity(kindOfIdentity);
        onboardPage.clickContinue();

        onboardPage.selectKindOfIdentity(kindOfIdentity2);
        onboardPage.clickContinue();

        onboardPage.openUploadFilePage();
        onboardPage.uploadImage();
        onboardPage.clickContinue();
        onboardPage.waitThankYouPageDisplaying();
        onboardPage.clickContinue();
        onboardPage.clickContinue();

    }

    @AfterTest
    public void afterScenario() {
        getDriver().close();
        getDriver().quit();
    }
}
