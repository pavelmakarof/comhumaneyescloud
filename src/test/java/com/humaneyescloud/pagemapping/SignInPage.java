package com.humaneyescloud.pagemapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by makarof on 18.04.2018.
 */
public class SignInPage {
    public WebDriver driver;

    public SignInPage (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "#username")
    private WebElement username;

    @FindBy(css = "[class=\"input w-100 ng-untouched ng-pristine ng-invalid\"]")
    private WebElement userpass;

    @FindBy(css=".b-brand.db")
    private WebElement signinbutton;

    @FindBy(css=".b-brand.mr3")
    private WebElement getStartedButton;

    public WebElement getUsername() {
        return username;
    }

    public WebElement getUserpass() {
        return userpass;
    }

    public WebElement getSigninbutton() {
        return signinbutton;
    }

    public WebElement getGetStartedButton() {
        return getStartedButton;
    }
}
