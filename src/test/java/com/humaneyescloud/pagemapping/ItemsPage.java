package com.humaneyescloud.pagemapping;

import com.humaneyescloud.steps.CommonSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by makarof on 18.04.2018.
 */
public class ItemsPage {
    WebDriver driver;
    CommonSteps commonSteps;
    private static final int DEFAULT_WAITING_TIMEOUT = 10;
    public ItemsPage (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(css = ".lh-title.mb2")
    private WebElement itemsPageTitle;

    public WebElement getItemsPageTitle() {
        return itemsPageTitle;
    }
}
