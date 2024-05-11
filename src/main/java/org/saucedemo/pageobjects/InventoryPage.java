package org.saucedemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage extends Commons {

    private WebDriver driver;

    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory ']")
    List<WebElement> allCartButton;

    public InventoryPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    public CartPage clickAllProducts()
    {
        for (WebElement listItem: allCartButton)
        {
            listItem.click();
        }
        return new CartPage(driver);
    }




}
