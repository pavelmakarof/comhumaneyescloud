package com.humaneyescloud.pagemapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;

import java.util.List;

public class CatPage {
    public WebDriver driver;

    public CatPage (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Name("CAT title")
    @FindBy(xpath = ".//app-cat//h1[contains(text(),'Custom Scoring Scale')]")
    private WebElement catTitle;

    @Name("Counter of displayed CAT")
    @FindBy(xpath = ".//app-cat/div/app-list/div/div/div[1]/span")
    private WebElement counterOfDisplayingCats;

    @Name("New CAT button")
    @FindBy(xpath = ".//app-cat//a[contains(@href,\"/home/cat/manage\")]")
    private WebElement newCatButton;

    @Name("First CAT Record")
    @FindBy(xpath = ".//tbody/tr[1]/td[1]/ng2-smart-table-cell/table-cell-view-mode/div/div")
    private WebElement firstCatRecord;

    @Name("List Of Inactive Cats")
    @FindBy(xpath = ".//app-cat//tbody//span[contains(text(),'Inactive')]")
    private List<WebElement> listOfInactiveCats;

    @Name("CAT names of Inactive elements")
    @FindBy(xpath = ".//tbody/tr/td//span[text()='Inactive']/ancestor::*/td[1]//div/div")
    private List<WebElement> catNamesOfInactiveElements;

    @Name("CAT names of Active elements")
    @FindBy(xpath = ".//tbody/tr/td//span[text()='Active']/ancestor::*/td[1]//div/div")
    private List<WebElement> rubricNamesOfActiveElements;

    @Name("New CAT - Name")
    @FindBy(xpath = ".//*[contains(@id,'name') and contains(@placeholder,\"Enter the name of your scoring scale\")]")
    private WebElement newCatName;

    @Name("New CAT - Description")
    @FindBy(xpath = ".//*[contains(@id,'name') and contains(@placeholder,\"Enter your description here..\")]")
    private WebElement newCatDescription;

    @Name("New CAT - Maximum Raw Score")
    @FindBy(xpath = ".//*[contains(@id,'name') and contains(@placeholder,\"Enter maximum scores\")]")
    private WebElement newCatMaximumRawScore;

    @Name("New CAT - Add Tier Button")
    @FindBy(xpath = ".//button[text()=\"Add\"]")
    private WebElement newCatAddTierButton;

    @Name("New CAT - Scoring Tier - Name")
    @FindBy(xpath = ".//*[contains(@id,'name') and contains(@formcontrolname,\"name\")]")
    private List<WebElement> newCatTierName;

    @Name("New CAT - Scoring Tier - Staring Raw Score")
    @FindBy(xpath = ".//*[contains(@id,'name') and contains(@placeholder,\"Staring Raw Score\")]")
    private List<WebElement> newCatTierStaringRawScore;

    @Name("New CAT - Scoring Tier - Ending Raw Score")
    @FindBy(xpath = ".//*[contains(@id,'name') and contains(@placeholder,\"Ending Raw Score\")]")
    private List<WebElement> newCatTierEndingRawScore;

    @Name("New CAT - Scoring Tier - Description")
    @FindBy(xpath = ".//*[contains(@id,'name') and contains(@formcontrolname,\"description\")]")
    private List<WebElement> newCatTierDescription;

    @Name("New CAT - Scoring Tier - Checkbox Select Passing Tier")
    @FindBy(xpath = ".//label[contains(text(),\"Make this tier the passing score\")]")
    private List<WebElement> newCatTierCheckboxSelectPassingTier;

    @Name("New CAT - Delete Tier Button")
    @FindBy(xpath = ".//app-card-container//div/img[contains(@alt,\"remove\")]")
    private WebElement newCatDeleteTierButton;


    @Name("New CAT - Show Certificate Preview")
    @FindBy(xpath = ".//button[contains(text(),\"Show Preview\")]")
    private List<WebElement> newCatShowCertificatePreview;

    @Name("New CAT - ok button in modal window")
    @FindBy(xpath = "/html//div[@id='idAlert']/div[@class='vmiddle-wrap']/div/div//a[contains(@data-remodal-action,\"confirm\") and contains(text(),\"Ok\")]")
    private WebElement okButtonInModal;

    @Name("New CAT - WYSIWYG - bold")
    @FindBy(xpath = "//*[@id=\"toolbar\"]//button[contains(@class,'ql-bold')]")
    private WebElement boldButtonInWysiwyg;

    @Name("WYSIWYG")
    @FindBy(xpath = "//div[@id='editor']/div[@class='ql-editor']")
    private WebElement wysiwyg;

    public WebElement getWysiwyg(){
        return wysiwyg;
    }

    public WebElement getBoldButtonInWysiwyg() {
        return boldButtonInWysiwyg;
    }

    public WebElement getCatTitle() {
        return catTitle;
    }

    public WebElement getCounterOfDisplayingCats() {
        return counterOfDisplayingCats;
    }

    public WebElement getNewCatButton() {
        return newCatButton;
    }

    public WebElement getFirstCatRecord() {
        return firstCatRecord;
    }

    public List<WebElement> getListOfInactiveCats() {
        return listOfInactiveCats;
    }

    public List<WebElement> getCatNamesOfInactiveElements() {
        return catNamesOfInactiveElements;
    }

    public List<WebElement> getRubricNamesOfActiveElements() {
        return rubricNamesOfActiveElements;
    }

    public WebElement getNewCatName() {
        return newCatName;
    }

    public WebElement getNewCatDescription() {
        return newCatDescription;
    }

    public WebElement getNewCatMaximumRawScore() {
        return newCatMaximumRawScore;
    }

    public WebElement getNewCatAddTierButton() {
        return newCatAddTierButton;
    }

    public List<WebElement> getNewCatTierName() {
        return newCatTierName;
    }

    public List<WebElement> getNewCatTierStaringRawScore() {
        return newCatTierStaringRawScore;
    }

    public List<WebElement> getNewCatTierEndingRawScore() {
        return newCatTierEndingRawScore;
    }

    public List<WebElement> getNewCatTierDescription() {
        return newCatTierDescription;
    }

    public List<WebElement> getNewCatTierCheckboxSelectPassingTier() {
        return newCatTierCheckboxSelectPassingTier;
    }


    public WebElement getNewCatDeleteTierButton() {
        return newCatDeleteTierButton;
    }

    public List<WebElement> getNewCatShowCertificatePreview() {
        return newCatShowCertificatePreview;
    }

    public WebElement getOkButtonInModal() {
        return okButtonInModal;
    }

}
