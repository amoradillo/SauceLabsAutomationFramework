package org.saucedemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformation extends Commons {

    private WebDriver driver;
    public CheckoutInformation(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//input[@id='continue']")
    WebElement continueButton;

    @FindBy(xpath = "//input[@id='first-name']")
    WebElement webEleFirstname;

    @FindBy(xpath = "//input[@id='last-name']")
    WebElement webEleLastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement webElePostalCode;


    public void InputInfoFields(String firstname, String lastName, String postalCode)
    {
        webEleFirstname.sendKeys(firstname);
        webEleLastName.sendKeys(lastName);
        webElePostalCode.sendKeys(postalCode);
    }

    public CheckOutOverViewPage ClickContinueButton()
    {
        continueButton.click();
        return new CheckOutOverViewPage(driver);
    }


}
