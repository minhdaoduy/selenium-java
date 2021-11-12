package info.seleniumcucumber.pageObjects;

import info.seleniumcucumber.utils.BaseTest;
import info.seleniumcucumber.utils.DriverManager;
import info.seleniumcucumber.utils.DriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage implements BaseTest {

    private DriverManager driverManager = new DriverManager();
    private final DriverWait driverWait = new DriverWait(driverManager);
    private Registration registration;
    private PhoneOTP phoneOTP;
    private EmailVerificationPage emailVerificationPage;
    private BusinessRolePage businessRolePage;
    private OnboardPage onboardPage;

    protected AbstractPage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }
    public void setUp() {
        driverManager.getDriver();
    }

    public WebDriver getDriver() {
        return driverManager.getDriver();
    }

    public DriverWait getDriverWait() {
        return driverWait;
    }

    public Registration getRegistrationPage(){
        return (registration == null) ? registration = new Registration() : registration;
    }

    public PhoneOTP getPhoneOTP(){
        return (phoneOTP == null) ? phoneOTP = new PhoneOTP() : phoneOTP;
    }

    public EmailVerificationPage getEmailVerificationPage(){
        return (emailVerificationPage == null) ? emailVerificationPage = new EmailVerificationPage() : emailVerificationPage;
    }

    public BusinessRolePage getBusinessRolePage(){
        return (businessRolePage == null) ? businessRolePage = new BusinessRolePage() : businessRolePage;
    }

    public OnboardPage getOnboardPage(){
        return (onboardPage == null) ? onboardPage = new OnboardPage() : onboardPage;
    }


}
