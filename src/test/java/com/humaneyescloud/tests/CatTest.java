package com.humaneyescloud.tests;

import com.humaneyescloud.blocks.CommonThings;
import com.humaneyescloud.pagemapping.*;
import com.humaneyescloud.steps.CommonSteps;
import com.humaneyescloud.utils.BasicBeforeAfter;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static com.humaneyescloud.utils.TestData.*;

public class CatTest extends BasicBeforeAfter {
    SignInPage signInPage;
    DashboardPage dashboardPage;
    OrganizationSettings organizationSettings;
    SubOrganizationPage subOrganizationPage;
    GeneralPage generalPage;
    CatPage catPage;
    CommonThings commonThings;
    CommonSteps commonSteps;

    @Before
    public void setupClass() throws InterruptedException {
        signInPage = new SignInPage(driver);
        dashboardPage = new DashboardPage(driver);
        organizationSettings = new OrganizationSettings(driver);
        subOrganizationPage = new SubOrganizationPage(driver);
        generalPage = new GeneralPage(driver);
        catPage = new CatPage(driver);
        commonSteps = new CommonSteps(driver);
        commonThings = new CommonThings(driver);
        commonSteps.goToDashboardPage(signInPage);
        commonSteps.shouldNotSee(commonThings.getLoader());
        commonSteps.assertEquals(orgName(), dashboardPage.getOrgname());
        commonSteps.move(dashboardPage.getAvatarDropdown());
        commonSteps.click(dashboardPage.getOrganizationSettingsButton());
        commonSteps.shouldNotSee(commonThings.getLoader());
        commonSteps.click(organizationSettings.getCatButton());
        Thread.sleep(15000);
        commonSteps.shouldNotSee(commonThings.getLoader());
    }


    @Test
    @DisplayName("Add New CAT To The System")
    public void addNewCatToTheSystem001() throws InterruptedException {
        commonSteps.click(catPage.getNewCatButton());
        String tempCatName = "CAT Name " + randomValueMethod();
        commonSteps.textInput(catPage.getNewCatName(), tempCatName);
        String tempCatDescript = oneHundredTwentyFourSymbolsMethod();
        commonSteps.textInput(catPage.getNewCatDescription(), tempCatDescript);
        commonSteps.assertFalse("The button is enabled", commonSteps.isButtonEnabled(catPage.getNewCatAddTierButton()));
        int tempMaxRawScore = (int) (Math.random() * 10) + 200;
        commonSteps.textInput(catPage.getNewCatMaximumRawScore(), String.valueOf(tempMaxRawScore));
        commonSteps.click(catPage.getNewCatAddTierButton());
        String tempCatTierName = "CAT Tier Name - First Tier - Best" + randomValueMethod();
        commonSteps.textInput(commonSteps.getElememtFromArray(catPage.getNewCatTierName(), 0), tempCatTierName);
        commonSteps.textInput(commonSteps.getElememtFromArray(catPage.getNewCatTierStaringRawScore(), 0), String.valueOf(tempMaxRawScore - 50));
        commonSteps.assertTrue("Ending RAW score in first tier is not correct", commonSteps.getAttributeValue(commonSteps.getElememtFromArray(catPage.getNewCatTierEndingRawScore(), 0), "valueAsNumber").equals(String.valueOf(tempMaxRawScore)));
        commonSteps.textInput(commonSteps.getElememtFromArray(catPage.getNewCatTierDescription(), 0), "Description of " + tempCatTierName);
        commonSteps.click(catPage.getNewCatAddTierButton());
        String tempCatTierName2 = "CAT Tier Name - Second Tier - Good" + randomValueMethod();
        commonSteps.textInput(commonSteps.getElememtFromArray(catPage.getNewCatTierName(), 1), tempCatTierName2);
        commonSteps.textInput(commonSteps.getElememtFromArray(catPage.getNewCatTierStaringRawScore(), 1), String.valueOf(tempMaxRawScore - 100));
        commonSteps.assertTrue("Ending RAW score in first tier is not correct", commonSteps.getAttributeValue(commonSteps.getElememtFromArray(catPage.getNewCatTierEndingRawScore(), 1), "valueAsNumber").equals(String.valueOf(tempMaxRawScore - 51)));
        commonSteps.textInput(commonSteps.getElememtFromArray(catPage.getNewCatTierDescription(), 1), "Description of " + tempCatTierName2);
        commonSteps.click(catPage.getNewCatAddTierButton());
        String tempCatTierName3 = "CAT Tier Name - Third Tier - Middle" + randomValueMethod();
        commonSteps.textInput(commonSteps.getElememtFromArray(catPage.getNewCatTierName(), 2), tempCatTierName3);
        commonSteps.textInput(commonSteps.getElememtFromArray(catPage.getNewCatTierStaringRawScore(), 2), String.valueOf(tempMaxRawScore - 150));
        commonSteps.assertTrue("Ending RAW score in first tier is not correct", commonSteps.getAttributeValue(commonSteps.getElememtFromArray(catPage.getNewCatTierEndingRawScore(), 2), "valueAsNumber").equals(String.valueOf(tempMaxRawScore - 101)));
        commonSteps.textInput(commonSteps.getElememtFromArray(catPage.getNewCatTierDescription(), 2), "Description of " + tempCatTierName3);
        commonSteps.click(catPage.getNewCatAddTierButton());
        String tempCatTierName4 = "CAT Tier Name - Four Tier - Bad" + randomValueMethod();
        commonSteps.textInput(commonSteps.getElememtFromArray(catPage.getNewCatTierName(), 3), tempCatTierName4);
        commonSteps.textInput(commonSteps.getElememtFromArray(catPage.getNewCatTierStaringRawScore(), 3), "2");
        commonSteps.assertTrue("Ending RAW score in first tier is not correct", commonSteps.getAttributeValue(commonSteps.getElememtFromArray(catPage.getNewCatTierEndingRawScore(), 3), "valueAsNumber").equals(String.valueOf(tempMaxRawScore - 151)));
        commonSteps.textInput(commonSteps.getElememtFromArray(catPage.getNewCatTierDescription(), 3), "Description of " + tempCatTierName4);
        commonSteps.click(catPage.getNewCatAddTierButton());
        commonSteps.click(catPage.getNewCatDeleteTierButton());
        commonSteps.textInput(commonSteps.getElememtFromArray(catPage.getNewCatTierStaringRawScore(), 3), "0");
        commonSteps.click(catPage.getNewCatAddTierButton());
        commonSteps.click(catPage.getOkButtonInModal());
        commonSteps.click(catPage.getBoldButtonInWysiwyg());
        commonSteps.textInput(catPage.getWysiwyg(),"Examinee name:" + "{{NAME}}\n" + "Score  tier:" + "{{SCORE_TIER}}\n" + "Score  tier description:" + "{{SCORE_TIER_DESCRIPTION}}\n" + "RAW_SCORE:" + "{{RAW_SCORE}}\n"+ "DATE:"+ "{{DATE}}");
        commonSteps.click(commonThings.getSaveButton());
        commonSteps.click(commonThings.getModalCrossButton());
        commonSteps.click(commonSteps.getElememtFromArray(catPage.getNewCatTierCheckboxSelectPassingTier(),2));
        commonSteps.click(commonThings.getSaveButton());
        commonSteps.shouldNotSee(commonThings.getLoader());
        commonSteps.assertEquals(tempCatName, catPage.getFirstCatRecord());
    }

    @Test
    @DisplayName("CAT name should be uniqueness")
    public void catNameShouldBeUniqueness() throws InterruptedException {
        String tempCatName = commonSteps.getText(catPage.getFirstCatRecord());
        commonSteps.click(catPage.getNewCatButton());
        commonSteps.textInput(catPage.getNewCatName(), tempCatName);
        commonSteps.textInput(catPage.getNewCatDescription(),oneHundredTwentyFiveSymbolsMethod());
        commonSteps.click(catPage.getNewCatMaximumRawScore());
        commonSteps.click(catPage.getWysiwyg());
        //commonSteps.assertEquals(,);

    }}
