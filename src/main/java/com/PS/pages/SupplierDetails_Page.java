package com.PS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.PS.base.Base;

public class SupplierDetails_Page extends Base{
	
	@FindBy(xpath = "//input[@placeholder='Email']")
	public WebElement email;

	@FindBy(xpath = "//div[@class='input-group']//input[@placeholder='Password']")
	public WebElement password;

	@FindBy(xpath = "//button[@class='btn btn-green btn-lg btn-block']")
	public WebElement LoginBtn;

	@FindBy(xpath = "//h2[@class='text-center signup-wizard-hding ng-scope']")
	public WebElement CompanySetupWizardText;

	@FindBy(xpath = "//button[@class='btn-sm btn btn-default pull-left']")
	public WebElement SkipBtn;

	@FindBy(xpath = "//body[@class='ng-scope']/div[@id='page-container']/nav[@id='page-leftbar']/div/ul[@id='sidebar']/li[5]/a[3]")
	public WebElement SupplierMenuBtn;
	
	@FindBy(xpath = "//a[@class='btn btn-green']")
	public WebElement NewSupplier;
	
	@FindBy(xpath = "//div[@ng-if='totalItems > 1']/p")
	public WebElement totalCustomerCount;
	
	@FindBy(xpath = "//input[@name='supplierName']")
	public WebElement SupplierName;
	
	@FindBy(xpath = "(//input[@class='select2-focusser select2-offscreen']/..//b)[1]")
	public WebElement Industry;
	@FindBy(xpath = "(//input[@class='select2-input'][@role='combobox'])[10]")
	public WebElement IndustrySearch;
	@FindBy(xpath = "(//div[@id='select2-drop']//ul[@class='select2-results']//li)[1]")
	public WebElement IndustrySearchClick;
	
	@FindBy(xpath = "(//input[@class='select2-focusser select2-offscreen']/..//b)[2]")
	public WebElement SupplierType;
	@FindBy(xpath = "(//input[@class='select2-input'][@role='combobox'])[10]")
	public WebElement SupplierTypeSearch;
	@FindBy(xpath = "(//div[@id='select2-drop']//ul[@class='select2-results']//li)[1]")
	public WebElement SupplierTypeSearchClick;
	
	@FindBy(xpath = "(//input[@class='select2-focusser select2-offscreen']/..//b)[3]")
	public WebElement SupplierSource;
	@FindBy(xpath = "(//input[@class='select2-input'][@role='combobox'])[10]")
	public WebElement SupplierSourceSearch;
	@FindBy(xpath = "(//div[@id='select2-drop']//ul[@class='select2-results']//li)[1]")
	public WebElement SupplierSourceSearchClick;
	
	@FindBy(xpath = "(//input[@class='select2-focusser select2-offscreen']/..//b)[3]")
	public WebElement PaymentTerm;
	@FindBy(xpath = "(//input[@class='select2-input'][@role='combobox'])[10]")
	public WebElement PaymentTermSearch;
	@FindBy(xpath = "(//div[@id='select2-drop']//ul[@class='select2-results']//li)[1]")
	public WebElement PaymentTermSearchClick;
	
	@FindBy(xpath = "//div[@class='col-sm-3']//input[@ng-model='popUp.supplier.webSite']")
	public WebElement companyWebsite;
	
	@FindBy(xpath = "//input[@name='billingStreetl']")
	public WebElement StreetAddress;
	
	@FindBy(xpath = "//input[@name='billingCityName']")
	public WebElement city;
	
	@FindBy(xpath = "//input[@name='billingStateId']")
	public WebElement state;
	@FindBy(xpath = "(//a[@class='select2-choice'])[4]")
	public WebElement stateName;
	@FindBy(xpath = "(//input[@class='select2-input'][@role='combobox'])[11]")
	public WebElement stateNameSearch;
	@FindBy(xpath = "//div[@class='select2-result-label']")
	public WebElement stateNameSearchClick;
	
	@FindBy(xpath = "//input[@name='billingPinCode']")
	public WebElement zipcode;
	
	@FindBy(xpath = "(//div[@class='icheckbox_flat'])[3]")
	public WebElement sameAsBillingAddress;
	
	@FindBy(xpath = "//a[@class='ng-binding'][contains(text(),'Contact')]")
	public WebElement contactsubmenu;
	
	@FindBy(xpath = "(//input[@class='select2-focusser select2-offscreen']/..//b)[9]")
	public WebElement title;
	@FindBy(xpath = "(//input[@class='select2-input'][@role='combobox'])[10]")
	public WebElement titleSearch;
	@FindBy(xpath = "(//div[@id='select2-drop']//ul[@class='select2-results']//li)[1]")
	public WebElement titleSearchClick;
	
	@FindBy(xpath = "//input[@name='firstName']")
	public WebElement firstname;
	@FindBy(xpath = "//input[@name='lastName']")
	public WebElement lastname;
	@FindBy(xpath = "//input[@name='phoneNumber']")
	public WebElement phonename;
	@FindBy(xpath = "//input[@name='email']")
	public WebElement customerEmail;
	
	@FindBy(xpath = "//a[contains(text(),'Tax Information')]")
	public WebElement taxInfoSubmenu;
	
	@FindBy(xpath = "(//input[@class='select2-focusser select2-offscreen']/..//b)[10]")
	public WebElement GSTMech;
	@FindBy(xpath = "(//input[@class='select2-input'][@role='combobox'])[10]")
	public WebElement GSTMechSearch;
	@FindBy(xpath = "(//div[@id='select2-drop']//ul[@class='select2-results']//li)[1]")
	public WebElement GSTMechSearchClick;
	
	@FindBy(xpath = "//input[@name='gstNumber']")
	public WebElement GSTIN;
	@FindBy(xpath = "//input[@name='panNumber']")
	public WebElement PAN;
	
	@FindBy(xpath = "//a[contains(text(),'Logo')]")
	public WebElement LogoSubmenu;
	@FindBy(xpath = "//input[@id='customerLogo']/..//span[contains(text(),'Select file')]/../..//div")
	public WebElement selectLogo;
	
	@FindBy(xpath = "//button[contains(text(),'Capture')]")
	public static WebElement Capture;

	@FindBy(xpath = "//button[@class='btn btn-green pull-right']")
	public WebElement save;
	
	@FindBy(xpath = "//div[@class='modal-body ng-scope']")
	public WebElement popupText;
	@FindBy(xpath = "//button[@class='btn btn-green']")
	public WebElement ConfirmationYES;
	
	@FindBy(xpath ="//a[@class='btn btn-green dropdown-toggle']")
	public WebElement newCustomerDropdown;
	
	@FindBy(xpath = "(//input[@type='text'])[1]")
	public WebElement searchbox;
	
	@FindBy(xpath = "(//div[@class='ui-grid-cell-contents ng-binding ng-scope']//a)[1]")
	public static WebElement searchedCust;
	
	
	
	
	
	
	public SupplierDetails_Page() {
		PageFactory.initElements(driver, this);
	}

}
