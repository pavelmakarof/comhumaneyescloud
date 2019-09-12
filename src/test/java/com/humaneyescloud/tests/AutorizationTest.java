package com.humaneyescloud.tests;

import com.humaneyescloud.pagemapping.*;
import com.humaneyescloud.steps.*;
import com.humaneyescloud.utils.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static com.humaneyescloud.utils.TestData.*;

/**
 * Created by makarof on 18.04.2018.
 */
public class AutorizationTest extends BasicBeforeAfter {
    SignInPage signInPage;
    SignUpPage signUpPage;
    DashboardPage dashboardPage;
    ItemsPage itemsPage;
    TestsPage testsPage;
    ScoringPage scoringPage;
    ProctoringPage proctoringPage;
    ResultsPage resultsPage;
    ExamineesPage examineesPage;
    OrganizationSettings organizationSettings;
    ChangePassword changePassword;
    CommonSteps commonSteps;

    @Before
    public void setupClass() {
        signInPage = new SignInPage(driver);
        signUpPage = new SignUpPage(driver);
        dashboardPage = new DashboardPage(driver);
        itemsPage = new ItemsPage(driver);
        testsPage = new TestsPage(driver);
        scoringPage = new ScoringPage(driver);
        proctoringPage = new ProctoringPage(driver);
        resultsPage = new ResultsPage(driver);
        examineesPage = new ExamineesPage(driver);
        organizationSettings = new OrganizationSettings(driver);
        changePassword = new ChangePassword(driver);
        commonSteps = new CommonSteps(driver);
        commonSteps.goToDashboardPage(signInPage);
        commonSteps.assertEquals(orgName(),dashboardPage.getOrgname());
    }

    @Test
    @DisplayName("Change admin location")
    public void testChangeLocation001() throws InterruptedException {
        commonSteps.move(dashboardPage.getOrgname());
        commonSteps.click(dashboardPage.getSubOrg());
        commonSteps.assertNotEquals(orgName(),dashboardPage.getOrgname());
    }

    @Test
    @DisplayName("Open \"organization settings\"")
    public void testOrganizationSettings002() throws InterruptedException {
        commonSteps.move(dashboardPage.getAvatarDropdown());
        commonSteps.click(dashboardPage.getOrganizationSettingsButton());
        commonSteps.assertEquals(organizationSettingsTitle(),organizationSettings.getOrganizationSettingsTitle());
    }

    @Test
    @DisplayName("Open \"Change password\" settings")
    public void testChangePass003() throws InterruptedException {
        commonSteps.move(dashboardPage.getAvatarDropdown());
        commonSteps.click(dashboardPage.getChangePassword());
        commonSteps.assertEquals(changePasswordTitle(),changePassword.getTitleChangePassword());
        commonSteps.textInput(changePassword.getEmailforchangepass(),orgUser());
        commonSteps.click(changePassword.getSubmitButton());
        commonSteps.assertEquals(changePassSuccessMessage(), changePassword.getSuccessPage());
        commonSteps.click(changePassword.getOkButton());
        commonSteps.assertEquals(orgName(),dashboardPage.getOrgname());
    }

    @Test
    @DisplayName("Check success logout")
    public void testLogoutConfirm004() throws InterruptedException {
        commonSteps.move(dashboardPage.getAvatarDropdown());
        commonSteps.click(dashboardPage.getLogout());
        commonSteps.click(dashboardPage.getConfirmLogout());
        commonSteps.shouldSee(signInPage.getGetStartedButton());
    }

    @Test
    @DisplayName("Check cancel logout")
    public void testLogoutCancel005() throws InterruptedException {
        commonSteps.move(dashboardPage.getAvatarDropdown());
        commonSteps.click(dashboardPage.getLogout());
        commonSteps.click(dashboardPage.getCancelLogout());
        commonSteps.assertEquals(orgName(),dashboardPage.getOrgname());
    }

    @Test
    @DisplayName("Check that by default menu is hiddden")
    public void testByDewaultMenuIsHidden007()throws InterruptedException{
        commonSteps.shouldNotSee(dashboardPage.getDashboardMenuItem());
    }

    @Test
    @DisplayName("Check Examinees menu item and Dashboard menu item")
    public void testDashboardMenuItem008()throws InterruptedException{
        commonSteps.move(dashboardPage.getHiddenMenu());
        commonSteps.click(dashboardPage.getExamineesMenuItem());
        commonSteps.assertEquals(examineesPageTitleName(),examineesPage.getExamineesPageTitle());
        commonSteps.move(dashboardPage.getHiddenMenu());
        commonSteps.click(dashboardPage.getDashboardMenuItem());
        commonSteps.assertEquals(exportButtonName(),dashboardPage.getExportButton());
    }

    @Test
    @DisplayName("Check Items menu item")
    public void testItemsMenuItem009()throws InterruptedException{
        commonSteps.move(dashboardPage.getHiddenMenu());
        commonSteps.click(dashboardPage.getItemsMenuItem());
        commonSteps.assertEquals(itemsPageTitleName(), itemsPage.getItemsPageTitle());
    }
    @Test
    @DisplayName("Check Tests menu item")
    public void testTestsMenuItem010()throws InterruptedException{
        commonSteps.move(dashboardPage.getHiddenMenu());
        commonSteps.click(dashboardPage.getTestsMenuItem());
        commonSteps.assertEquals(testsPageTitleName(),testsPage.getTestsPageTitle());
    }

    @Test
    @DisplayName("Check Scoring menu item")
    public void testScoringMenuItem011()throws InterruptedException{
        commonSteps.move(dashboardPage.getHiddenMenu());
        commonSteps.click(dashboardPage.getScoringMenuItem());
        commonSteps.assertEquals(scoringPageTitleName(), scoringPage.getScoringPageTitle());
    }

    @Test
    @DisplayName("Check Proctoring menu item")
    public void testProctoringMenuItem012()throws InterruptedException{
        commonSteps.move(dashboardPage.getHiddenMenu());
        commonSteps.click(dashboardPage.getProctoringMenuItem());
        commonSteps.assertEquals(proctoringPageTitleName(), proctoringPage.getProctoringPageTitle());
    }

    @Test
    @DisplayName("Check Results menu item")
    public void testResultsMenuItem013()throws InterruptedException{
        commonSteps.move(dashboardPage.getHiddenMenu());
        commonSteps.click(dashboardPage.getResultsMenuItem());
        commonSteps.assertEquals(resultsPageTitleName(),resultsPage.getResultsPageTitle());
    }
}
