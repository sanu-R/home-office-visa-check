package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class VisaConfirmationTest extends BaseTest {
    DurationOfStayPage durationOfStayPage;
    FamilyImmigrationStatusPage familyImmigrationStatusPage;
    ResultPage resultPage;
    SelectNationalityPage selectNationalityPage;
    StartPage startPage;
    WorkTypePage workTypePage;
    ReasonForTravelPage reasonForTravelPage;


    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        durationOfStayPage = new DurationOfStayPage();
        familyImmigrationStatusPage = new FamilyImmigrationStatusPage();
        resultPage = new ResultPage();
        startPage = new StartPage();
        selectNationalityPage = new SelectNationalityPage();
        workTypePage = new WorkTypePage();
        reasonForTravelPage = new ReasonForTravelPage();

    }

    @Test(groups = {"smoke","sanity","regression"})
    public void anAustralianComingToUKForTourism() {
        // Click on start button
        startPage.clickStartNow();
        //	Select a Nationality 'Australia'
        selectNationalityPage.selectNationality("Australia");
        //	Click on Continue button
        selectNationalityPage.clickNextStepButton();
        //	Select reason 'Tourism'
        reasonForTravelPage.selectReasonForVisit("Tourism or visiting family and friends");
        //	Click on Continue button
        reasonForTravelPage.clickForNextPage();
        //	verify result 'You will not need a visa to come to the UK'
        Assert.assertTrue(resultPage.getResultMessage().equalsIgnoreCase("You will not need a visa to come to the UK"));


    }

    @Test(groups = {"smoke","sanity"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths() throws InterruptedException {
        //Click on start button
        startPage.clickStartNow();
        Thread.sleep(3000);
        //	Select a Nationality 'Chile'
        selectNationalityPage.selectNationality("Chile");
        Thread.sleep(3000);
        //	Click on Continue button
        selectNationalityPage.clickNextStepButton();
        Thread.sleep(4000);
        //	Select reason 'Work, academic visit or business'
        Thread.sleep(4000);
        reasonForTravelPage.selectReasonForVisit("Work, academic visit or business");
        //	Click on Continue button
        reasonForTravelPage.clickForNextPage();
        Thread.sleep(5000);
        //	Select intention to stay for 'longer than 6 months'
        durationOfStayPage.selectLengthOfStay("1");
        Thread.sleep(5000);
        //	Click on Continue button
        durationOfStayPage.clickOnContinue();
        //	Select have planning to work for 'Health and care professional'
        workTypePage.selectJobType("Health and care professional");
        //	Click on Continue button
        workTypePage.clickOnNextContinueButton();
        //	verify result 'You need a visa to work in health and care'
        resultPage.getResultText("You need a visa to work in health and care");

    }

    @Test(groups = {"smoke","sanity","regression"})
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card() throws InterruptedException {
        //Click on start button
        startPage.clickStartNow();
        Thread.sleep(5000);
        //	Select a Nationality 'Colombia'
        Thread.sleep(5000);
        selectNationalityPage.selectNationality("Colombia");
        //	Click on Continue button
        Thread.sleep(5000);
        selectNationalityPage.clickNextStepButton();
        //	Select reason 'Join partner or family for a long stay'
        Thread.sleep(5000);
        reasonForTravelPage.selectReasonForVisit("Join partner or family for a long stay");
        //	Click on Continue button
        Thread.sleep(5000);
        reasonForTravelPage.clickToGoToNextPage();
        Thread.sleep(5000);
        //	Select state My partner of family member have uk immigration status 'yes'
        Thread.sleep(5000);
        familyImmigrationStatusPage.selectImmigrationStatus("Yes");
        //	Click on Continue button
        Thread.sleep(5000);
        familyImmigrationStatusPage.clickNextStep();
        //	verify result 'You’ll need a visa to join your family or partner in the UK'
        resultPage.getTextFromInformation();
        Assert.assertTrue(resultPage.getTextFromInformation().equalsIgnoreCase("You’ll need a visa to join your family or partner in the UK"));
    }
}
