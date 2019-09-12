package com.humaneyescloud.tests;

import com.humaneyescloud.blocks.CommonThings;
import com.humaneyescloud.pagemapping.*;
import com.humaneyescloud.steps.*;
import com.humaneyescloud.utils.BasicBeforeAfter;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static com.humaneyescloud.utils.TestData.*;

public class TagsTest extends BasicBeforeAfter {
    SignInPage signInPage;
    DashboardPage dashboardPage;
    OrganizationSettings organizationSettings;
    SubOrganizationPage subOrganizationPage;
    GeneralPage generalPage;
    TagsPage tagsPage;
    CommonThings commonThings;
    CommonSteps commonSteps;


    @Before
    public void setupClass() throws InterruptedException {
        signInPage = new SignInPage(driver);
        dashboardPage = new DashboardPage(driver);
        organizationSettings = new OrganizationSettings(driver);
        subOrganizationPage = new SubOrganizationPage(driver);
        generalPage = new GeneralPage(driver);
        tagsPage = new TagsPage(driver);
        commonSteps = new CommonSteps(driver);
        commonThings = new CommonThings(driver);
        commonSteps.goToDashboardPage(signInPage);
        commonSteps.assertEquals(orgName(),dashboardPage.getOrgname());
        commonSteps.shouldNotSee(commonThings.getLoader());
        commonSteps.move(dashboardPage.getAvatarDropdown());
        commonSteps.click(dashboardPage.getOrganizationSettingsButton());
        commonSteps.shouldNotSee(commonThings.getLoader());
        commonSteps.click(organizationSettings.getTagsButton());
        commonSteps.shouldNotSee(commonThings.getLoader());
    }

  @Test
    @DisplayName("Add New Tag To The System")
    public void addNewTagToTheSystem001() throws InterruptedException{
        commonSteps.click(tagsPage.getNewTagButton());
        String tempNewTagName = randomValueMethod();
        commonSteps.textInput(tagsPage.getNewTagNameInput(),tempNewTagName);
        commonSteps.click(tagsPage.getApplyNewNameCreationButton());
        commonSteps.textInput(tagsPage.getSearchTagField(),tempNewTagName);
        commonSteps.sleepThread(5000);
        commonSteps.assertEquals(tempNewTagName,tagsPage.getFirstTagRecord());
    }

    @Test
    @DisplayName("Cancel creation new tag")
    public void cancelCreationNewTag002() throws InterruptedException{
        commonSteps.click(tagsPage.getNewTagButton());
        String tempNewTagName = randomValueMethod();
        commonSteps.textInput(tagsPage.getNewTagNameInput(),tempNewTagName);
        commonSteps.click(tagsPage.getCancelNewNameCreationButton());
        commonSteps.textInput(tagsPage.getSearchTagField(),tempNewTagName);
        commonSteps.sleepThread(5000);
        commonSteps.assertEquals(noRecordsFoundMethod(),tagsPage.getNoSearchResultsOnTagsPage());
    }

    @Test
    @DisplayName("Check that tag names is uniqueness")
    public void tagNameIsUniqueness003() throws InterruptedException{
        commonSteps.click(tagsPage.getNewTagButton());
        String tempNewTagName = randomValueMethod();
        commonSteps.textInput(tagsPage.getNewTagNameInput(),tempNewTagName);
        commonSteps.click(tagsPage.getApplyNewNameCreationButton());
        commonSteps.sleepThread(5000);
        commonSteps.click(tagsPage.getNewTagButton());
        commonSteps.textInput(tagsPage.getNewTagNameInput(),tempNewTagName);
        commonSteps.click(tagsPage.getApplyNewNameCreationButton());
        commonSteps.assertEquals(validationMessageTagNameIsAlreayExist(),tagsPage.getTagNameValidationMessage());
    }

    @Test
    @DisplayName("Admin Can Edit The Tag")
    public void adminCanEditTheTag004() throws InterruptedException{
        commonSteps.move(tagsPage.getFirstTagRecord());
        commonSteps.click(tagsPage.getEditTagButton());
        String tempNewTagName = randomValueMethod();
        commonSteps.textInput(tagsPage.getNewTagNameInput(),tempNewTagName);
        commonSteps.click(tagsPage.getUpdateTagNameButton());
        commonSteps.textInput(tagsPage.getSearchTagField(),tempNewTagName);
        commonSteps.sleepThread(5000);
        commonSteps.assertEquals(tempNewTagName,tagsPage.getFirstTagRecord());
    }

    @Test
    @DisplayName("Update Button Is Inactive While Admin Does Not Change Tag Name")
    public void updateButtonIsInactive005() throws InterruptedException{
        commonSteps.move(tagsPage.getFirstTagRecord());
        commonSteps.click(tagsPage.getEditTagButton());
        commonSteps.shouldSee(tagsPage.getInactiveUpdateTagNameButton());
    }

    @Test
    @DisplayName("Check That Admin Can Delete Tag")
    public void adminCanDeleteTag006() throws InterruptedException{
        String tempFirstTagName = commonSteps.getText(tagsPage.getFirstTagRecord());
        commonSteps.move(tagsPage.getFirstTagRecord());
        commonSteps.click(tagsPage.getDeleteTagButton());
        commonSteps.click(commonThings.getModalConfirmButton());
        commonSteps.assertFalse("The tag was not remove",tempFirstTagName.equals(tagsPage.getFirstTagRecord()));
    }

    @Test
    @DisplayName("Check That Admin Can Cancel Delete Tag operation")
    public void cancelDeleteTag007() throws InterruptedException{
        String tempFirstTagName = commonSteps.getText(tagsPage.getFirstTagRecord());
        commonSteps.move(tagsPage.getFirstTagRecord());
        commonSteps.click(tagsPage.getDeleteTagButton());
        commonSteps.click(commonThings.getModalCancelButton());
        commonSteps.assertEquals(tempFirstTagName,tagsPage.getFirstTagRecord());
    }

    @Test
    @DisplayName("Check That Admin Can Select One Tag")
    public void adminCanSelectOneTag008() throws InterruptedException{
        commonSteps.move(tagsPage.getFirstTagRecord());
        commonSteps.click(tagsPage.getSelectFirstCheckbox());
        commonSteps.shouldSee(tagsPage.getCounterOfSelectedTags());
    }

    @Test
    @DisplayName("Check That Admin Can Select All Tags")
    public void adminCanSelectAllTags009() throws InterruptedException{
        commonSteps.move(tagsPage.getSelectAllCheckbox());
        commonSteps.shouldSee(tagsPage.getCounterOfSelectedTags());
    }

    @Test
    @DisplayName("Check That Admin Can Cancel Delete All Tags")
    public void adminCanCancelDeleteAllTags010() throws InterruptedException{
        String tempFirstTagRecord = commonSteps.getText(tagsPage.getFirstTagRecord());
        commonSteps.move(tagsPage.getSelectAllCheckbox());
        commonSteps.click(commonThings.getThreeDotsButton());
        commonSteps.click(commonThings.getDeleteSelectedElementsButton());
        commonSteps.click(commonThings.getModalCancelButton());
        System.out.println("tempFirstTagRecord" +tempFirstTagRecord +"tagsPage.getFirstTagRecord()" + tagsPage.getFirstTagRecord());
        commonSteps.assertEquals(tempFirstTagRecord,tagsPage.getFirstTagRecord());
    }

    @Test
    @DisplayName("Check That Admin Can Delete Several Tags")
    public void adminCanDeleteSeveralTags011() throws InterruptedException{
        String tempFirstTagRecord1 = commonSteps.getText(tagsPage.getFirstTagRecord());
        commonSteps.move(tagsPage.getSelectFirstCheckbox());
        commonSteps.move(tagsPage.getSelectSecondCheckbox());
        commonSteps.click(commonThings.getThreeDotsButton());
        commonSteps.click(commonThings.getDeleteSelectedElementsButton());
        commonSteps.click(commonThings.getModalConfirmButton());
        commonSteps.assertNotEquals(tempFirstTagRecord1,tagsPage.getFirstTagRecord());
    }

    @Test
    @DisplayName("Admin can cancel search by Clear filters button")
    public void adminCanCancelSearchByClearFiltersButton012() throws InterruptedException {
        String tempFirstTagName = commonSteps.getText(tagsPage.getFirstTagRecord());
        commonSteps.textInput(tagsPage.getSearchTagField(),randomValueMethod());
        commonSteps.shouldNotSee(commonThings.getLoader());
        commonSteps.click(tagsPage.getClearFiltersButton());
        commonSteps.shouldNotSee(commonThings.getLoader());
        commonSteps.assertEquals(tempFirstTagName,tagsPage.getFirstTagRecord());
    }

    @Test
    @DisplayName("Admin can cancel search by Cross button")
    public void adminCanCancelSearchByCrossButton013() throws InterruptedException {
        String tempFirstTagName = commonSteps.getText(tagsPage.getFirstTagRecord());
        commonSteps.textInput(tagsPage.getSearchTagField(),randomValueMethod());
        commonSteps.shouldNotSee(commonThings.getLoader());
        commonSteps.click(tagsPage.getClearInputButton());
        commonSteps.shouldNotSee(commonThings.getLoader());
        commonSteps.assertEquals(tempFirstTagName,tagsPage.getFirstTagRecord());
    }
}
