package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DurationOfStayPage extends Utility {
    @CacheLookup
    @FindBy(css = "#response-0")
    WebElement lessThanSixMonths;

    @CacheLookup
    @FindBy(css = "#response-1")
    WebElement moreThanSixMonths;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement nextStepButton;

    public void selectLengthOfStay(String moreOrLess) {
        int months = 2;
        switch (months) {
            case 1:
                clickOnElementFromObject(lessThanSixMonths, moreOrLess);
                break;
            case 2:
                clickOnElementFromObject(moreThanSixMonths, moreOrLess);
                break;


        }


    }

    public void clickOnContinue() {
        clickOnElement(nextStepButton);
    }
}


