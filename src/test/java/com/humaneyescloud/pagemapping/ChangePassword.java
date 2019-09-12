package com.humaneyescloud.pagemapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by makarof on 18.04.2018.
 */
public class ChangePassword {
    public WebDriver driver;

    public ChangePassword (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css=".lh-title.mb2")
    private WebElement titleChangePassword;

    @FindBy(css="[class=\"input w-100 ng-untouched ng-pristine ng-invalid\"]")
    private WebElement emailforchangepass;

    @FindBy(css=".ghost-btn.bg-brand")
    private WebElement submitButton;

    @FindBy(css="[class=\"f5 lh-title mb3 w-100 tc\"]")
    private WebElement successPage;

    @FindBy(css=".w4")
    private WebElement okButton;

    public WebElement getTitleChangePassword() {
        return titleChangePassword;
    }

    public WebElement getEmailforchangepass() {
        return emailforchangepass;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getSuccessPage() {
        return successPage;
    }

    public WebElement getOkButton() {
        return okButton;
    }

}
