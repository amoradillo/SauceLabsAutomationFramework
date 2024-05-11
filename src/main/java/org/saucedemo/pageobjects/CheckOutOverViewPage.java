package org.saucedemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverViewPage extends Commons{

    private WebDriver driver;
    public CheckOutOverViewPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath="//div[@class='summary_total_label']")
    WebElement totalAmount;


    @FindBy(id="finish")
    WebElement finishButton;


    public String getTotalAmount()
    {
        return totalAmount.getText();
    }

    public CheckOutCompletePage clickFinishButton()
    {
        finishButton.click();
        return new CheckOutCompletePage(driver);
    }


}
