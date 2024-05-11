package org.saucedemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends Commons {

    WebDriver driver;
    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement cartIcon;

    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkoutButton;


    public void ClickingCheckOutIcon() throws InterruptedException
    {
//        waitForWebElementToAppear(cartIcon);
        cartIcon.click();

    }

    public CheckoutInformation ClickingCheckOutButton() throws InterruptedException
    {
        waitForWebElementToAppear(checkoutButton);
        checkoutButton.click();
        return new CheckoutInformation(driver);

    }






}
