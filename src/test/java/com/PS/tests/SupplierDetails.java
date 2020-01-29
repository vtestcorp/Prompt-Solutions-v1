package com.PS.tests;

import java.io.IOException;
import java.net.URISyntaxException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.PS.base.Base;
import com.PS.pages.CustomerDetails_Page;
import com.PS.pages.SupplierDetails_Page;
import com.PS.util.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class SupplierDetails extends Base {
	SupplierDetails_Page suppDetails;
	public String totalSuppCount;
	SoftAssert sa = new SoftAssert();

	@BeforeSuite
	public void createReport() {
		create_ext_report("PS " + Utility.Date_Time().toString());

	}

	@Parameters({ "Browser" })
	@BeforeMethod
	public void setup(String Browser) throws URISyntaxException, IOException, InterruptedException {

		driverInitilization(Browser);
		suppDetails = new SupplierDetails_Page();

	/*	Utility.enterText(suppDetails.email, Utility.excelRead(2, 0, "SupplierDetails"));
		Utility.enterText(suppDetails.password, Utility.excelRead(2, 1, "SupplierDetails"));
		Utility.implicitwait();
		Utility.click(suppDetails.LoginBtn);
		Utility.implicitwait();*/
		}

	@Test(enabled = false)
	public void Test() {
		Utility.logger();
		System.out.println("crossed");
	}

	@Test(priority=1,enabled = true)
	public void CreateSupplier() throws Throwable {
	//try {
	/*	create_extent_test("Create suppiler Details");
	
		Utility.click(suppDetails.SupplierMenuBtn);
		Thread.sleep(1000);
	
		Utility.JS_Scrolldown(suppDetails.totalCustomerCount);
		if (suppDetails.totalCustomerCount.isDisplayed())
		{
			totalSuppCount = suppDetails.totalCustomerCount.getText();
			System.out.println("Expected " + totalSuppCount);
			System.out.println("Crossed1");
		} 
		else {
			System.out.println("Not Displayed");
		}
		Utility.JS_ScrollUP();
	
		Utility.ActionClick(suppDetails.NewSupplier);
		System.out.println("Crossed");
		
		Utility.ExcelReadAndWrite(1, 2);
		Utility.implicitwait();
		Utility.enterText(suppDetails.SupplierName, Utility.excelRead(1, 2, "SupplierDetails"));
	
		Utility.click(suppDetails.Industry);
		Utility.enterText(suppDetails.IndustrySearch, Utility.excelRead(1, 3, "SupplierDetails"));
		Utility.click(suppDetails.IndustrySearchClick);
	
		Utility.click(suppDetails.SupplierType);
		Utility.enterText(suppDetails.SupplierTypeSearch, Utility.excelRead(1, 4, "SupplierDetails"));
		Utility.click(suppDetails.SupplierTypeSearchClick);
		
		Utility.click(suppDetails.SupplierSource);
		Utility.enterText(suppDetails.SupplierSourceSearch, Utility.excelRead(1, 5, "SupplierDetails"));
		Utility.click(suppDetails.SupplierSourceSearchClick);
		
		Utility.click(suppDetails.PaymentTerm);
		Utility.enterText(suppDetails.PaymentTermSearch, Utility.excelRead(1, 6, "SupplierDetails"));
		Utility.click(suppDetails.PaymentTermSearchClick);
	
		Utility.enterText(suppDetails.companyWebsite, Utility.excelRead(1, 7, "SupplierDetails"));	
		
		Utility.enterText(suppDetails.StreetAddress, Utility.excelRead(1, 8, "SupplierDetails"));
		Utility.enterText(suppDetails.city, Utility.excelRead(1, 9, "SupplierDetails"));
		
		Utility.enterText(suppDetails.zipcode, Utility.excelRead(1, 10, "SupplierDetails"));
	
		Thread.sleep(1000);
		
	//	if(driver.getPageSource().contains("name='billingStateId'")){
	//		Utility.ActionClick(custDetails.state);
	//		Utility.enterText(custDetails.state, Utility.excelRead(1, 11, "SupplierDetails"));
	//		}
	//	else{
	//		Utility.ActionClick(custDetails.stateName);
	//		Utility.enterText(custDetails.stateNameSearch, Utility.excelRead(1, 11, "SupplierDetails"));
	//		Utility.ActionClick(custDetails.stateNameSearchClick);
	//		}
		
		Utility.implicitwait();
		Utility.ActionClick(suppDetails.sameAsBillingAddress);
	
		if(suppDetails.zipcode.isDisplayed())
		{
			Utility.enterText(suppDetails.zipcode, Utility.excelRead(1, 12, "SupplierDetails"));
		et.log(LogStatus.PASS, "Supplier Details with Address information Entered", et.addScreenCapture(pass("Supplier Details with Address information Entered")));
		
		} else {
			et.log(LogStatus.FAIL, "Supplier Details with Address information not Entered", et.addScreenCapture(fail("Supplier Details with Address information not Entered")));
		}
		
		Utility.click(suppDetails.contactsubmenu);
	
		Utility.click(suppDetails.title);
		Utility.enterText(suppDetails.titleSearch, Utility.excelRead(1, 13, "SupplierDetails"));
		Utility.click(suppDetails.titleSearchClick);
	
		Utility.enterText(suppDetails.firstname, Utility.excelRead(1, 14, "SupplierDetails"));
		Utility.enterText(suppDetails.lastname, Utility.excelRead(1, 15, "SupplierDetails"));
		Utility.enterText(suppDetails.phonename, Utility.excelReadInt(1, 16, "SupplierDetails"));
		
		if(suppDetails.customerEmail.isDisplayed())
		{
			Utility.enterText(suppDetails.customerEmail, Utility.excelRead(1, 17, "SupplierDetails"));
		et.log(LogStatus.PASS, "Supplier Details with contact information Entered", et.addScreenCapture(pass("Supplier Details with contact information Entered")));
		
		} else {
			et.log(LogStatus.FAIL, "Supplier Details with contact information not Entered", et.addScreenCapture(fail("Supplier Details with contact information not Entered")));
		}
		
		Utility.click(suppDetails.taxInfoSubmenu);
		Utility.click(suppDetails.GSTMech);
		Utility.enterText(suppDetails.GSTMechSearch, Utility.excelRead(1, 18, "SupplierDetails"));
		Utility.click(suppDetails.GSTMechSearchClick);
	
		Utility.enterText(suppDetails.GSTIN, Utility.excelReadInt(1, 19, "SupplierDetails"));
		
		if(suppDetails.PAN.isDisplayed())
		{
		Utility.enterText(suppDetails.PAN, Utility.excelReadInt(1, 20, "SupplierDetails"));
		et.log(LogStatus.PASS, "Supplier Details with Tax information Entered", et.addScreenCapture(pass("Supplier Details with tax information Entered")));
		
		} else {
			et.log(LogStatus.FAIL, "Supplier Details with Tax information not Entered", et.addScreenCapture(fail("Supplier Details with tax information not Entered")));
		}
	
		Utility.click(suppDetails.LogoSubmenu);
		suppDetails.selectLogo.click();
		
		Thread.sleep(3000);
		// below line execute the AutoIT script .
		System.out.println(System.getProperty("user.dir") + prop.getProperty("LogoFileUpload"));
		String UploadFileexe = System.getProperty("user.dir") + prop.getProperty("LogoFileUpload");
	    Runtime.getRuntime().exec(UploadFileexe);
	  
		Thread.sleep(5000);
		Utility.click(suppDetails.Capture);
		
		Thread.sleep(2000);
		if(suppDetails.save.isDisplayed())
		{
		et.log(LogStatus.PASS, "Company logo is selected", et.addScreenCapture(pass("Company logo is selected")));
		Utility.click(suppDetails.save);
		}
		else {
			et.log(LogStatus.FAIL, "Company logo is not selected", et.addScreenCapture(fail("Company logo is not selected")));
		}
		if (suppDetails.popupText.isDisplayed()) {
			et.log(LogStatus.PASS, "Confirmation pop up displayed", et.addScreenCapture(pass("Confirmation pop up displayed")));
			Utility.click(suppDetails.ConfirmationYES);
		} 
		else {
			et.log(LogStatus.FAIL, "Confirmation pop up is not displayed", et.addScreenCapture(fail("Confirmation pop up is not displayed")));
	
		}
	
		String totalCustCountCurrent = suppDetails.totalCustomerCount.getText();
		System.out.println("Actual" + totalCustCountCurrent);
		Thread.sleep(1000);
		try {
			
			Assert.assertNotEquals(totalSuppCount, totalCustCountCurrent);
			System.out.println("count matched");
			et.log(LogStatus.PASS, "New Supplier Created and count got increased",
					et.addScreenCapture(pass("New Supplier is Created and count got increased")));
		} 
		catch (Exception ex) 
		{
			System.out.println("count mismatched ");
			et.log(LogStatus.FAIL, "Supplier Count hasn't increased",
					et.addScreenCapture(fail("Supplier Count hasn't increased")));
		}

		Thread.sleep(1000);

		// Search by Customer name Customer name
		Utility.enterText(suppDetails.searchbox, Utility.excelRead(1, 2, "SupplierDetails"));
	
		String expected = Utility.excelRead(1, 2, "SupplierDetails");
		String actsupptext = suppDetails.searchedCust.getText();
		System.out.println(actsupptext);
		Thread.sleep(1000);
		try
		{
			Assert.assertEquals(actsupptext, expected);
			System.out.println("Search matched");
			et.log(LogStatus.PASS, "New created Supplier name found", et.addScreenCapture(fail("New created Supplier name found")));
		} catch (Exception ex) 
		{
			et.log(LogStatus.FAIL, "New created Supplier name found", et.addScreenCapture(pass("New created Supplier name not found")));
			System.out.println("search mismatched ");
		}
	*//*
		// update Customer details
		Thread.sleep(1000);
		Utility.click(suppDetails.hamburgerbtn);
		Utility.click(suppDetails.editCustomer);
		Thread.sleep(1000);
		if (suppDetails.CustomerTextVerify.isDisplayed()) {
			et.log(LogStatus.PASS, "Customer Information pop up is loaded",
					et.addScreenCapture(pass("Customer Information pop up is loaded")));
		} 
		else {
			et.log(LogStatus.FAIL, "Customer Information pop up is not loaded",
					et.addScreenCapture(pass("Customer Information pop up is not loaded")));
		}
		Utility.ExcelReadAndWrite(1, 2);
		Utility.enterText(custDetails.companyName, Utility.excelRead(1, 2));
		String updatedCust = Utility.excelRead(1, 2);
		Utility.click(custDetails.save);
		if (custDetails.popupText.isDisplayed()) 
		{
			et.log(LogStatus.PASS, "Confirmation pop up displayed", et.addScreenCapture(pass("Confirmation pop up displayed")));
			Utility.click(custDetails.ConfirmationYES);
		} 
		else {
			et.log(LogStatus.FAIL, "Confirmation pop up is not displayed", et.addScreenCapture(fail("Confirmation pop up is not displayed")));
	
		}
		Thread.sleep(3000);
		Utility.enterText(custDetails.searchbox, Utility.excelRead(1, 2));
		System.out.println(updatedCust);
		System.out.println("Expected" + Utility.excelRead(1, 2));
		String updatedCustName = custDetails.searchedCust.getText();
	
		System.out.println(updatedCustName);
		Thread.sleep(1000);
		try 
		{
			Assert.assertEquals(updatedCust, updatedCustName);
			System.out.println("Updated customer name is displayed");
			et.log(LogStatus.PASS, "Updated customer name is displayed",
					et.addScreenCapture(fail("Updated customer name is displayed")));
		} 
		catch (Exception ex) 
		{
			et.log(LogStatus.FAIL, "Updated customer name is not displayed",
					et.addScreenCapture(pass("Updated customer name is not displayed")));
			System.out.println("Search Mismatched");
		}
	
		System.out.println("Passed");
		sa.assertAll();
		*//*
	//} 
//	catch(Exception ex)
//	{
//		et.log(LogStatus.ERROR, ex.getMessage());
//	}*/
}
	


}
