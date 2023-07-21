package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class WorkTypePage extends Utility {
    @CacheLookup
    @FindBy(css = "#response-0")
    WebElement selectJobTypeList;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement nextContinue;

  public  void selectJobType(String job){
      clickOnElementFromObject(selectJobTypeList,job);
  }

public void clickOnNextContinueButton(){
      clickOnElement(nextContinue);
}



}
