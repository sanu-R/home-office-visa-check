package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class ResultPage extends Utility {
    /**
     * resultMessage locator and create methods 'String getResultMessage()' and 'void confirmResultMessage(String expectedMessage)'
     * (Note Use Assert.assertTrue)
     */
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='You will not need a visa to come to the UK']")
    WebElement resultMessage;
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='You need a visa to work in health and care']")
    WebElement answerMessage;
    @CacheLookup
    @FindBy(xpath = "(//h2[contains(text(),'You’ll need a visa to join your family or partner ')])[1]")
    WebElement replyMessage;

    public String getResultMessage() {
        return getTextFromElement(resultMessage);
    }

    public void getResultText(String expectedMessage) {
        Reporter.log("The message is :" + expectedMessage.toString());
        Assert.assertEquals(answerMessage.getText(), expectedMessage, "Text not found");
    }
public String getTextFromInformation(){
        return getTextFromElement(replyMessage);
}

}
