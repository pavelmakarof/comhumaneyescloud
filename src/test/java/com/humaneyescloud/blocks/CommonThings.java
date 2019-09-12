package com.humaneyescloud.blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;

/**
 * Created by makarof on 14.05.2018.
 */
public class CommonThings {
    public WebDriver driver;

    public CommonThings(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Name("Loader")
    @FindBy(xpath = ".//div/div/div[contains(@class,\"loader\")]")
    private WebElement loader;

    @Name("Button Cancel on Page")
    @FindBy(xpath = ".//button[contains(text(),\"Cancel\")]")
    private WebElement cancelButton;

    @Name("Button Save on Page")
    @FindBy(xpath = ".//button[contains(text(),\"Save\")]")
    private WebElement saveButton;

    @Name("Cancel Or No Button")
    @FindBy(xpath = ".//section//*[@id='idAlert']//a[@data-remodal-action=\"cancel\"]")
    private WebElement modalCancelButton;

    @Name("Confirm Or Yes Button")
    @FindBy(xpath = ".//section//*[@id='idAlert']//a[@data-remodal-action=\"confirm\"]")
    private WebElement modalConfirmButton;

    @Name("Cross or Close button")
    @FindBy(xpath = "//*[@id=\"userModal\"]/div/div/div/a[contains(@data-remodal-action,'close')]")
    private WebElement modalCrossButton;

     @Name("Delete Record Button")
    @FindBy(xpath = ".//*[@aria-label='Delete']//img")
    private WebElement deleteRecordButton;

    @Name("Edit Record Button")
    @FindBy(xpath = ".//*[@aria-label='Edit']//img")
    private WebElement editRecordButton;

    @Name("Duplicate Record Button")
    @FindBy(xpath = ".//*[@aria-label='Duplicate']//img")
    private WebElement duplicateRecordButton;

    @Name("Notification")
    @FindBy(xpath = ".//app-notifications//app-notifcation-item")
    private WebElement notification;

    @Name("Three Dots Button - multiple actions")
    @FindBy(xpath = ".//button[@class=\"btn-menu-all\"]")
    private WebElement threeDotsButton;

    @Name("Three Dots Button -> Delete Button")
    @FindBy(xpath = ".//menu-all/div/ul/li/span[text()='Delete']")
    private WebElement deleteSelectedElementsButton;

    @Name("Clear Filters Button")
    @FindBy(xpath = ".//*[@class='ng-star-inserted']//span[.='clear filters']")
    public WebElement clearFiltersButton;

    @Name("Search - Name Field")
    @FindBy(xpath = ".//thead//input[@placeholder=\"Name\"]")
    private WebElement searchNameField;

    @Name("Search - Status Dropdown button")
    @FindBy(xpath = ".//thead//select-filter/div/button[@data-toggle=\"dropdown\"]")
    private WebElement searchSelectStatusDropdown;

    @Name("Active item in Status drop-down")
    @FindBy(xpath = ".//select-filter//a[contains(text(),'Active')]")
    private WebElement activeItemInStatusDropdown;

    @Name("Inactive item in Status drop-down")
    @FindBy(xpath = ".//select-filter//a[contains(text(),\"Inactive\")]")
    private WebElement inActiveItemStatusDropdown;

    @Name("Status item in Status drop-down")
    @FindBy(xpath = ".//select-filter//a[contains(text(),\"Status\")]")
    private WebElement statusItemInStatusDropdown;

    public WebElement getLoader() {
        return loader;
    }

    public WebElement getCancelButton() {
        return cancelButton;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public WebElement getModalCancelButton() {
        return modalCancelButton;
    }

    public WebElement getModalConfirmButton() {
        return modalConfirmButton;
    }

    public WebElement getModalCrossButton() {
        return modalCrossButton;
    }

    public WebElement getDeleteRecordButton() {
        return deleteRecordButton;
    }

    public WebElement getEditRecordButton() {
        return editRecordButton;
    }

    public WebElement getDuplicateRecordButton() {
        return duplicateRecordButton;
    }

    public WebElement getNotification() {
        return notification;
    }

    public WebElement getThreeDotsButton() {
        return threeDotsButton;
    }

    public WebElement getDeleteSelectedElementsButton() {
        return deleteSelectedElementsButton;
    }

    public WebElement getClearFiltersButton() {
        return clearFiltersButton;
    }

    public WebElement getSearchNameField() {
        return searchNameField;
    }

    public WebElement getSearchSelectStatusDropdown() {
        return searchSelectStatusDropdown;
    }

    public WebElement getActiveItemInStatusDropdown() {
        return activeItemInStatusDropdown;
    }

    public WebElement getInActiveItemStatusDropdown() {
        return inActiveItemStatusDropdown;
    }

    public WebElement getStatusItemInStatusDropdown() {
        return statusItemInStatusDropdown;
    }
}
