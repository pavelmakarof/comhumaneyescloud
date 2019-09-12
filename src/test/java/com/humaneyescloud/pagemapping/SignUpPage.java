package com.humaneyescloud.pagemapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by makarof on 18.04.2018.
 */
public class SignUpPage {
    public WebDriver driver;

    public SignUpPage (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getNeworgname() {
        return neworgname;
    }

    public String neworgpubl;

    @FindBy(xpath = "/html//input[@id='organizationName']")
    private WebElement neworgname;

    @FindBy(xpath = "/html//input[@id='name']")
    private WebElement firstName;

    @FindBy(xpath = "/html//input[@id='surname']")
    private WebElement lastName;

    @FindBy(xpath = "/html//input[@id='email']")
    private WebElement orgEmail;

    @FindBy(xpath = "/html//input[@id='password']")
    private WebElement orgPass;

    @FindBy(css = ".states-opacity.db")
    private WebElement signupButton;

    @FindBy(css = ".w4")
    private WebElement continueButton;

    @FindBy(css = ".forgot_email")
    private WebElement successSignUpText;



    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getOrgEmail() {
        return orgEmail;
    }

    public WebElement getOrgPass() {
        return orgPass;
    }

    public WebElement getSignupButton() {
        return signupButton;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getSuccessSignUpText() {
        return successSignUpText;
    }

    public String getNeworgpubl() {
        return neworgpubl;
    }

}
