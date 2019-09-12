package com.humaneyescloud.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

public class TestData {
    public static String baseUrl() {
        String url = "https://staging.rosalyn.ai";
        return url;
    }

    public static String orgName() {
        String orgName1 = "Smoke19";
        return orgName1;
    }

    public static String orgUser() {
        String userEmail = "smoke19@sharklasers.com";
        return userEmail;
    }

    public static String userPass() {
        String userPassword = "123456";
        return userPassword;
    }

    public static String organizationSettingsTitle() {
        String orgSettingsTitle = "Organization Settings";
        return orgSettingsTitle;
    }

    public static String changePasswordTitle() {
        String changePassTitle = "Change Password";
        return changePassTitle;
    }

    public static String changePassSuccessMessage() {
        String changePassSuccessMessageVal = "Change password link sent on your email";
        return changePassSuccessMessageVal;
    }

    public static String trialCounter() {
        String trialCounterVal = "Trial days: 21";
        return trialCounterVal;
    }

    public static String externalFilePath() {
        String externalFilePathVal = "E:\\SomeDir\\notes3.txt";
        return externalFilePathVal;
    }

    public static String sharklasersCom() {
        String sharklasersComVal = "@sharklasers.com";
        return sharklasersComVal;
    }

    public static String itemsPageTitleName() {
        String itemsPageTitleVal = "Items";
        return itemsPageTitleVal;
    }

    public static String testsPageTitleName() {
        String testsPageTitleVal = "Active";
        return testsPageTitleVal;
    }

    public static String scoringPageTitleName() {
        String scoringPageTitleVal = "Scoring";
        return scoringPageTitleVal;
    }

    public static String proctoringPageTitleName() {
        String proctoringPageTitleVal = "Proctoring";
        return proctoringPageTitleVal;
    }

    public static String resultsPageTitleName() {
        String resultsPageTitleVal = "Results";
        return resultsPageTitleVal;
    }

    public static String examineesPageTitleName() {
        String examineesPageTitleVal = "Examinees";
        return examineesPageTitleVal;
    }

    public static String exportButtonName() {
        String exportButtonNameVal = "Export";
        return exportButtonNameVal;
    }

    public static String randomValueMethod() {
        String randomValue = RandomStringUtils.randomAlphabetic(10) + UUID.randomUUID().toString().replace("-", "").substring(0, 7);
        return randomValue;
    }

    public static String thirtyThreeSymbolsMethod() {
        String thirtyThreeSymbol = "Thisis a string with thirty-three";
        return thirtyThreeSymbol;
    }

    public static String oneHundredTwentyFiveSymbolsMethod() {
        String oneHundredTwentyFiveSymbol = "Imogen Clare Holst CBE (born Imogen Clare von Holst; 12 April 1907 – 9 March 1984) was an English composer, arranger, conductor, teacher and festival administrator. The only child of the composer Gustav Holst, she is particularly known for her educational work at Dartington Hall in the 1940s, and for her 20 years as joint artistic director of the Aldeburgh Festival. In addition to composing music, she wrote composer biographies, much educational material, and several books on the life and works of her father. From a young age, Imogen Holst showed precocious talent in composing and performance. After attending Eothen School and St Paul's Girls' School, she entered the Royal College of Music, where she developed her skills as a conductor and won several prizes for composing. Unable for health reasons to follow her initial ambitions to be a pianist or a dancer, Holst spent most of the 1930s teaching, and as a full-time organiser for the English Folk Dance and Song Society. These duties reduced her compositional!!";
        return oneHundredTwentyFiveSymbol;
    }

    public static String oneHundredTwentyFourSymbolsMethod() {
        String oneHundredTwentyFourSymbol = "Imogen Clare Holst CBE (born Imogen Clare von Holst; 12 April 1907 – 9 March 1984) was an English composer, arranger, conductor, teacher and festival administrator. The only child of the composer Gustav Holst, she is particularly known for her educational work at Dartington Hall in the 1940s, and for her 20 years as joint artistic director of the Aldeburgh Festival. In addition to composing music, she wrote composer biographies, much educational material, and several books on the life and works of her father. From a young age, Imogen Holst showed precocious talent in composing and performance. After attending Eothen School and St Paul's Girls' School, she entered the Royal College of Music, where she developed her skills as a conductor and won several prizes for composing. Unable for health reasons to follow her initial ambitions to be a pianist or a dancer, Holst spent most of the 1930s teaching, and as a full-time organiser for the English Folk Dance and Song Society. These duties reduced her compositional!";
        return oneHundredTwentyFourSymbol;
    }


    public static String validationMessageSubOrgNameIsRequired() {
        String validationMessageSubOrgNameIsRequiredVal = "Sub organization name field is required.";
        return validationMessageSubOrgNameIsRequiredVal;
    }

    public static String validationMessageSubOrgNameIsLong() {
        String validationMessageSubOrgNameIsLongVal = "Sub organization name should be shorter than 32 characters.";
        return validationMessageSubOrgNameIsLongVal;
    }

    public static String validationMessageSubOrgDescriptionIsLong() {
        String validationMessageSubOrgDescriptionIsLongVal = "Sub organization description should be shorter than 1024 characters.";
        return validationMessageSubOrgDescriptionIsLongVal;
    }

    public static String validationMessageTagNameIsAlreayExist() {
        String validationMessageTagNameIsAlreayExistVal = "Tag name is already exist.";
        return validationMessageTagNameIsAlreayExistVal;
    }

    public static String noRecordsFoundMethod() {
        String noRecordsFoundVal = "No records found.";
        return noRecordsFoundVal;
    }

    public static String viewSubOrgMethod() {
        String viewSubOrgVal = "View Sub Organization";
        return viewSubOrgVal;
    }

    public static String editRubricTitle() {
        String editRubricTitleVal = "Edit Rubric";
        return editRubricTitleVal;
    }

    public static String youCannotDeleteRubricThatIsActivelyAssigned() {
        String youCannotDeleteRubricThatIsActivelyAssignedVal = "Oops! You cannot delete a rubric that is actively assigned.";
        return youCannotDeleteRubricThatIsActivelyAssignedVal;
    }

    public static String catNeedsMaximumRawScore() {
        String catNeedsMaximumRawScoreVal = "This Custom Scoring Scale needs a maximum raw score.";
        return catNeedsMaximumRawScoreVal;
    }

}
