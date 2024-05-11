package org.saucedemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutCompletePage extends Commons{

    private WebDriver driver;
    public CheckOutCompletePage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }


    @FindBy(css = ".complete-header")
    WebElement completeOrder;


    public String getCompleteOrderText()
    {
        return completeOrder.getText();
    }

}
