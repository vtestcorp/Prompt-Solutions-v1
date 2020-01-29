package com.PS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.PS.base.Base;

public class CustomerDetails_Page extends Base {

	@FindBy(xpath = "//input[@placeholder='Email']")
	public WebElement email;

	@FindBy(xpath = "//input[@placeholder='Password']")
	public WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement LoginBtn;

	@FindBy(xpath = "//h2[@class='text-center signup-wizard-hding ng-scope']")
	public WebElement CompanySetupWizardText;

	@FindBy(xpath = "//button[@class='btn-sm btn btn-default pull-left']")
	public WebElement SkipBtn;

	@FindBy(xpath = "//ul[@role='menu']//a[@href='/admin/customers']")
	public WebElement CustomersMenuBtn;

	@FindBy(xpath = "//button[contains(text(),'New Customer')]")
	public WebElement NewCustomer;
	@FindBy(xpath = "//input[@placeholder='Enter Company Name']")
	public WebElement companyName;
	
	@FindBy(xpath = "//div[contains(text(),'Select Payment Term')]")
	public WebElement paymentTerm;
	@FindBy(xpath = "//li[@name='Cash on Delivery']")
	public WebElement paymentTermSearch;
	@FindBy(xpath = "//div[@id='select2-drop']//ul[@id='select2-results-70']")
	public WebElement paymentTermSearchClick;
	
	@FindBy(xpath = "//input[@id='s2id_autogen72']/..//b")
	public WebElement customerType;
	@FindBy(xpath = "//input[@id='s2id_autogen72_search']")
	public WebElement customerTypeSearch;
	@FindBy(xpath = "//div[@id='select2-drop']//ul[@id='select2-results-72']")
	public WebElement customerTypeSearchClick;
	
	@FindBy(xpath = "//input[@name='website']")
	public WebElement companyWebsite;
	
	@FindBy(xpath = "//input[@id='s2id_autogen74']/..//b")
	public WebElement customerSource;
	@FindBy(xpath = "//input[@id='s2id_autogen74_search']")
	public WebElement customerSourceSearch;
	@FindBy(xpath = "//div[@id='select2-drop']//ul[@id='select2-results-74']")
	public WebElement customerSourceSearchClick;
	
	@FindBy(xpath = "//input[@id='s2id_autogen76']/..//b")
	public WebElement rateYourCompany;
	@FindBy(xpath = "//input[@id='s2id_autogen76_search']")
	public WebElement rateYourCompanySearch;
	@FindBy(xpath = "//div[@id='select2-drop']//ul[@id='select2-results-76']")
	public WebElement rateYourCompanySearchClick;
	
	@FindBy(xpath = "//input[@id='s2id_autogen78']/..//b")
	public WebElement Industry;
	@FindBy(xpath = "//input[@id='s2id_autogen78_search']")
	public WebElement IndustrySearch;
	@FindBy(xpath = "//div[@id='select2-drop']//ul[@id='select2-results-78']")
	public WebElement IndustrySearchClick;
	
	@FindBy(xpath = "//input[@name='billingStreetl']")
	public WebElement streetName;
	
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
	
	@FindBy(xpath = "//input[@type='checkbox'][@ng-model='popUp.customer.shippingAddressSameAsBilling']")
	public WebElement sameAsBillingAddress;
	
	@FindBy(xpath = "//a[@class='ng-binding'][contains(text(),'Contact')]")
	public WebElement contactsubmenu;
	
	@FindBy(xpath = "//input[@id='s2id_autogen84']/..//b")
	public WebElement title;
	@FindBy(xpath = "//input[@id='s2id_autogen84_search']")
	public WebElement titleSearch;
	@FindBy(xpath = "//div[@id='select2-drop']//ul[@id='select2-results-84']")
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
	@FindBy(xpath = "//input[@id='s2id_autogen86']/..//b")
	public WebElement GSTMech;
	@FindBy(xpath = "//input[@id='s2id_autogen86_search']")
	public WebElement GSTMechSearch;
	@FindBy(xpath = "//div[@id='select2-drop']//ul[@id='select2-results-86']")
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
	
	@FindBy(xpath = "//li[starts-with(text(),'Total')]")
	public WebElement totalCustomerCount;
	
	@FindBy(xpath ="//a[@class='btn btn-green dropdown-toggle']")
	public WebElement newCustomerDropdown;
	
	@FindBy(xpath = "//div[@id='page-container']//ul[@class='dropdown-menu']//a[1]")
	public WebElement importCustomer;
	
	@FindBy(xpath = "(//input[@type='submit'])[1]")
	public WebElement Nextbtn;
	
	@FindBy(xpath = "(//input[@value='Next'])[2]")
	public WebElement Nextbtn2;
	
	@FindBy(xpath = "(//input[@value='Next'])[3]")
	public WebElement Nextbtn3;
	
	@FindBy(xpath = "//button[contains(@class,'btn btn-green center-block')]//i")
	public WebElement downloadTemplate;
	@FindBy(xpath = "//input[@type='file'][@name='file']")
	public WebElement chooseFile;
	@FindBy(xpath = "//span[contains(text(),'ImportCustomers.xls')]")
	public WebElement FileName;
	
	@FindBy(xpath = "//div[contains(@class,'pull-right')]//input[contains(@class,'finish btn-green btn')]")
	public WebElement uploadCustomers;
	
	@FindBy(xpath = "(//input[@type='text'])[1]")
	public WebElement searchbox;
	
	@FindBy(xpath = "(//div[@class='ui-grid-cell-contents ng-binding ng-scope']//a//strong)[1]")
	public WebElement searchedCust;
	
	@FindBy(xpath = "(//button[@type='button'])[2]")
	public WebElement hamburgerbtn;
	
	@FindBy(xpath = "((//ul[@id='bo-li-style-3'])[1]/li)[7]")
	public WebElement editCustomer;
	
	@FindBy(xpath = "//h3[@class='modal-title text-center ng-binding']")
	public WebElement CustomerTextVerify;
	
	@FindBy(xpath = "((//ul[@id='bo-li-style-3'])[1]/li)[2]")
	public static WebElement createSOInvoice;
	
	@FindBy(xpath = "//input[@id='s2id_autogen87']/..//b")
	public static WebElement CustomerSelection;
	
	@FindBy(xpath = "//input[@id='s2id_autogen87']/..//b")
	public WebElement ProjectName;
	@FindBy(xpath = "//input[@id='s2id_autogen87_search']")
	public static WebElement ProjectNameSearch;
	@FindBy(xpath = "//div[@id='select2-drop']//ul[@id='select2-results-87']")
	public static WebElement ProjectNameSearchClick;
	
	@FindBy(xpath = "//label[contains(text(),'Select Place of Supply')]")
	public static WebElement PlaceOfSupply;
	@FindBy(xpath = "//span[contains(text(),'Select Place of Supply')]/..//b")
	public WebElement PlaceOFSupplyClick;
	@FindBy(xpath = "//input[@id='s2id_autogen77_search']")
	public static WebElement PlaceOFSupplyClickSearch;
	@FindBy(xpath = "//div[@id='select2-drop']//ul[@id='select2-results-77']")
	public static WebElement PlaceOFSupplyClickClick;
	
	@FindBy(xpath = "(//input[@name='referenceNumber'])[1]")
	public static WebElement CustomerPO;
	@FindBy(xpath = "(//input[@name='referenceNumber'])[2]")
	public static WebElement ref;
	
	@FindBy(xpath = "//input[@id='s2id_autogen79']/..//b")
	public WebElement BillingAddress;
	@FindBy(xpath = "//div[@id='select2-drop']//ul[@id='select2-results-79']")
	public WebElement BillingAddressAddNew;
	@FindBy(xpath = "//span[contains(text(),'×')]")
	public WebElement cancelIcon;
	
	@FindBy(xpath = "(//input[@class='select2-focusser select2-offscreen'][@role='button'])[9]/..//b")
	public WebElement payTerms;
	@FindBy(xpath = "//input[@id='s2id_autogen83_search']")
	public static WebElement payTermsSearch;
	@FindBy(xpath = "//div[@id='select2-drop']//ul[@id='select2-results-83']")
	public static WebElement payTermsSearchClick;
	
	@FindBy(xpath = "//i[@class='glyphicon glyphicon-pencil']/..")
	public WebElement pencilEditIcon;
	@FindBy(xpath = "(//input[@class='select2-focusser select2-offscreen'][@role='button'])[10]/..//b")
	public WebElement productName;
	@FindBy(xpath = "(//input[@type='text'][@role='combobox'])[15]")
	public static WebElement productNameSearch;
	@FindBy(xpath = "//div[@class='select2-result-label'][@role='option']")
	public static WebElement productNameSearchClick;
	
	@FindBy(xpath = "//input[@id='0-2'][@type='number']")
	public static WebElement quantity;
	@FindBy(xpath = "//input[@id='rate0'][@type='number']")
	public static WebElement rate;
	
	@FindBy(xpath = "//button[@class='btn btn-green pull-left']")
	public static WebElement InvoiceSave;
	
	@FindBy(xpath = "//p[@class='ng-binding']")
	public static WebElement ConfirmatioBox;
	
	@FindBy(xpath = "//button[@class='btn btn-green']")
	public static WebElement YES;
	
	@FindBy(xpath = "//div[@class='modal-header ng-scope']//h3[@id='reportTitle']")
	public static WebElement ValidateSInvoice;
	
	@FindBy(xpath = "//div[@class='modal-header ng-scope']//button[@type='button']")
	public static WebElement InvoiceClose;
	
	@FindBy(xpath = "//div[@id='page-container']//tr[1]//td[1]")
	public static WebElement getInvoiceNumber;
	
	@FindBy(xpath = "//div[@id='page-container']//tr[1]//td[4]")
	public static WebElement getInvoiceAmount;
	
	@FindBy(xpath = "(//h4[@class='panel-title']//a[@accordion-transclude='heading'])//i[@class='pull-right fa fa-angle-left']")
	public static WebElement FilterToggle;
	
	@FindBy(xpath = "//input[@class='select2-input select2-default'][@type='text']")
	public static WebElement CustomerClick;
	@FindBy(xpath = "//ul[@class='select2-results']//li[1]")
	public static WebElement CustomerBox;
	
	@FindBy(xpath ="//button[@class='btn btn-green']")
	public static WebElement applyFilter;
	
	@FindBy(xpath = "//div[@id='page-container']//td[3]//a")
	public static WebElement getCustomerName;
	
	//create credit memo
	@FindBy(xpath = "((//ul[@id='bo-li-style-3'])[1]/li)[3]")
	public static WebElement createCreditMemo;
	
	@FindBy(xpath = "(//input[@class='select2-focusser select2-offscreen'][@role='button'])[5]/..//b")
	public WebElement MemoProductName;
	@FindBy(xpath = "(//input[@type='text'][@role='combobox'])[11]")
	public static WebElement MemoProductNameSearch;
	@FindBy(xpath = "//div[@class='select2-result-label'][@role='option']")
	public static WebElement MemoProductNameSearchClick;
	
	@FindBy(xpath = "//input[@id='0-2'][@type='number']")
	public static WebElement MemoQuantity;
	@FindBy(xpath = "//input[@id='0-4'][@type='number']")
	public static WebElement MemoRate;
	
	@FindBy(xpath = "//button[@class='btn btn-green']")
	public static WebElement MemoInvoiceSave;
	
	@FindBy(xpath = "//p[@class='ng-binding']")
	public static WebElement MemoConfirmatioBox;
	
	@FindBy(xpath = "(//button[@class='btn btn-green'])[2]")
	public static WebElement MemoYES;
	
	//Accept Payment
	@FindBy(xpath = "((//ul[@id='bo-li-style-3'])[1]/li)[5]")
	public WebElement acceptPayment;
	
	@FindBy(xpath = "//div[@class='modal-header ignorePDFElement']//h3[@id='reportTitle']")
	public WebElement paymentDetailPopupText;
	
	@FindBy(xpath = "//div[@class='col-sm-6 ng-binding']")
	public WebElement CustomerName;
	
	@FindBy(xpath = "(//input[@class='select2-focusser select2-offscreen'][@role='button'])[2]/..//b")
	public static WebElement clickInvoiceNumber;
	@FindBy(xpath = "(//input[@class='select2-input'][@type='text'])[3]")
	public static WebElement enterInvoiceNumberSearch;
	@FindBy(xpath = "//div[@id='select2-drop']//ul[@class='select2-results']")
	public static WebElement clickInvoiceNumSearchSelect;
	
	@FindBy(xpath = "(//input[@class='select2-focusser select2-offscreen'][@role='button'])[3]/..//b")
	public static WebElement paymentMode;
	@FindBy(xpath = "(//input[@class='select2-input'][@type='text'])[3]")
	public static WebElement paymentModeSearch;
	@FindBy(xpath = "//div[@id='select2-drop']//ul[@class='select2-results']")
	public static WebElement paymentModeSearchClick;
	
	@FindBy(xpath = "//input[@name='payment Mode Details']")
	public static WebElement paymentModeDetails;
	
	@FindBy(xpath = "//input[@name='amount']")
	public static WebElement amount;
	
	@FindBy(xpath = "//button[@type='submit'][@class='btn btn-green']")
	public static WebElement addPayment;
	
	@FindBy(xpath = "//button[@type='button'][@class='btn btn-default']")
	public static WebElement cancel;
	
	@FindBy(xpath = "(//div[@class='ui-grid-cell-contents ng-binding ng-scope']//a)[1]")
	public static WebElement searchedCust1;
	
	@FindBy(xpath ="(//button[@class='btn btn-green-alt'][@title='Payment'])[1]")
	public static WebElement Payment;
	
	@FindBy(xpath = "//h4[contains(text(),'Transaction does not exist')]")
	public static WebElement PaymentTransactionNotExist;
	
	//Show Address
	@FindBy(xpath = "((//ul[@id='bo-li-style-3'])[1]/li)[11]")
	public static WebElement ShowAddress;
	
	@FindBy(xpath = "//h3[@class='modal-title text-center']")
	public static WebElement showAddressPopUpText;
	
	@FindBy(xpath = "(//button[@class='btn btn-default'])[1]")
	public static WebElement AddRow;
	
	@FindBy(xpath = "//input[@id='2']")
	public static WebElement AddressName;
	
	@FindBy(xpath = "//tr[3]//td[5]//input[1]")
	public static WebElement StreetAddress1;
	
	@FindBy(xpath = "//tr[3]//td[6]//input[1]")
	public static WebElement StreetAddress2;
	
	@FindBy(xpath = "//tr[3]//td[7]//input[1]")
	public static WebElement AddressCity;
	
	@FindBy(xpath = "//select[@class='show-address-input ng-pristine ng-valid ng-empty ng-touched']")
	public static WebElement AddressCountry;
	
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	public static WebElement AddressSave;
	@FindBy(xpath = "//button[@class='btn btn-green']")
	public static WebElement AddressConfirmationYes;
	
	@FindBy(xpath = "//tr[3]//td[11]//div[1]//button[1]")
	public static WebElement AddressEdit;
	
	@FindBy(xpath = "(//div[@class='icheckbox_flat'])[12]//input[@type='checkbox']")
	public WebElement DefaultAddressYES;
	
	//create Expense
		@FindBy(xpath = "((//ul[@id='bo-li-style-3'])[1]/li)[4]")
		public static WebElement createExpense;
		
		@FindBy(xpath = "//div[@class='actionIcon ng-scope']//a[@class='ng-scope']")
		public static WebElement ExpPencilIcon;
		
		@FindBy(xpath = "(//input[@class='select2-focusser select2-offscreen'][@role='button'])[6]/..//b")
		public static WebElement ExpenseType;
		@FindBy(xpath = "(//input[@type='text'][@role='combobox'])[6]")
		public static WebElement expenseTypeSearch;
		@FindBy(xpath = "//div[@class='select2-result-label'][@role='option']")
		public static WebElement expenseTypeSearchClick;
		
		@FindBy(xpath = "//input[@id='0-2'][@type='number']")
		public static WebElement expenseAmount;
		@FindBy(xpath = "//button[@class='btn btn-green ng-binding']")
		public static WebElement createExpenseBtn;
		@FindBy(xpath = "//button[@class='btn btn-green']")
		public static WebElement expConfirmationBoxYES;
		
		@FindBy(xpath = "//div[@id='page-container']//tr[1]//td[1]")
		public static WebElement getExpenseNumber;
		
		@FindBy(xpath = "//div[@id='page-container']//tr[1]//td[2]")
		public static WebElement getExpCustomerName;
		
		//cutomer search
		@FindBy(xpath = "(//a[@class='company-name'])[1]")
		public WebElement labelFirstCustomerName;
		
		@FindBy(xpath="//div[@aria-rowindex='2']//button[1]")
		public WebElement update_customer_menu_button_for_first_row;
		
		
		@FindBy(xpath="//a[text()='Edit Customer']")
		public WebElement edit_cust_option;
		@FindBy(xpath = "//input[@placeholder='Enter 3 characters customer name']")
		public WebElement textBoxSearch;
		
		@FindBy(xpath = "//i[@class='anticon anticon-plus']")
		public WebElement buttonPlus;
		
		@FindBy(xpath = "//a[text()='Sales Invoice']")
		public WebElement linkSalesInvoice;
		
		@FindBy(xpath = "//*[text()='Standard Invoice']")
		public WebElement headerSalesInvoice;
		
		@FindBy(xpath = "(//div[@class='value'])[1]")
		public WebElement labelSelectedCustomerName;
		
		@FindBy(xpath = "//button[@class='ant-btn ant-btn-icon-only']//preceding-sibling::div[1]")
		public WebElement dropDownCustomer;
		
		@FindBy(xpath = "(//div[@ref='eCenterContainer'])[1]//child::div[2]")
		public WebElement textBoxRefNo;
		
		@FindBy(xpath = "//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']//li[1]")
		public WebElement optionFirst;
	
	public CustomerDetails_Page() {
		PageFactory.initElements(driver, this);
	}
}
