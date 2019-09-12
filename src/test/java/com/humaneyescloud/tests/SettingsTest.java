package com.humaneyescloud.tests;

import com.humaneyescloud.utils.BasicBeforeAfter;
import com.humaneyescloud.pagemapping.*;
import com.humaneyescloud.steps.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;

import static com.humaneyescloud.utils.TestData.*;

public class SettingsTest extends BasicBeforeAfter {
    SignInPage signInPage;
    DashboardPage dashboardPage;
    OrganizationSettings organizationSettings;
    SubOrganizationPage subOrganizationPage;
    GeneralPage generalPage;
    TagsPage tagsPage;

    CommonSteps commonSteps;

    @Before
    public void setupClass() {
        signInPage = new SignInPage(driver);
        dashboardPage = new DashboardPage(driver);
        organizationSettings = new OrganizationSettings(driver);
        subOrganizationPage = new SubOrganizationPage(driver);
        generalPage = new GeneralPage(driver);
        tagsPage = new TagsPage(driver);
        commonSteps = new CommonSteps(driver);
        commonSteps.goToDashboardPage(signInPage);
        commonSteps.assertEquals(orgName(),dashboardPage.getOrgname());
    }

    @Test
    @DisplayName("Add sub-organization without Description")
    public void subOrgWithoutDescription001()throws InterruptedException{
        commonSteps.move(dashboardPage.getAvatarDropdown());
        commonSteps.click(dashboardPage.getOrganizationSettingsButton());
        commonSteps.sleepThread(2000);
        commonSteps.click(organizationSettings.getSubOrgsButton());
        commonSteps.click(subOrganizationPage.getAddNewSubOrgButton());
        String tempSubOrgName = randomValueMethod();
        commonSteps.textInput(subOrganizationPage.getNewSubOrgName(),tempSubOrgName);
        commonSteps.click(subOrganizationPage.getSubmitNewSubOrgButton());
        commonSteps.sleepThread(5000);
        commonSteps.textInput(subOrganizationPage.getSearchField(),tempSubOrgName);
        commonSteps.click(subOrganizationPage.getApplySearchButton());
        commonSteps.assertEquals(tempSubOrgName,subOrganizationPage.getFirstSubOrgName());
    }

    @Test
    @DisplayName("Add sub-organization with Description")
    public void subOrgWithDescription002()throws InterruptedException{
        commonSteps.move(dashboardPage.getAvatarDropdown());
        commonSteps.click(dashboardPage.getOrganizationSettingsButton());
        commonSteps.sleepThread(2000);
        commonSteps.click(organizationSettings.getSubOrgsButton());
        commonSteps.click(subOrganizationPage.getAddNewSubOrgButton());
        String tempSubOrgName = randomValueMethod();
        commonSteps.textInput(subOrganizationPage.getNewSubOrgName(),tempSubOrgName);
        commonSteps.textInput(subOrganizationPage.getNewSubOrgDescr(),tempSubOrgName);
        commonSteps.click(subOrganizationPage.getSubmitNewSubOrgButton());
        commonSteps.sleepThread(5000);
        commonSteps.textInput(subOrganizationPage.getSearchField(),tempSubOrgName);
        commonSteps.click(subOrganizationPage.getApplySearchButton());
        commonSteps.assertEquals(tempSubOrgName,subOrganizationPage.getFirstSubOrgName());
        commonSteps.assertEquals(tempSubOrgName,subOrganizationPage.getFirstSubOrgDescr());
    }

    @Test
    @DisplayName("Cancel sub-organization creation")
    public void cancelSuborganizationCreation003()throws InterruptedException{
        commonSteps.move(dashboardPage.getAvatarDropdown());
        commonSteps.click(dashboardPage.getOrganizationSettingsButton());
        commonSteps.sleepThread(2000);
        commonSteps.click(organizationSettings.getSubOrgsButton());
        commonSteps.click(subOrganizationPage.getAddNewSubOrgButton());
        String tempSubOrgName = randomValueMethod();
        commonSteps.textInput(subOrganizationPage.getNewSubOrgName(),tempSubOrgName);
        commonSteps.textInput(subOrganizationPage.getNewSubOrgDescr(),tempSubOrgName);
        commonSteps.click(subOrganizationPage.getCancelNewSubOrgButton());
        commonSteps.textInput(subOrganizationPage.getSearchField(),tempSubOrgName);
        commonSteps.click(subOrganizationPage.getApplySearchButton());
        commonSteps.assertEquals(noRecordsFoundMethod(),subOrganizationPage.getNoSearchResults());
    }

    @Test
    @DisplayName("Add sub-organization without Name")
    public void subOrgWithoutName004()throws InterruptedException{
        commonSteps.move(dashboardPage.getAvatarDropdown());
        commonSteps.click(dashboardPage.getOrganizationSettingsButton());
        commonSteps.sleepThread(2000);
        commonSteps.click(organizationSettings.getSubOrgsButton());
        commonSteps.click(subOrganizationPage.getAddNewSubOrgButton());
        commonSteps.click(subOrganizationPage.getNewSubOrgName());
        commonSteps.textInput(subOrganizationPage.getNewSubOrgDescr(),thirtyThreeSymbolsMethod());
        commonSteps.assertEquals(validationMessageSubOrgNameIsRequired(),subOrganizationPage.getValidationMessageNameIsRequired());
        commonSteps.assertFalse("The Submit button is enabled", commonSteps.isButtonEnabled(subOrganizationPage.getSubmitNewSubOrgButton()));
    }

    @Test
    @DisplayName("Check max available count of chracters")
    public void checkMaxAvailableCountOfChracters005()throws InterruptedException{
        commonSteps.move(dashboardPage.getAvatarDropdown());
        commonSteps.click(dashboardPage.getOrganizationSettingsButton());
        commonSteps.sleepThread(2000);
        commonSteps.click(organizationSettings.getSubOrgsButton());
        commonSteps.click(subOrganizationPage.getAddNewSubOrgButton());
        commonSteps.textInput(subOrganizationPage.getNewSubOrgName(),thirtyThreeSymbolsMethod());
        commonSteps.textInput(subOrganizationPage.getNewSubOrgDescr(),oneHundredTwentyFiveSymbolsMethod());
        commonSteps.assertEquals(validationMessageSubOrgNameIsLong(),subOrganizationPage.getValidationMessageNameIsLong());
        commonSteps.assertEquals(validationMessageSubOrgDescriptionIsLong(),subOrganizationPage.getValidationMessageDescriptionIsLong());
        commonSteps.assertFalse("The Submit button is enabled", commonSteps.isButtonEnabled(subOrganizationPage.getSubmitNewSubOrgButton()));
    }

    @Test
    @DisplayName("View Sub organization via left mouse click")
    public void viewSubOrgViaLeftMouseClick006()throws InterruptedException{
        commonSteps.move(dashboardPage.getAvatarDropdown());
        commonSteps.click(dashboardPage.getOrganizationSettingsButton());
        commonSteps.sleepThread(2000);
        commonSteps.click(organizationSettings.getSubOrgsButton());
        commonSteps.click(subOrganizationPage.getFirstSubOrgName());
        commonSteps.assertEquals(viewSubOrgMethod(),subOrganizationPage.getViewSubOrgTitle());
    }

    @Test
    @DisplayName("View Sub organization via View Option button")
    public void viewSubOrgViaViewOptionButton007()throws InterruptedException{
        commonSteps.move(dashboardPage.getAvatarDropdown());
        commonSteps.click(dashboardPage.getOrganizationSettingsButton());
        commonSteps.sleepThread(2000);
        commonSteps.click(organizationSettings.getSubOrgsButton());
        commonSteps.click(subOrganizationPage.getOptionsButton());
        commonSteps.click(subOrganizationPage.getViewOptionButton());
        commonSteps.assertEquals(viewSubOrgMethod(),subOrganizationPage.getViewSubOrgTitle());
    }

    @Test
    @DisplayName("Edit Sub organization via Edit Option button")
    public void editSubOrgViaEditOptionButton008()throws InterruptedException{
        commonSteps.move(dashboardPage.getAvatarDropdown());
        commonSteps.click(dashboardPage.getOrganizationSettingsButton());
        commonSteps.sleepThread(2000);
        commonSteps.click(organizationSettings.getSubOrgsButton());
        commonSteps.click(subOrganizationPage.getOptionsButton());
        commonSteps.click(subOrganizationPage.getEditOptionButton());
        String tempSubOrgName = randomValueMethod();
        commonSteps.textInput(subOrganizationPage.getNewSubOrgName(),tempSubOrgName);
        commonSteps.textInput(subOrganizationPage.getNewSubOrgDescr(),tempSubOrgName);
        commonSteps.click(subOrganizationPage.getUpdateSubOrgButton());
        Thread.sleep(5000);
        commonSteps.textInput(subOrganizationPage.getSearchField(),tempSubOrgName);
        commonSteps.click(subOrganizationPage.getApplySearchButton());
        commonSteps.assertEquals(tempSubOrgName,subOrganizationPage.getFirstSubOrgName());
        commonSteps.assertEquals(tempSubOrgName,subOrganizationPage.getFirstSubOrgDescr());
    }

    @Test
    @DisplayName("Add Support Email to Suborganization")
    public void AddSupportEmailToOrganization()throws InterruptedException {
        commonSteps.move(dashboardPage.getAvatarDropdown());
        commonSteps.click(dashboardPage.getOrganizationSettingsButton());
        commonSteps.sleepThread(2000);
        commonSteps.textInput(generalPage.getSupportEmailInput(),orgUser());
        commonSteps.click(generalPage.getSaveSupportEmailButton());
        commonSteps.refreshPage();
        commonSteps.assertTrue("Support email is incorrect or empty",orgUser().equals(generalPage.getSupportEmailInput().getAttribute("value")));
        commonSteps.textInput(generalPage.getSupportEmailInput(),"a");
        generalPage.getSupportEmailInput().sendKeys(Keys.BACK_SPACE);
        commonSteps.click(generalPage.getSaveSupportEmailButton());
        commonSteps.refreshPage();
        commonSteps.assertTrue("Support email is not empty","".equals(generalPage.getSupportEmailInput().getAttribute("value")));
    }

}
