package com.humaneyescloud.pagemapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by makarof on 18.04.2018.
 */
public class SubOrganizationPage {
    WebDriver driver;

    public SubOrganizationPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    //"+Add Sub Organization" button on sub-organization management page
    @FindBy(css=".ml2")
    private WebElement addNewSubOrgButton;

    //"Sub Organization Name" field on Add new sub-organization page
    @FindBy(css="#organizationName")
    private WebElement newSubOrgName;

    //"Description" field on Add new sub-organization page
    @FindBy(xpath=".//*[@id='subOrganizationDescription']")
    private WebElement newSubOrgDescr;

    //"Submit" button on Add new sub-organization page
    @FindBy(xpath=".//app-organization-create/div[3]/form/div[3]/div/div/button")
    private WebElement submitNewSubOrgButton;

    //"Cancel" button on Add new sub-organization page
    @FindBy(css=".items-start .ghost-btn")
    private WebElement cancelNewSubOrgButton;

    //"Back to list" button on Add new sub-organization page
    @FindBy(css=".link")
    private WebElement backToSubOrgsListButton;

    @FindBy(css="[class=\"col-4 tl\"] .mb0")
    private WebElement firstSubOrgName;

    @FindBy(xpath=".//app-organization-list/div/main/div/div[1]/a/div[2]/p")
    private WebElement firstSubOrgDescr;

    @FindBy(css="#search-bar .ng-valid")
    private WebElement searchField;

    @FindBy(xpath = ".//*[@id='search-bar']/button")
    private WebElement applySearchButton;

    @FindBy(css = "#userModal [clip-rule]")
    private WebElement crossInModal;

    @FindBy(css=".text-danger.ng-star-inserted")
    private WebElement validationMessageNameIsRequired;

    @FindBy(css=".mb3:nth-child(1) .ng-star-inserted")
    private WebElement validationMessageNameIsLong;

    @FindBy(css=".mb3+ .mb3 .ng-star-inserted")
    private WebElement validationMessageDescriptionIsLong;

    @FindBy(xpath = ".//app-organization-list/div/main/div[1]")
    private WebElement noSearchResults;

    @FindBy(xpath = ".//div[1]/div[1]/*[@id='menu1' and contains(@class,'states-bg')]")
    private WebElement optionsButton;

    @FindBy(xpath = ".//main//*[@id='profile-options']/li[1]/a")
    private WebElement viewOptionButton;

    @FindBy(xpath = ".//main//*[@id='profile-options']/li[2]/a")
    private WebElement editOptionButton;

    @FindBy(xpath = ".//app-general-layout/app-organization-view/div[1]/h1")
    private WebElement viewSubOrgTitle;

    @FindBy(xpath = ".//app-organization-edit/div[3]/form/div[3]/div/div/button")
    private WebElement updateSubOrgButton;

    public WebElement getNewSubOrgName() {
        return newSubOrgName;
    }

    public WebElement getAddNewSubOrgButton() {
        return addNewSubOrgButton;
    }

    public WebElement getNewSubOrgDescr() {
        return newSubOrgDescr;
    }

    public WebElement getSubmitNewSubOrgButton() {
        return submitNewSubOrgButton;
    }

    public WebElement getCancelNewSubOrgButton() {
        return cancelNewSubOrgButton;
    }

    public WebElement getBackToSubOrgsListButton() {
        return backToSubOrgsListButton;
    }

    public WebElement getFirstSubOrgName() {
        return firstSubOrgName;
    }

    public WebElement getFirstSubOrgDescr() {
        return firstSubOrgDescr;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getApplySearchButton() {
        return applySearchButton;
    }

    public WebElement getCrossInModal() {
        return crossInModal;
    }

    public WebElement getValidationMessageNameIsRequired() {
        return validationMessageNameIsRequired;
    }

    public WebElement getValidationMessageNameIsLong() {
        return validationMessageNameIsLong;
    }

    public WebElement getValidationMessageDescriptionIsLong() {
        return validationMessageDescriptionIsLong;
    }

    public WebElement getNoSearchResults() {
        return noSearchResults;
    }

    public WebElement getOptionsButton() {
        return optionsButton;
    }

    public WebElement getViewOptionButton() {
        return viewOptionButton;
    }

    public WebElement getEditOptionButton() {
        return editOptionButton;
    }

    public WebElement getViewSubOrgTitle() {
        return viewSubOrgTitle;
    }

    public WebElement getUpdateSubOrgButton() {
        return updateSubOrgButton;
    }
}
