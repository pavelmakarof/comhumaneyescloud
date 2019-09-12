package com.humaneyescloud.steps;

import com.humaneyescloud.pagemapping.DashboardPage;
import com.humaneyescloud.pagemapping.SignInPage;
import static com.humaneyescloud.utils.TestData.*;

import com.humaneyescloud.utils.TestData;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static ru.yandex.qatools.htmlelements.matchers.MatcherDecorators.should;
import static ru.yandex.qatools.htmlelements.matchers.MatcherDecorators.timeoutHasExpired;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasValue;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

/**
 * Created by makarof on 18.04.2018.
 */
public class CommonSteps {
    private WebDriver driver;
    DashboardPage dashboardPage = new DashboardPage(driver);
    SignInPage signInPage = new SignInPage(driver);
    private static final int DEFAULT_WAITING_TIMEOUT = 10;

    public CommonSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Make screenshot")
    @Attachment
    public byte[] makeScreenshot(String filename) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}

    @Step("Webelement should be visible")
    public void shouldSee(WebElement element){
        assertThat(element + " is not displayed", element, should(isDisplayed()).whileWaitingUntil(timeoutHasExpired(SECONDS.toMillis(DEFAULT_WAITING_TIMEOUT))));
    }

    public boolean isElementDisplayed(WebElement element){
        return !element.isDisplayed();
    }

    @Step("Webelement should not be visible")
    public void shouldNotSee(WebElement element) throws InterruptedException {
        assertThat(element + "is displayed", element, should(not(isDisplayed())).whileWaitingUntil(timeoutHasExpired(SECONDS.toMillis(DEFAULT_WAITING_TIMEOUT))));
        Thread.sleep(1500);
    }

    @Step("Navigate ro url")
    public void getPage(String url) {
        driver.get(url);
    }

    @Step("Login to site")
    public void goToDashboardPage(SignInPage signInPage){
        //dashboardPage = new DashboardPage(driver);
        getPage(baseUrl());
        textInput(signInPage.getUsername(),orgUser());
        textInput(signInPage.getUserpass(),userPass());
        click(signInPage.getSigninbutton());

    }

    @Step("Insert text to input field")
    public void textInput(WebElement element, String text) {
        shouldSee(element);
        element.clear();
        element.sendKeys(text);
    }

    @Step("Click")
    public void click(WebElement element) {
        shouldSee(element);
        element.click();
    }

    @Step("Get text of element")
    public String getText(WebElement element) {
        shouldSee(element);
        return element.getText();
    }

    @Step("Hover and click on element")
    public void move(WebElement element) {
        Actions action = new Actions(driver);
        shouldSee(element);
        action.moveToElement(element).perform();
        action.click().build().perform();
    }

    @Step("Hover on element")
    public void hover(WebElement element) {
        Actions action = new Actions(driver);
        shouldSee(element);
        action.moveToElement(element).perform();
    }

    @Step("DoubleClick on element")
    public void doubleClick(WebElement element) {
        Actions action = new Actions(driver);
        shouldSee(element);
        action.doubleClick().build().perform();
    }

    @Step("Get Attribute Value")
    public String getAttributeValue(WebElement element, String attributeName) {
        shouldSee(element);
        return element.getAttribute(attributeName);
    }

    public void sleepThread(int  waitTime) throws InterruptedException {
        Thread.sleep(waitTime);
    }

    @Step
    public void shouldSeeText(WebElement element, String text) {
        shouldSee(element);
        assertThat(element + " text is incorrect", element, should(hasText(text)).whileWaitingUntil(timeoutHasExpired(SECONDS.toMillis(DEFAULT_WAITING_TIMEOUT))));
    }

    @Step
    public void shouldSeeValue(WebElement element, String text) {
        shouldSee(element);
        assertThat(element + " text is incorrect", element, should(hasValue(text)).whileWaitingUntil(timeoutHasExpired(SECONDS.toMillis(DEFAULT_WAITING_TIMEOUT))));
    }

    @Step
    @DisplayName("Is element enabled")
    public boolean isButtonEnabled(WebElement element){
        return element.isEnabled();
    }

    @Step
    @DisplayName("Refresh page")
    public void refreshPage() throws InterruptedException {
        driver.navigate().refresh();
        sleepThread(5000);
    }

    @Step
    @DisplayName("Go to Organization Settings Button")
    public void goToOrganizationSettingsPage() throws InterruptedException{
        move(dashboardPage.getAvatarDropdown());
        click(dashboardPage.getOrganizationSettingsButton());
        sleepThread(2000);
    }

    @Step
    @DisplayName("Get size of array")
    public int getListArraySize(List<WebElement> elements ){
        int arraySize = elements.size();
        return arraySize;
    }

    @Step
    @DisplayName("Get element from array")
    public WebElement getElememtFromArray(List<WebElement> elements, int value ){
        WebElement element = elements.get(value);
        return element;
    }

    @Step
    @DisplayName("Scroll")
    public void jsScrollTo(int a, int b) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(" + a + "," + b + ");");
    }

    @Step
    public void assertEquals(String string, WebElement webElement){
        Assert.assertEquals(string, webElement.getText());
    }

    @Step
    public void assertNotEquals(String string, WebElement webElement){
        Assert.assertNotEquals(string, webElement.getText());
    }

    @Step
    public void assertTrue(String string, boolean value)
    {
        Assert.assertTrue(string, value);
    }

    @Step
    public void assertFalse(String string, boolean value)
    {
        Assert.assertFalse(string, value);
    }
}

