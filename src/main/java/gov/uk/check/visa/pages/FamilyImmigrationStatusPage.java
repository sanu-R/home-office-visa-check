package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class FamilyImmigrationStatusPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//input[@id='response-0']")
    WebElement yes1;

    @CacheLookup
    @FindBy(css = "#response-1")
    WebElement no;
    @CacheLookup
    @FindBy(css = "button[class='gem-c-button govuk-button gem-c-button--bottom-margin']")
    WebElement clickButton;

    public void selectImmigrationStatus(String status) {
        int immStatus = 1;
        switch (immStatus) {
            case 1:
                clickOnElementFromObject(yes1, status);
                break;
            case 2:
                break;
        }
        clickOnElementFromObject(yes1, status);
    }

    public void clickNextStep() {
        clickOnElement(clickButton);
    }
}
