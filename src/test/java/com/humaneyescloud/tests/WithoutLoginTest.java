package com.humaneyescloud.tests;

import com.humaneyescloud.utils.BasicBeforeAfter;
import com.humaneyescloud.pagemapping.*;
import com.humaneyescloud.steps.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

import static com.humaneyescloud.utils.TestData.*;

public class WithoutLoginTest extends BasicBeforeAfter {
    SignInPage signInPage;
    SignUpPage signUpPage;
    DashboardPage dashboardPage;
    OrganizationSettings organizationSettings;
    ChangePassword changePassword;
    CommonSteps commonSteps;

    @Before
    public void setupClass() {
        signInPage = new SignInPage(driver);
        signUpPage = new SignUpPage(driver);
        dashboardPage = new DashboardPage(driver);
        organizationSettings = new OrganizationSettings(driver);
        changePassword = new ChangePassword(driver);
        commonSteps = new CommonSteps(driver);
        commonSteps.getPage(baseUrl());
    }

    @Test
    @DisplayName("Check SignUp")
    public void testSignUp001() throws InterruptedException, IOException {
        commonSteps.click(signInPage.getGetStartedButton());
        String neworg = "nixauto" + UUID.randomUUID().toString().replace("-","").substring(0,7);
        commonSteps.textInput(signUpPage.getNeworgname(),neworg);
        commonSteps.textInput(signUpPage.getFirstName(),neworg);
        commonSteps.textInput(signUpPage.getLastName(),neworg);
        commonSteps.textInput(signUpPage.getOrgEmail(),neworg+sharklasersCom());
        commonSteps.textInput(signUpPage.getOrgPass(),userPass());
        commonSteps.click(signUpPage.getSignupButton());
        commonSteps.click(signUpPage.getContinueButton());
        commonSteps.textInput(signInPage.getUsername(),neworg+sharklasersCom());
        FileWriter writer = new FileWriter(externalFilePath(), true);
        writer.write("\n" + neworg + sharklasersCom());
        writer.close();
        commonSteps.textInput(signInPage.getUserpass(),userPass());
        commonSteps.click(signInPage.getSigninbutton());
        commonSteps.assertEquals(neworg,dashboardPage.getOrgname());
        commonSteps.assertEquals(trialCounter(),dashboardPage.getTrialCounter());
        commonSteps.shouldSee(dashboardPage.getEmailNotVerifiedBanner());
    }
}
