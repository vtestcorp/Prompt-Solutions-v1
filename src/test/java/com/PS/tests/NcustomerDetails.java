package com.PS.tests;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

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
import com.PS.pages.login;
import com.PS.util.Utility;
import com.TestNG.listener.CustomListener;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(CustomListener.class)
public class NcustomerDetails extends Base {
	CustomerDetails_Page custDetails;
	public String totalCustCount;

	@Test(enabled = false)
	public void CreateCustomer() throws Exception {
		Utility.logger();
		custDetails = new CustomerDetails_Page();
		create_extent_test("Create customer");
		new login().login(Utility.excelRead(2, 0, "CustomerDetails"), Utility.excelRead(2, 1, "CustomerDetails"));
		Thread.sleep(4000);
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

		Utility.ExcelReadAndWrite(2, 2);
		Utility.implicitwait();
		Utility.enterText(custDetails.companyName, Utility.excelRead(2, 2, "CustomerDetails"));
		Thread.sleep(1000);

		Utility.click(custDetails.paymentTerm);
		Thread.sleep(2000);
		custDetails.paymentTermSearch.click();
		// custDetails.paymentTermSearch.sendKeys( Utility.excelRead(2, 3,
		// "CustomerDetails"));
		// Utility.click(custDetails.paymentTerm);
//
//		Utility.click(custDetails.customerType);
//		Utility.enterText(custDetails.customerTypeSearch, Utility.excelRead(1, 4, "CustomerDetails"));
//		Utility.click(custDetails.customerTypeSearchClick);
//
//		Utility.enterText(custDetails.companyWebsite, Utility.excelRead(1, 5,"CustomerDetails"));
//
//		Utility.click(custDetails.customerSource);
//		Utility.enterText(custDetails.customerSourceSearch, Utility.excelRead(1, 6, "CustomerDetails"));
//		Utility.click(custDetails.customerSourceSearchClick);
//		Thread.sleep(1000);
//		Utility.click(custDetails.rateYourCompany);
//		Utility.enterText(custDetails.rateYourCompanySearch, Utility.excelReadInt(1, 7, "CustomerDetails"));
//		Utility.click(custDetails.rateYourCompanySearchClick);
//
//		Utility.click(custDetails.Industry);
//		Utility.enterText(custDetails.IndustrySearch, Utility.excelRead(1, 8, "CustomerDetails"));
//		Utility.click(custDetails.IndustrySearchClick);
//
//		Utility.enterText(custDetails.streetName, Utility.excelRead(1, 9, "CustomerDetails"));
//		Utility.enterText(custDetails.city, Utility.excelRead(1, 10, "CustomerDetails"));
//
//		Thread.sleep(1000);
//		
////		if(driver.getPageSource().contains("name='billingStateId'")){
////			Utility.ActionClick(custDetails.state);
////			Utility.enterText(custDetails.state, Utility.excelRead(1, 11, "CustomerDetails));
////			}
////		else{
////			Utility.ActionClick(custDetails.stateName);
////			Utility.enterText(custDetails.stateNameSearch, Utility.excelRead(1, 11, "CustomerDetails));
////			Utility.ActionClick(custDetails.stateNameSearchClick);
////			}
//		
//		Utility.implicitwait();
//		Utility.ActionClick(custDetails.sameAsBillingAddress);
//
//		if(custDetails.zipcode.isDisplayed())
//		{
//		Utility.enterText(custDetails.zipcode, Utility.excelReadInt(1, 12, "CustomerDetails"));
//		et.log(LogStatus.PASS, "Customer Details with Address information Entered", et.addScreenCapture(pass("Customer Details with Address information Entered")));
//		
//		} else {
//			et.log(LogStatus.FAIL, "Customer Details with Address information not Entered", et.addScreenCapture(fail("Customer Details with Address information not Entered")));
//		}
//		
//		Utility.click(custDetails.contactsubmenu);
//
//		Utility.click(custDetails.title);
//		Utility.enterText(custDetails.titleSearch, Utility.excelRead(1, 13, "CustomerDetails"));
//		Utility.click(custDetails.titleSearchClick);
//
//		Utility.enterText(custDetails.firstname, Utility.excelRead(1, 14, "CustomerDetails"));
//		Utility.enterText(custDetails.lastname, Utility.excelRead(1, 15, "CustomerDetails"));
//		Utility.enterText(custDetails.phonename, Utility.excelReadInt(1, 16, "CustomerDetails"));
//		
//		if(custDetails.customerEmail.isDisplayed())
//		{
//			Utility.enterText(custDetails.customerEmail, Utility.excelRead(1, 17, "CustomerDetails"));
//		et.log(LogStatus.PASS, "Customer Details with contact information Entered", et.addScreenCapture(pass("Customer Details with contact information Entered")));
//		
//		} else {
//			et.log(LogStatus.FAIL, "Customer Details with contact information not Entered", et.addScreenCapture(fail("Customer Details with contact information not Entered")));
//		}
//		
//		Utility.click(custDetails.taxInfoSubmenu);
//		Utility.click(custDetails.GSTMech);
//		Utility.enterText(custDetails.GSTMechSearch, Utility.excelRead(1, 18, "CustomerDetails"));
//		Utility.click(custDetails.GSTMechSearchClick);
//
//		Utility.enterText(custDetails.GSTIN, Utility.excelReadInt(1, 19 ,"CustomerDetails"));
//		
//		if(custDetails.PAN.isDisplayed())
//		{
//		Utility.enterText(custDetails.PAN, Utility.excelReadInt(1, 20, "CustomerDetails"));
//		et.log(LogStatus.PASS, "Customer Details with Tax information Entered", et.addScreenCapture(pass("Customer Details with tax information Entered")));
//		
//		} else {
//			et.log(LogStatus.FAIL, "Customer Details with Tax information not Entered", et.addScreenCapture(fail("Customer Details with tax information not Entered")));
//		}
//
//		Utility.click(custDetails.LogoSubmenu);
//		custDetails.selectLogo.click();
//		
//		Thread.sleep(3000);
//		// below line execute the AutoIT script .
//		System.out.println(System.getProperty("user.dir") + prop.getProperty("LogoFileUpload"));
//		String UploadFileexe = System.getProperty("user.dir") + prop.getProperty("LogoFileUpload");
//	    Runtime.getRuntime().exec(UploadFileexe);
//	  
//		Thread.sleep(5000);
//		Utility.click(custDetails.Capture);
//		
//		Thread.sleep(2000);
//		if(custDetails.save.isDisplayed())
//		{
//		et.log(LogStatus.PASS, "Company logo is selected", et.addScreenCapture(pass("Company logo is selected")));
//		Utility.click(custDetails.save);
//		}
//		else {
//			et.log(LogStatus.FAIL, "Company logo is not selected", et.addScreenCapture(fail("Company logo is not selected")));
//		}
//		if (custDetails.popupText.isDisplayed()) {
//			et.log(LogStatus.PASS, "Confirmation pop up displayed", et.addScreenCapture(pass("Confirmation pop up displayed")));
//			Utility.click(custDetails.ConfirmationYES);
//		} 
//		else {
//			et.log(LogStatus.FAIL, "Confirmation pop up is not displayed", et.addScreenCapture(fail("Confirmation pop up is not displayed")));
//
//		}
//
//		String totalCustCountCurrent = custDetails.totalCustomerCount.getText();
//		System.out.println("Actual" + totalCustCountCurrent);
//		Thread.sleep(1000);
//		try {
//			
//			Assert.assertNotEquals(totalCustCount, totalCustCountCurrent);
//			System.out.println("count matched");
//			et.log(LogStatus.PASS, "New Cusomter Created and count got increased",
//					et.addScreenCapture(pass("New Customer is Created and count got increased")));
//
//		} 
//		catch (Exception ex) {
//			System.out.println("count mismatched ");
//			et.log(LogStatus.FAIL, "Customer Count hasn't increased",
//					et.addScreenCapture(fail("Customer Count hasn't increased")));
//		}
//
//		Thread.sleep(1000);
//
//		// Search by Customer name Customer name
//		Utility.enterText(custDetails.searchbox, Utility.excelRead(1, 2, "CustomerDetails"));
//
//		String expected = Utility.excelRead(1, 2, "CustomerDetails");
//		String custext = custDetails.searchedCust.getText();
//		System.out.println(custext);
//		Thread.sleep(1000);
//		try {
//			Assert.assertEquals(custext, expected);
//			System.out.println("Search matched");
//			et.log(LogStatus.PASS, "New created customer name found", et.addScreenCapture(fail("New created customer name found")));
//		} catch (Exception ex) {
//			et.log(LogStatus.FAIL, "New created customer name found", et.addScreenCapture(pass("New created customer name not found")));
//			System.out.println("search mismatched ");
//		}
	}

	@Test(enabled = false)
	public void customerSearch() throws InterruptedException, IOException {

		Utility.logger();
		custDetails = new CustomerDetails_Page();
		create_extent_test("CUSTOMER SEARCH");
		new login().login(Utility.excelRead(2, 0, "CustomerDetails"), Utility.excelRead(2, 1, "CustomerDetails"));
		Thread.sleep(4000);
		Utility.click(custDetails.CustomersMenuBtn);
		Thread.sleep(1000);
		Utility.implicitwait();
		String customerName = custDetails.labelFirstCustomerName.getText();
		Utility.enterText(custDetails.textBoxSearch, customerName);
		if (customerName.equals(custDetails.labelFirstCustomerName.getText())) {
			et.log(LogStatus.PASS, "Matching customer is displayed",
					et.addScreenCapture(pass("Matching customer is displayed")));
		} else {
			et.log(LogStatus.FAIL, "Matching customer is not displayed",
					et.addScreenCapture(fail("Matching customer is not displayed")));
		}

	}

	@Test()
	public void createSalesInvoice() throws InterruptedException, IOException {

		Utility.logger();
		custDetails = new CustomerDetails_Page();
		create_extent_test("CREATE SALES INVOICE");
		new login().login(Utility.excelRead(2, 0, "CustomerDetails"), Utility.excelRead(2, 1, "CustomerDetails"));
		Thread.sleep(4000);
		Utility.implicitwait();
		Utility.click(custDetails.buttonPlus);
		Thread.sleep(1000);
		Utility.click(custDetails.linkSalesInvoice);
		if ("Standard Invoice".equals(custDetails.headerSalesInvoice.getText())) {
			et.log(LogStatus.PASS, "New sales invoice page is displayed",
					et.addScreenCapture(pass("New sales invoice page is displayed")));
			
			
		} else {
			et.log(LogStatus.FAIL, "New sales invoice page is not displayed",
					et.addScreenCapture(fail("New sales invoice page is not displayed")));
		}
		Thread.sleep(2000);
		Utility.click(custDetails.dropDownCustomer);
		Utility.click(custDetails.optionFirst);
		String dropDownOption = custDetails.optionFirst.getText();
		if (dropDownOption.equals(custDetails.labelSelectedCustomerName.getText())) {
			et.log(LogStatus.PASS, "Customer is selected in customer drop down",
					et.addScreenCapture(pass("Customer is selected in customer drop down")));
		} else {
			et.log(LogStatus.FAIL, "Customer is not selected in customer drop down",
					et.addScreenCapture(fail("Customer is not selected in customer drop down")));
		}
		if ("".equals(custDetails.textBoxRefNo.getText())) {
			et.log(LogStatus.PASS, "Ref no is not reflecting on invoice",
					et.addScreenCapture(pass("Ref no is not reflecting on invoice")));
		} else {
			et.log(LogStatus.FAIL, "Ref no is reflecting on invoice",
					et.addScreenCapture(fail("Ref no is reflecting on invoice")));
		}

	}

}
