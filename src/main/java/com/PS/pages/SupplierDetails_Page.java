package com.PS.pages;

import com.PS.util.Utility;
import com.PS.util.dataGenerator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.PS.base.Base;

public class SupplierDetails_Page extends Base {
    dataGenerator produce = new dataGenerator();

    @FindBy(xpath = "//a[contains(@href,'admin/suppliers')]")
    public WebElement SupplierMenuBtn;

    @FindBy(xpath = "//button[contains(text(),'New Supplier')]")
    public WebElement newSupplier;

    @FindBy(xpath = "//input[@placeholder='Enter Supplier Name']")
    public WebElement supplierName;

    @FindBy(xpath = "//div[contains(text(),'Select Payment')]")
    public WebElement selectPaymentTerm;

    @FindBy(xpath = "//li[@name='Showroom']")
    public WebElement supplierTypeShowroom;

    @FindBy(xpath = "//div[contains(text(),'Supplier Type')]")
    public WebElement supplierType;

    @FindBy(xpath = "//input[@placeholder='Enter Website Url']")
    public WebElement supplierWebsite;

    @FindBy(xpath = "//div[contains(text(),'Supplier Source')]")
    public WebElement supplierSource;

    @FindBy(xpath = "//li[@name='Conference']")
    public WebElement supplierSourceName;

    @FindBy(xpath = "//input[@placeholder='Relationship Since Date']")
    public WebElement relationshipDate;

    @FindBy(xpath = "//td[@title='January 28, 2020']")
    public WebElement relationshipDate1;

    @FindBy(xpath = "//div[contains(text(),'Select Industry')]")
    public WebElement industry;

    @FindBy(xpath = "//li[@name='Media']")
    public WebElement mediaIndustry;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitSupplier;

    public SupplierDetails_Page() {
        PageFactory.initElements(driver, this);
    }

    public void createSupplier() throws Exception {
        String supplierNameTest = produce.generateName();
        Utility.click(SupplierMenuBtn);
        Utility.click(newSupplier);
        Thread.sleep(3000);
        Utility.enterText(supplierName, supplierNameTest);
        Utility.click(supplierType);
        Utility.click(supplierTypeShowroom);
        Utility.enterText(supplierWebsite, "https://www.google.com/");
      /*  Utility.click(supplierSource);
        Utility.click(supplierSourceName);*/
        Utility.click(relationshipDate);
        Utility.click(relationshipDate1);
      /*  Utility.click(industry);
        Utility.click(mediaIndustry);*/
        Utility.click(submitSupplier);
    }


}
