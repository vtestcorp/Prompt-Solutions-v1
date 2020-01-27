package com.PS.tests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;
import org.seleniumhq.jetty9.security.authentication.LoginAuthenticator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.PS.base.Base;
import com.PS.pages.CustomerDetails_Page;
import com.PS.util.Utility;
import com.TestNG.listener.CustomListener;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(CustomListener.class)
public class CustomersDetails extends Base {

	CustomerDetails_Page custDetails;
	public String totalCustCount;

	@BeforeSuite
	public void createReport() {
		create_ext_report("PS " + Utility.Date_Time().toString());

	}

	@Parameters({ "Browser" })
	@BeforeMethod
	public void setup(@Optional("Chrome") String Browser) throws URISyntaxException, IOException, InterruptedException {
		driverInitilization(Browser);
		custDetails = new CustomerDetails_Page();

		Utility.enterText(custDetails.email, Utility.excelRead(1, 0,"CustomerDetails"));
		Utility.enterText(custDetails.password, Utility.excelRead(1, 1, "CustomerDetails"));
		Utility.implicitwait();
		Utility.click(custDetails.LoginBtn);
		Utility.implicitwait();
		if (custDetails.CompanySetupWizardText.isDisplayed()) {

			System.out.println("User is logged in");
		} else {
			System.out.println("User is not Logged in");
		}
		Utility.implicitwait();
		Utility.click(custDetails.SkipBtn);
		Utility.implicitwait();
	}
	
	@Test(enabled = true)
	public void Test()
	{
		Utility.logger();
		System.out.println("crossed Logger");
	}
	
	@Test(priority=1,enabled = false)
	public void CreateCustomer() throws Exception {
		create_extent_test("Create customer, Search Customer, Update Customer Details");

		Utility.click(custDetails.CustomersMenuBtn);
		Thread.sleep(1000);

		Utility.JS_Scrolldown(custDetails.totalCustomerCount);
		Thread.sleep(1000);
		if (custDetails.totalCustomerCount.isDisplayed()) {
			totalCustCount = custDetails.totalCustomerCount.getText();
			System.out.println("Expected " + totalCustCount);
		} else {
			System.out.println("Not Displayed");
		}

		Thread.sleep(1000);
		Utility.click(custDetails.NewCustomer);
		Thread.sleep(2000);

		Utility.ExcelReadAndWrite(1, 2);
		Utility.implicitwait();
		Utility.enterText(custDetails.companyName, Utility.excelRead(1, 2, "CustomerDetails"));
		Thread.sleep(1000);

		Utility.click(custDetails.paymentTerm);
		Utility.enterText(custDetails.paymentTermSearch, Utility.excelRead(1, 3, "CustomerDetails"));
		Utility.click(custDetails.paymentTermSearchClick);

		Utility.click(custDetails.customerType);
		Utility.enterText(custDetails.customerTypeSearch, Utility.excelRead(1, 4, "CustomerDetails"));
		Utility.click(custDetails.customerTypeSearchClick);

		Utility.enterText(custDetails.companyWebsite, Utility.excelRead(1, 5,"CustomerDetails"));

		Utility.click(custDetails.customerSource);
		Utility.enterText(custDetails.customerSourceSearch, Utility.excelRead(1, 6, "CustomerDetails"));
		Utility.click(custDetails.customerSourceSearchClick);
		Thread.sleep(1000);
		Utility.click(custDetails.rateYourCompany);
		Utility.enterText(custDetails.rateYourCompanySearch, Utility.excelReadInt(1, 7, "CustomerDetails"));
		Utility.click(custDetails.rateYourCompanySearchClick);

		Utility.click(custDetails.Industry);
		Utility.enterText(custDetails.IndustrySearch, Utility.excelRead(1, 8, "CustomerDetails"));
		Utility.click(custDetails.IndustrySearchClick);

		Utility.enterText(custDetails.streetName, Utility.excelRead(1, 9, "CustomerDetails"));
		Utility.enterText(custDetails.city, Utility.excelRead(1, 10, "CustomerDetails"));

		Thread.sleep(1000);
		
//		if(driver.getPageSource().contains("name='billingStateId'")){
//			Utility.ActionClick(custDetails.state);
//			Utility.enterText(custDetails.state, Utility.excelRead(1, 11, "CustomerDetails));
//			}
//		else{
//			Utility.ActionClick(custDetails.stateName);
//			Utility.enterText(custDetails.stateNameSearch, Utility.excelRead(1, 11, "CustomerDetails));
//			Utility.ActionClick(custDetails.stateNameSearchClick);
//			}
		
		Utility.implicitwait();
		Utility.ActionClick(custDetails.sameAsBillingAddress);

		if(custDetails.zipcode.isDisplayed())
		{
		Utility.enterText(custDetails.zipcode, Utility.excelReadInt(1, 12, "CustomerDetails"));
		et.log(LogStatus.PASS, "Customer Details with Address information Entered", et.addScreenCapture(pass("Customer Details with Address information Entered")));
		
		} else {
			et.log(LogStatus.FAIL, "Customer Details with Address information not Entered", et.addScreenCapture(fail("Customer Details with Address information not Entered")));
		}
		
		Utility.click(custDetails.contactsubmenu);

		Utility.click(custDetails.title);
		Utility.enterText(custDetails.titleSearch, Utility.excelRead(1, 13, "CustomerDetails"));
		Utility.click(custDetails.titleSearchClick);

		Utility.enterText(custDetails.firstname, Utility.excelRead(1, 14, "CustomerDetails"));
		Utility.enterText(custDetails.lastname, Utility.excelRead(1, 15, "CustomerDetails"));
		Utility.enterText(custDetails.phonename, Utility.excelReadInt(1, 16, "CustomerDetails"));
		
		if(custDetails.customerEmail.isDisplayed())
		{
			Utility.enterText(custDetails.customerEmail, Utility.excelRead(1, 17, "CustomerDetails"));
		et.log(LogStatus.PASS, "Customer Details with contact information Entered", et.addScreenCapture(pass("Customer Details with contact information Entered")));
		
		} else {
			et.log(LogStatus.FAIL, "Customer Details with contact information not Entered", et.addScreenCapture(fail("Customer Details with contact information not Entered")));
		}
		
		Utility.click(custDetails.taxInfoSubmenu);
		Utility.click(custDetails.GSTMech);
		Utility.enterText(custDetails.GSTMechSearch, Utility.excelRead(1, 18, "CustomerDetails"));
		Utility.click(custDetails.GSTMechSearchClick);

		Utility.enterText(custDetails.GSTIN, Utility.excelReadInt(1, 19 ,"CustomerDetails"));
		
		if(custDetails.PAN.isDisplayed())
		{
		Utility.enterText(custDetails.PAN, Utility.excelReadInt(1, 20, "CustomerDetails"));
		et.log(LogStatus.PASS, "Customer Details with Tax information Entered", et.addScreenCapture(pass("Customer Details with tax information Entered")));
		
		} else {
			et.log(LogStatus.FAIL, "Customer Details with Tax information not Entered", et.addScreenCapture(fail("Customer Details with tax information not Entered")));
		}

		Utility.click(custDetails.LogoSubmenu);
		custDetails.selectLogo.click();
		
		Thread.sleep(3000);
		// below line execute the AutoIT script .
		System.out.println(System.getProperty("user.dir") + prop.getProperty("LogoFileUpload"));
		String UploadFileexe = System.getProperty("user.dir") + prop.getProperty("LogoFileUpload");
	    Runtime.getRuntime().exec(UploadFileexe);
	  
		Thread.sleep(5000);
		Utility.click(custDetails.Capture);
		
		Thread.sleep(2000);
		if(custDetails.save.isDisplayed())
		{
		et.log(LogStatus.PASS, "Company logo is selected", et.addScreenCapture(pass("Company logo is selected")));
		Utility.click(custDetails.save);
		}
		else {
			et.log(LogStatus.FAIL, "Company logo is not selected", et.addScreenCapture(fail("Company logo is not selected")));
		}
		if (custDetails.popupText.isDisplayed()) {
			et.log(LogStatus.PASS, "Confirmation pop up displayed", et.addScreenCapture(pass("Confirmation pop up displayed")));
			Utility.click(custDetails.ConfirmationYES);
		} 
		else {
			et.log(LogStatus.FAIL, "Confirmation pop up is not displayed", et.addScreenCapture(fail("Confirmation pop up is not displayed")));

		}

		String totalCustCountCurrent = custDetails.totalCustomerCount.getText();
		System.out.println("Actual" + totalCustCountCurrent);
		Thread.sleep(1000);
		try {
			
			Assert.assertNotEquals(totalCustCount, totalCustCountCurrent);
			System.out.println("count matched");
			et.log(LogStatus.PASS, "New Cusomter Created and count got increased",
					et.addScreenCapture(pass("New Customer is Created and count got increased")));

		} 
		catch (Exception ex) {
			System.out.println("count mismatched ");
			et.log(LogStatus.FAIL, "Customer Count hasn't increased",
					et.addScreenCapture(fail("Customer Count hasn't increased")));
		}

		Thread.sleep(1000);

		// Search by Customer name Customer name
		Utility.enterText(custDetails.searchbox, Utility.excelRead(1, 2, "CustomerDetails"));

		String expected = Utility.excelRead(1, 2, "CustomerDetails");
		String custext = custDetails.searchedCust.getText();
		System.out.println(custext);
		Thread.sleep(1000);
		try {
			Assert.assertEquals(custext, expected);
			System.out.println("Search matched");
			et.log(LogStatus.PASS, "New created customer name found", et.addScreenCapture(fail("New created customer name found")));
		} catch (Exception ex) {
			et.log(LogStatus.FAIL, "New created customer name found", et.addScreenCapture(pass("New created customer name not found")));
			System.out.println("search mismatched ");
		}

		// update Customer details
		Thread.sleep(1000);
		Utility.click(custDetails.hamburgerbtn);
		Utility.click(custDetails.editCustomer);
		Thread.sleep(1000);
		if (custDetails.CustomerTextVerify.isDisplayed()) {
			et.log(LogStatus.PASS, "Customer Information pop up is loaded",
					et.addScreenCapture(pass("Customer Information pop up is loaded")));
		} else {
			et.log(LogStatus.FAIL, "Customer Information pop up is not loaded",
					et.addScreenCapture(pass("Customer Information pop up is not loaded")));
		}
		Utility.ExcelReadAndWrite(1, 2);
		Utility.enterText(custDetails.companyName, Utility.excelRead(1, 2, "CustomerDetails"));
		String updatedCust = Utility.excelRead(1, 2, "CustomerDetails");
		Utility.click(custDetails.save);
		if (custDetails.popupText.isDisplayed()) {
			et.log(LogStatus.PASS, "Confirmation pop up displayed", et.addScreenCapture(pass("Confirmation pop up displayed")));
			Utility.click(custDetails.ConfirmationYES);
		} else {
			et.log(LogStatus.FAIL, "Confirmation pop up is not displayed", et.addScreenCapture(fail("Confirmation pop up is not displayed")));

		}
		Thread.sleep(3000);
		Utility.enterText(custDetails.searchbox, Utility.excelRead(1, 2, "CustomerDetails"));
		System.out.println(updatedCust);
		System.out.println("Expected" + Utility.excelRead(1, 2, "CustomerDetails"));
		String updatedCustName = custDetails.searchedCust.getText();

		System.out.println(updatedCustName);
		Thread.sleep(1000);
		try {
			Assert.assertEquals(updatedCust, updatedCustName);
			System.out.println("Updated customer name is displayed");
			et.log(LogStatus.PASS, "Updated customer name is displayed",
					et.addScreenCapture(fail("Updated customer name is displayed")));
		} catch (Exception ex) {
			et.log(LogStatus.FAIL, "Updated customer name is not displayed",
					et.addScreenCapture(pass("Updated customer name is not displayed")));
			System.out.println("Search Mismatched");
		}

		System.out.println("Passed");

	}

	@Test(priority=2,enabled = false)
	public void UploadCustomer() throws InterruptedException, IOException {

		create_extent_test("Upload customer details");
		
		Utility.click(custDetails.CustomersMenuBtn);

		Utility.click(custDetails.newCustomerDropdown);

		if (custDetails.importCustomer.isDisplayed()) {
			et.log(LogStatus.PASS, "Import Customers Text displayed",
					et.addScreenCapture(pass("Import Customers Text displayed")));
			Utility.click(custDetails.importCustomer);
		} else {
			et.log(LogStatus.FAIL, "Import Customers Text is not displayed",
					et.addScreenCapture(fail("Import Customers Text is not displayed")));
		}
		Utility.JS_Scrolldown(custDetails.Nextbtn);
		if (custDetails.Nextbtn.isDisplayed()) {
			et.log(LogStatus.PASS, "Import Customers Steps displayed",
					et.addScreenCapture(pass("Import Customers Steps displayed")));
			Utility.click(custDetails.Nextbtn);
		} else {
			et.log(LogStatus.FAIL, "Import Customers Steps is not displayed",
					et.addScreenCapture(fail("Import Customers Steps is not displayed")));
		}

		Thread.sleep(1000);
		Utility.click(custDetails.paymentTerm);
		Utility.enterText(custDetails.paymentTermSearch, Utility.excelRead(1, 8, "CustomerDetails"));
		Utility.click(custDetails.paymentTermSearchClick);

		Utility.implicitwait();
		Thread.sleep(2000);
		Utility.click(custDetails.customerType);
		Utility.enterText(custDetails.customerTypeSearch, Utility.excelRead(1, 4, "CustomerDetails"));
		Utility.click(custDetails.customerTypeSearchClick);

		Utility.implicitwait();
		Utility.click(custDetails.customerSource);
		Utility.enterText(custDetails.customerSourceSearch, Utility.excelRead(1, 6, "CustomerDetails"));
		Utility.click(custDetails.customerSourceSearchClick);

		Thread.sleep(2000);
		Utility.click(custDetails.rateYourCompany);
		Utility.enterText(custDetails.rateYourCompanySearch, Utility.excelRead(1, 3, "CustomerDetails"));
		Utility.click(custDetails.rateYourCompanySearchClick);

		Utility.implicitwait();
		if(custDetails.Nextbtn2.isDisplayed()) {
			et.log(LogStatus.PASS, "Step 1 Setup Data for Import information are filled",
				et.addScreenCapture(pass("Step 1 Setup Data for Import information are filled")));
			Utility.implicitwait();
			custDetails.Nextbtn2.click();
		} else {
			et.log(LogStatus.FAIL, "Step 1 Setup Data for Import information are not filled",
					et.addScreenCapture(fail("Step 1 Setup Data for Import information are not filled")));
		}
		Utility.click(custDetails.downloadTemplate);
		Thread.sleep(1000);
		Utility.implicitwait();
		Utility.implicitwait();
		if(custDetails.Nextbtn3.isDisplayed()) {
		
			et.log(LogStatus.PASS, "Step 2 Template Downloaded successfully",
					et.addScreenCapture(pass("Step 2 Template Downloaded successfully")));
			custDetails.Nextbtn3.click();
		} else {
			et.log(LogStatus.FAIL, "Step 2 Template Downloading Failed",
					et.addScreenCapture(fail("Step 2 Template Downloading failed")));
		}
		

		Utility.implicitwait();
		Thread.sleep(3000);
		Utility.JS_ScrollUP();
		Utility.ActionClick(custDetails.chooseFile);
		Utility.implicitwait();
		Thread.sleep(2000);
		// below line execute the AutoIT script .
		System.out.println(System.getProperty("user.dir") + prop.getProperty("ImportCustomers"));
		String Uploadexe = System.getProperty("user.dir") + prop.getProperty("ImportCustomers");
	    Runtime.getRuntime().exec(Uploadexe);
		
	    Utility.implicitwait();
		if(custDetails.FileName.isDisplayed()) {
			et.log(LogStatus.PASS, "Uploaded File name displayed",
					et.addScreenCapture(pass("Uploaded File name displayed")));
			Utility.implicitwait();
		} else {
			et.log(LogStatus.FAIL, "Uploaded file name is not displayed",
					et.addScreenCapture(fail("Uploaded file name is not displayed")));
		}	
		Utility.implicitwait();

		if(custDetails.uploadCustomers.isDisplayed()) {
			et.log(LogStatus.PASS, "Step 3 File uploaded successfully",
					et.addScreenCapture(pass("Step 3 File uploaded successfully")));
			custDetails.uploadCustomers.click();
		} else {
			et.log(LogStatus.FAIL, "Step 3 File uploaded Failed",
					et.addScreenCapture(fail("Step 3 File uploaded Failed")));
		}

	}

	@Test(priority=3,enabled = false)
	public void CreateSalesInvoice() throws Exception {
		create_extent_test("Create Sales Invoice");
		
		Utility.click(custDetails.CustomersMenuBtn);
		Utility.implicitwait();

		Utility.click(custDetails.hamburgerbtn);
		if (custDetails.createSOInvoice.isDisplayed()) {
			et.log(LogStatus.PASS, "Create SO Invoice Text displayed",
					et.addScreenCapture(pass("Create SO Invoice Text displayed")));
			Utility.click(custDetails.createSOInvoice);
		} else {
			et.log(LogStatus.FAIL, "Create SO Invoice is not displayed",
					et.addScreenCapture(fail("Create SO Invoice Text is not displayed")));
		}

		Utility.implicitwait();

		Utility.click(custDetails.ProjectName);
		Utility.enterText(custDetails.ProjectNameSearch, Utility.excelRead(1, 21, "CustomerDetails"));
		Utility.click(custDetails.ProjectNameSearchClick);

		Utility.click(custDetails.PlaceOfSupply);
		Thread.sleep(1000);
		Utility.ActionClick(custDetails.PlaceOFSupplyClick);

		Utility.enterText(custDetails.PlaceOFSupplyClickSearch, Utility.excelRead(1, 11, "CustomerDetails"));
		Utility.click(custDetails.PlaceOFSupplyClickClick);

		Utility.enterText(custDetails.CustomerPO, Utility.excelReadInt(1, 22, "CustomerDetails"));
		Utility.enterText(custDetails.ref, Utility.excelReadInt(1, 23, "CustomerDetails"));

		Utility.click(custDetails.BillingAddress);
		Utility.click(custDetails.BillingAddressAddNew);
		Utility.click(custDetails.cancelIcon);

		Thread.sleep(1000);
		Utility.implicitwait();
		Utility.wait(custDetails.pencilEditIcon);
		if (custDetails.pencilEditIcon.isDisplayed()) {
			et.log(LogStatus.PASS, "Billing Invoice information filled",
					et.addScreenCapture(pass("Billing Invoice information filled")));
		} else {
			et.log(LogStatus.FAIL, "Billing Invoice information not filled",
					et.addScreenCapture(fail("Billing Invoice information not filled")));
		}

		Utility.click(custDetails.pencilEditIcon);
		Utility.implicitwait();
		Utility.click(custDetails.productName);
		Utility.enterText(custDetails.productNameSearch, Utility.excelRead(1, 24, "CustomerDetails"));
		Utility.click(custDetails.productNameSearchClick);

		Utility.enterText(custDetails.quantity, Utility.excelReadInt(1, 25, "CustomerDetails"));
		Utility.enterText(custDetails.rate, Utility.excelReadInt(1, 26, "CustomerDetails"));

		Utility.implicitwait();
		Utility.JS_Scrolldown(custDetails.InvoiceSave);
		Utility.implicitwait();

		if (custDetails.InvoiceSave.isDisplayed()) {
			et.log(LogStatus.PASS, "Product, Quantity, Rate information filled",
					et.addScreenCapture(pass("Product, Quantity, Rate information filled")));
			Utility.click(custDetails.InvoiceSave);
		} else {
			et.log(LogStatus.FAIL, "Product, Quantity, Rate information not filled",
					et.addScreenCapture(fail("Product, Quantity, Rate information not filled")));
		}

		if (custDetails.ConfirmatioBox.isDisplayed()) {
			et.log(LogStatus.PASS, "Sales Invoice Details Filled Successfully",
					et.addScreenCapture(pass("Sales Invoice Details Filled Successfully")));
			Utility.implicitwait();
			Utility.click(custDetails.YES);
			System.out.println("Clicked");
			Utility.implicitwait();
		} else {
			et.log(LogStatus.FAIL, "Sales Invoice Details is not Filled",
					et.addScreenCapture(fail("Sales Invoice Details is not Filled")));
		}
		Thread.sleep(4000);
		Utility.wait(custDetails.ValidateSInvoice);
		if (custDetails.ValidateSInvoice.isDisplayed()) {
			et.log(LogStatus.PASS, "Sales Invoice is Created Sucessfully",
					et.addScreenCapture(pass("Sales Invoice is Created Sucessfully")));
			Utility.wait(custDetails.InvoiceClose);
			Utility.implicitwait();
			Thread.sleep(2000);
			Utility.implicitwait();
			Utility.click(custDetails.InvoiceClose);
		} else {
			et.log(LogStatus.FAIL, "Sales Invoice is not Created",
					et.addScreenCapture(fail("Sales Invoice is not Created")));
		}
		Utility.implicitwait();

		Thread.sleep(1000);
		Utility.JS_ScrollUP();
		Thread.sleep(2000);
		if(custDetails.FilterToggle.isDisplayed())
		{
			Utility.ActionClick(custDetails.FilterToggle);
			et.log(LogStatus.PASS, "Customer Sales Invoice Found", et.addScreenCapture(pass("Customer Sales Invoice Found")));
		} 
		else {
			et.log(LogStatus.FAIL, "Customer Sales Invoice is not Found", et.addScreenCapture(fail("Customer Sales Invoice is not Found")));

		}
		Utility.implicitwait();
		Utility.click(custDetails.CustomerClick);
		Utility.click(custDetails.CustomerBox);
		String expectedName = Utility.excelRead(1, 2, "CustomerDetails");
		System.out.println("Expected Name :" +expectedName);
		
		Utility.click(custDetails.applyFilter);
		Utility.implicitwait();
		
		String invoiceNum = custDetails.getInvoiceNumber.getText();
		Utility.ExcelWrite(1,27, invoiceNum);
		
		String invoiceAmount = custDetails.getInvoiceAmount.getText().substring(0, 3);
		Utility.ExcelWrite(1,28, invoiceAmount );
		
		String actualName = custDetails.getCustomerName.getText();
		System.out.println("Actual Name :" + actualName);
		
		try {
			Assert.assertEquals(actualName, expectedName);
			et.log(LogStatus.PASS, "Customer Sales Invoice Found", et.addScreenCapture(pass("Customer Sales Invoice Found")));
		} 
		catch (Exception ex){
			et.log(LogStatus.FAIL, "Customer Sales Invoice is not Found", et.addScreenCapture(fail("Customer Sales Invoice is not Found")));

		}
	}

	@Test(priority=4, enabled=false)
	public void CreateCreditMemo() throws InterruptedException, IOException
	{
	create_extent_test("Create Credit Memo");
		
		Utility.click(custDetails.CustomersMenuBtn);
		Utility.implicitwait();

		Utility.click(custDetails.hamburgerbtn);
		if (custDetails.createCreditMemo.isDisplayed()) {
			et.log(LogStatus.PASS, "Create Credit Memo text displayed",
					et.addScreenCapture(pass("Create Credit Memo text displayed")));
			Utility.click(custDetails.createCreditMemo);
		} else {
			et.log(LogStatus.FAIL, "Create Credit Memo text is not displayed",
					et.addScreenCapture(fail("Create Credit Memo text is not displayed")));
		}

		Utility.implicitwait();

		Thread.sleep(1000);
		Utility.implicitwait();
		Utility.wait(custDetails.pencilEditIcon);
		if (custDetails.pencilEditIcon.isDisplayed()) {
			et.log(LogStatus.PASS, "Edit icon displayed",
					et.addScreenCapture(pass("Edit icon displayed")));
		} else {
			et.log(LogStatus.FAIL, "Edit icon not displayed",
					et.addScreenCapture(fail("Edit icon not displayed")));
		}

		Utility.click(custDetails.pencilEditIcon);
		Utility.implicitwait();
		Utility.click(custDetails.MemoProductName);
		Utility.enterText(custDetails.MemoProductNameSearch, Utility.excelRead(1, 24, "CustomerDetails"));
		Utility.click(custDetails.MemoProductNameSearchClick);

		Utility.enterText(custDetails.MemoQuantity, Utility.excelReadInt(1, 25, "CustomerDetails"));
		Utility.enterText(custDetails.MemoRate, Utility.excelReadInt(1, 26, "CustomerDetails"));

		Utility.implicitwait();
		Utility.JS_Scrolldown(custDetails.MemoInvoiceSave);
		Utility.implicitwait();

		if (custDetails.MemoInvoiceSave.isDisplayed()) {
			et.log(LogStatus.PASS, "Product, Quantity, Rate information filled",
					et.addScreenCapture(pass("Product, Quantity, Rate information filled")));
			Utility.click(custDetails.MemoInvoiceSave);
		} else {
			et.log(LogStatus.FAIL, "Product, Quantity, Rate information not filled",
					et.addScreenCapture(fail("Product, Quantity, Rate information not filled")));
		}

		if (custDetails.MemoConfirmatioBox.isDisplayed()) {
			et.log(LogStatus.PASS, "Credit Memo Details Filled Successfully",
					et.addScreenCapture(pass("Credit Memo Details Filled Successfully")));
			Utility.implicitwait();
			Utility.click(custDetails.MemoYES);
			System.out.println("Clicked");
			Thread.sleep(1000);
			et.log(LogStatus.PASS, "Created Credit Memo Successfully",
					et.addScreenCapture(pass("Created Credit Memo Successfully")));
			Utility.implicitwait();
		} else {
			et.log(LogStatus.FAIL, "Credit Memo Details is not Filled and created",
					et.addScreenCapture(fail("Credit Memo Details is not Filled and created")));
		}
		Utility.implicitwait();
		Thread.sleep(1000);
		String CreatedMemoURL = "http://thepromptsolutions.com/test/businessnotes/#/creditMemoTx";
		System.out.println(Utility.getURL());
		String actualURL = Utility.getURL();
		
		if(actualURL.contains(CreatedMemoURL))
		{
			et.log(LogStatus.PASS, "Navigated to Credit Memo page successfully",
					et.addScreenCapture(pass("Navigated to Credit Memo page Successfully")));
		}
		else {
			et.log(LogStatus.FAIL, "Naviating to Prod URL instead of navigated to Credit Memo page.",
					et.addScreenCapture(fail("Naviating to Prod URL instead of navigated to Credit Memo page.")));
		}

	}
	
	@Test(priority=5, enabled = false)
	public void AcceptPayment() throws InterruptedException, IOException
	{
		create_extent_test("Accept Payment");
		
		Utility.click(custDetails.CustomersMenuBtn);
		Utility.implicitwait();
		
		Utility.click(custDetails.hamburgerbtn);
		
		if (custDetails.acceptPayment.isDisplayed()) {
			et.log(LogStatus.PASS, "Create Credit Memo text displayed",
					et.addScreenCapture(pass("Create Credit Memo text displayed")));
			Utility.click(custDetails.acceptPayment);
		} else 
		{
			et.log(LogStatus.FAIL, "Create Credit Memo text is not displayed",
					et.addScreenCapture(fail("Create Credit Memo text is not displayed")));
		}
		
		if(custDetails.paymentDetailPopupText.isDisplayed())
		{
			et.log(LogStatus.PASS, "Payment Detail popup text displayed",
					et.addScreenCapture(pass("Payment Detail popup text displayed")));
		} else
		{
			et.log(LogStatus.FAIL, "Payment Detail popup text is not displayed",
					et.addScreenCapture(fail("Payment Detail popup text is not displayed")));
		}
		
		String expectedCustName = Utility.excelRead(1, 2, "CustomerDetails");
		String actualCustName = custDetails.CustomerName.getText();
		
		if(actualCustName.contains(expectedCustName))
		{
			et.log(LogStatus.PASS, "Customer name matched",
					et.addScreenCapture(pass("Customer name matched")));
		} else
		{
			et.log(LogStatus.FAIL, "Customer name not matched",
					et.addScreenCapture(fail("Customer name not matched")));
		}
		
//		Utility.click(custDetails.clickInvoiceNumber);
//		Utility.enterText(custDetails.enterInvoiceNumberSearch,Utility.excelRead(1, 27, "CustomerDetails));
//		String actInvoiceResult = custDetails.clickInvoiceNumSearchSelect.getText();
//		String expInvoiceResult = Utility.excelRead(1, 27, "CustomerDetails);
//		Utility.implicitwait();
//		if(actInvoiceResult.contains(expInvoiceResult))
//		{
//			Utility.click(custDetails.clickInvoiceNumSearchSelect);
//			et.log(LogStatus.PASS, "Invoice Number matched",
//					et.addScreenCapture(pass("Invoice Number matched")));
//		} else
//		{
//			et.log(LogStatus.FAIL, "Invoice Number not found",
//					et.addScreenCapture(fail("Invoice Number not found")));
//			Utility.click(custDetails.clickInvoiceNumber);
//		}
		
		Thread.sleep(500);
		Utility.click(custDetails.paymentMode);
		Utility.enterText(custDetails.paymentModeSearch, Utility.excelRead(1, 28, "CustomerDetails"));
		Utility.click(custDetails.paymentModeSearchClick);
		Thread.sleep(1000);
		
		Utility.enterText(custDetails.paymentModeDetails, Utility.excelRead(1, 29, "CustomerDetails"));
		Utility.enterText(custDetails.amount, Utility.excelReadInt(1, 30, "CustomerDetails"));
		Thread.sleep(500);
		Utility.ActionClick(custDetails.addPayment);
		
		if(custDetails.addPayment.isDisplayed())
		{
			et.log(LogStatus.FAIL, "Payment is not added and Popup is still open state",
					et.addScreenCapture(fail("Payment is not added and Popup is still open state")));
			Utility.click(custDetails.cancel);
			System.out.println("Crossed");
		} else
		{
			et.log(LogStatus.PASS, "Payment is added successfully and customer payment pop up is closed",
					et.addScreenCapture(pass("Payment is added successfully and customer payment pop up is closed")));
		}
		Thread.sleep(1000);
		Utility.click(custDetails.searchedCust);
		Utility.implicitwait();
		
		Utility.click(custDetails.Payment);
		Thread.sleep(1000);
		String expected = "Transaction does not exist ";
		String actual = custDetails.PaymentTransactionNotExist.getText();
		if(actual.contains("Transaction does not exist "))
		{
			et.log(LogStatus.FAIL, "Customer Transaction does not exist",
					et.addScreenCapture(fail("Customer Transaction does not exist")));
		} else
		{
			et.log(LogStatus.PASS, "Customer Transaction found",
					et.addScreenCapture(pass("Customer Transaction found")));
		}
	}
	
	@Test(priority=6, enabled=false)
	public void ShowAddress() throws InterruptedException, IOException
	{
		create_extent_test("Add New Address and Update Existing Address");
		
		Utility.click(custDetails.CustomersMenuBtn);
		Utility.implicitwait();
		
		Utility.click(custDetails.hamburgerbtn);
		
		if (custDetails.ShowAddress.isDisplayed()) {
			et.log(LogStatus.PASS, "Show Address option displayed",
					et.addScreenCapture(pass("Show Address text displayed")));
			Utility.click(custDetails.ShowAddress);
		} else 
		{
			et.log(LogStatus.FAIL, "Show Address option not displayed",
					et.addScreenCapture(fail("Show Address text not displayed")));
		}
		
		if(custDetails.showAddressPopUpText.isDisplayed())
		{
			et.log(LogStatus.PASS, "Show Address popup page loaded",
					et.addScreenCapture(pass("Show Address popup page loaded")));
		} else
		{
			et.log(LogStatus.FAIL, "Show Address popup page loaded",
					et.addScreenCapture(fail("Show Address popup page loaded")));
		}
		Utility.click(custDetails.AddRow);
		Utility.enterText(custDetails.AddressName, Utility.excelRead(1, 31, "CustomerDetails"));
		Utility.enterText(custDetails.StreetAddress1, Utility.excelRead(1, 9, "CustomerDetails"));
		Utility.enterText(custDetails.AddressCity, Utility.excelRead(1, 10, "CustomerDetails"));
		
		Utility.click(custDetails.AddressSave);
		
		if(custDetails.AddressConfirmationYes.isDisplayed())
		{
			et.log(LogStatus.PASS, "Confirmation popup displayed",
					et.addScreenCapture(pass("Confirmation popup displayed")));
			custDetails.AddressConfirmationYes.click();
		} else
		{
			et.log(LogStatus.FAIL, "Confirmation popup not displayed",
					et.addScreenCapture(fail("Confirmation popup not displayed")));
		}
		
		//update existing address
		Utility.implicitwait();
		Utility.click(custDetails.AddressEdit);
		Utility.ActionClick(custDetails.DefaultAddressYES);
		
		Utility.click(custDetails.AddressSave);
		
		if(custDetails.AddressConfirmationYes.isDisplayed())
		{
			custDetails.AddressConfirmationYes.click();
			et.log(LogStatus.PASS, "Existing Address Updated",
					et.addScreenCapture(pass("Existing Address Updated")));		
		} else
		{
			et.log(LogStatus.FAIL, "Existing Address not Updated",
					et.addScreenCapture(fail("Existing Address not Updated")));
		}
	}
	
	@Test(priority=7, enabled = false)
	public void createExpense() throws InterruptedException, IOException
	{
	
		create_extent_test("Create Expense and verify");
		
		Utility.click(custDetails.CustomersMenuBtn);
		Utility.implicitwait();
		
		Utility.click(custDetails.hamburgerbtn);
		
		if (custDetails.createExpense.isDisplayed()) {
			et.log(LogStatus.PASS, "Create Expense option displayed",
					et.addScreenCapture(pass("Create Expense text displayed")));
			Utility.click(custDetails.createExpense);
		} else 
		{
			et.log(LogStatus.FAIL, "Create Expense option not displayed",
					et.addScreenCapture(fail("Create Expense text not displayed")));
		}
		
		Utility.implicitwait();
		Thread.sleep(1000);
		if (custDetails.ExpPencilIcon.isDisplayed()) {
			Utility.click(custDetails.ExpPencilIcon);
			et.log(LogStatus.PASS, "Edit icon displayed",
					et.addScreenCapture(pass("Edit icon displayed")));
		} else {
			et.log(LogStatus.FAIL, "Edit icon not displayed",
					et.addScreenCapture(fail("Edit icon not displayed")));
		}
		
		Utility.implicitwait();
		Utility.click(custDetails.ExpenseType);
		Utility.enterText(custDetails.expenseTypeSearch, Utility.excelRead(1, 33, "CustomerDetails"));
		Utility.click(custDetails.expenseTypeSearchClick);

		Thread.sleep(1000);
		Utility.enterText(custDetails.expenseAmount, Utility.excelReadInt(1, 34, "CustomerDetails"));
		if(custDetails.createExpenseBtn.isDisplayed())
		{
		et.log(LogStatus.PASS, "Create Expense details Filled",
				et.addScreenCapture(pass("Create Expense details Filled")));
		Utility.click(custDetails.createExpenseBtn);
		} else 
		{
			et.log(LogStatus.FAIL, "Create Expense details not Filled",
				et.addScreenCapture(fail("Create Expense details not Filled")));
		}
		Utility.implicitwait();
		if(custDetails.expConfirmationBoxYES.isDisplayed())
		{
			et.log(LogStatus.PASS, "Confirmation Pop up displayed",
					et.addScreenCapture(pass("Confirmation Pop up displayed")));
			Utility.click(custDetails.expConfirmationBoxYES);
			} 
		else 
			{
				et.log(LogStatus.FAIL, "Confirmation Pop up displayed",
					et.addScreenCapture(fail("Confirmation Pop up displayed")));
			}

		Utility.wait(custDetails.ValidateSInvoice);
		if (custDetails.ValidateSInvoice.isDisplayed()) {
			et.log(LogStatus.PASS, "Expense Created Sucessfully",
					et.addScreenCapture(pass("Expense Created Sucessfully")));
			Utility.wait(custDetails.InvoiceClose);
			Utility.implicitwait();
			Thread.sleep(2000);
			Utility.implicitwait();
			Utility.click(custDetails.InvoiceClose);
		} else {
			et.log(LogStatus.FAIL, "Expense not Created",
					et.addScreenCapture(fail("Expense not Created")));
		}
		Utility.implicitwait();

		Thread.sleep(1000);
		Utility.JS_ScrollUP();
		
		String ExpenseNum = custDetails.getInvoiceNumber.getText();
		Utility.ExcelWrite(1,27, ExpenseNum);
		
		String expectedName = Utility.excelRead(1, 2, "CustomerDetails");
		
		String actualName = custDetails.getExpCustomerName.getText();
		System.out.println("Actual Name :" + actualName);
		
		try {
			Assert.assertEquals(actualName, expectedName);
			et.log(LogStatus.PASS, "Customer name expense Found", et.addScreenCapture(pass("Customer name expense Found")));
		} 
		catch (Exception ex){
			et.log(LogStatus.FAIL, "Customer name expense is not Found", et.addScreenCapture(fail("Customer name expense is not Found")));

		}
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.close();
	}

	@AfterSuite
	public void closeReport() {
		if (driver != null) {
			driver.quit();
		}
		close_ext_Report();
		Utility.closeAllOpenBrowser();
	}

}
