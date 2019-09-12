package com.humaneyescloud.pagemapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by makarof on 18.04.2018.
 */
public class DashboardPage {
    WebDriver driver;

    public DashboardPage (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".mb0.f5")
    private WebElement orgname;

    @FindBy(css=".btnText")
    private WebElement exportButton;

    @FindBy(css="app-organization-picker [class=\"bg-white db pa3 grey-3 pointer ng-star-inserted\"]:nth-of-type(2) span")
    private WebElement subOrg;

    @FindBy(css=".lh-title")
    private WebElement avatarDropdown;

    @FindBy(css="[class=\"db pa3 grey-3 states-bg ng-star-inserted\"]")
    private WebElement organizationSettingsButton;

    @FindBy(css="[class] .pointer:nth-of-type(2) [class]")
    private WebElement changePassword;

    @FindBy(css = "[class] .pointer:nth-of-type(3) [class]")
    private WebElement logout;

    @FindBy(css = "#logOutConfirmModal .bg-brand")
    private WebElement confirmLogout;

    @FindBy(css = "#logOutConfirmModal .ghost-btn")
    private WebElement cancelLogout;

    @FindBy(css = ".tooltip--bottom")
    private WebElement trialCounter;

    @FindBy(css=".email-not-verified")
    private WebElement emailNotVerifiedBanner;

    @FindBy(css = "app-site-menu")
    private WebElement hiddenMenu;

    @FindBy(css="app-site-menu div:nth-of-type(2) span")
    private WebElement dashboardMenuItem;

    @FindBy(css="app-site-menu div:nth-of-type(3) span")
    private WebElement itemsMenuItem;

    @FindBy(css="app-site-menu div:nth-of-type(4) span")
    private WebElement testsMenuItem;

    @FindBy(css="app-site-menu div:nth-of-type(5) span")
    private WebElement scoringMenuItem;

    @FindBy(css="app-site-menu div:nth-of-type(6) span")
    private WebElement proctoringMenuItem;

    @FindBy(css="app-site-menu div:nth-of-type(7) span")
    private WebElement resultsMenuItem;

    @FindBy(css="app-site-menu div:nth-of-type(8) span")
    private WebElement examineesMenuItem;

    public WebElement getOrgname() {
        return orgname;
    }

    public WebElement getExportButton() {
        return exportButton;
    }

    public WebElement getSubOrg() {
        return subOrg;
    }

    public WebElement getAvatarDropdown() {
        return avatarDropdown;
    }

    public WebElement getOrganizationSettingsButton() {
        return organizationSettingsButton;
    }

    public WebElement getChangePassword() {
        return changePassword;
    }

    public WebElement getLogout() {
        return logout;
    }

    public WebElement getConfirmLogout() {
        return confirmLogout;
    }

    public WebElement getCancelLogout() {
        return cancelLogout;
    }

    public WebElement getTrialCounter() {
        return trialCounter;
    }

    public WebElement getEmailNotVerifiedBanner() {
        return emailNotVerifiedBanner;
    }

    public WebElement getHiddenMenu() {
        return hiddenMenu;
    }

    public WebElement getDashboardMenuItem() {
        return dashboardMenuItem;
    }

    public WebElement getItemsMenuItem() {
        return itemsMenuItem;
    }

    public WebElement getTestsMenuItem() {
        return testsMenuItem;
    }

    public WebElement getScoringMenuItem() {
        return scoringMenuItem;
    }

    public WebElement getProctoringMenuItem() {
        return proctoringMenuItem;
    }

    public WebElement getResultsMenuItem() {
        return resultsMenuItem;
    }

    public WebElement getExamineesMenuItem() {
        return examineesMenuItem;
    }
}
