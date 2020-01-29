package com.PS.tests;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;
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
		custDetails =new CustomerDetails_Page();
		create_extent_test("Create customer/ Search Customer");
		new login().login( Utility.excelRead(2, 0,"CustomerDetails"),Utility.excelRead(2, 1, "CustomerDetails"));

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
		Thread.sleep(2000);

		Utility.click(custDetails.paymentTerm);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//li[@name='"+Utility.excelRead(2, 3, "CustomerDetails")+"']")).click();

		Utility.click(custDetails.customerType);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@name='"+Utility.excelRead(2, 4, "CustomerDetails")+"']")).click();

		Utility.enterText(custDetails.companyWebsite, Utility.excelRead(2, 5,"CustomerDetails"));

		Utility.click(custDetails.customerSource);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@name='"+Utility.excelRead(2, 6, "CustomerDetails")+"']")).click();
		
		
		Utility.click(custDetails.rateYourCompany);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@name='"+Utility.excelReadInt(2, 7, "CustomerDetails")+"']")).click();
		
		
		Utility.click(custDetails.Industry);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@name='"+Utility.excelRead(2, 8, "CustomerDetails")+"']")).click();

//		Utility.enterText(custDetails.relationship,Utility.Date());
		custDetails.relationship.click();
		Thread.sleep(2000);
		custDetails.relationship_date.click();
		
		Utility.enterText(custDetails.streetName, Utility.excelRead(2, 9, "CustomerDetails"));
		
		Utility.enterText(custDetails.city, Utility.excelRead(2, 10, "CustomerDetails"));
		
		Utility.enterText(custDetails.zipcode, Utility.excelReadInt(2, 12, "CustomerDetails"));
		
		Utility.JS_Scrolldown(custDetails.save);
		custDetails.country.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li/span[text()='India']")).click();
		Thread.sleep(5000);
		
		
		
		custDetails.state.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@name='"+Utility.excelRead(2, 11, "CustomerDetails")+"']/span[text()='"+Utility.excelRead(2, 11, "CustomerDetails")+"']")).click();
		
		custDetails.sameAsBillingAddress.click();
		Thread.sleep(1000);
		
		custDetails.save.click();
		Thread.sleep(3000);
		custDetails.save1.click();
		Thread.sleep(3000);
		
		


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

//
//		// Search by Customer name
		
		Utility.enterText(custDetails.searchbox, Utility.excelRead(2, 2, "CustomerDetails"));
		boolean custext;
		Thread.sleep(2000);
		try {
		driver.findElement(By.xpath("//a[text()='"+Utility.excelRead(2, 2, "CustomerDetails")+"']"));
		custext=true;
		}
		catch(Exception e)
		{
			custext=false;
		}
		Thread.sleep(1000);
		try {
			Assert.assertEquals(custext, true,"Customer not created");
			System.out.println("Search matched");
			et.log(LogStatus.PASS, "New created customer name found", et.addScreenCapture(fail("New created customer name found")));
		} catch (Exception ex) {
			et.log(LogStatus.FAIL, "New created customer name found", et.addScreenCapture(pass("New created customer name not found")));
			System.out.println("search mismatched ");
		}
	}
	@Test(enabled = false)
	public void UploadCustomer() throws Exception {
		Utility.logger();
		custDetails =new CustomerDetails_Page();
		create_extent_test("Upload Customer");
		new login().login( Utility.excelRead(2, 0,"CustomerDetails"),Utility.excelRead(2, 1, "CustomerDetails"));
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
		
		new Actions(driver).moveToElement(custDetails.NewCustomer).perform();
		Utility.click(custDetails.newCustomerDropdown);
//		
//		Thread.sleep(2000);
//		Utility.click(custDetails.Industry);
//		Thread.sleep(2000);
////		String path=System.getProperty("user.dir") + prop.getProperty("ImportCustomers1");
////		System.out.println(""+path);
//		System.out.println(""	+Utility.excelReadHssf(1, 1,"ImportCustomers1"));
//		
//		driver.findElement(By.xpath("//li/span[text()='"+Utility.excelReadHssf(1, 1, "ImportCustomers1")+"']")).click();
//		
//		Utility.click(custDetails.customerType);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//li/span[text()='"+Utility.excelReadHssf(1, 2, "ImportCustomers1")+"']")).click();
//
//		Utility.click(custDetails.customerSource);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//li/span[text()='"+Utility.excelReadHssf(1, 5, "ImportCustomers1")+"']")).click();
//		
//		Utility.click(custDetails.paymentTerm);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//li/span[text()='"+Utility.excelReadHssf(1, 6, "ImportCustomers1")+"']")).click();
		Thread.sleep(3000);
		Utility.click(custDetails.Nextbtn);
		
		custDetails.chooseFile.sendKeys(System.getProperty("user.dir") + prop.getProperty("ImportCustomers1"));
		Thread.sleep(2000);
		Utility.click(custDetails.Nextbtn2);
		Thread.sleep(2000);
		custDetails.close.click();
		Utility.enterText(custDetails.searchbox, Utility.excelReadHssf(1, 0, "ImportCustomers1"));
		boolean custext;
		Thread.sleep(2000);
		try {
		driver.findElement(By.xpath("//a[text()='"+Utility.excelReadHssf(1, 0, "ImportCustomers1")+"']"));
		custext=true;
		}
		catch(Exception e)
		{
			custext=false;
		}
		Thread.sleep(1000);
		try {
			Assert.assertEquals(custext, true,"Customer not created");
			System.out.println("Search matched");
			et.log(LogStatus.PASS, "New created customer name found", et.addScreenCapture(fail("New created customer name found")));
		} catch (Exception ex) {
			et.log(LogStatus.FAIL, "New created customer name found", et.addScreenCapture(pass("New created customer name not found")));
			System.out.println("search mismatched ");
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

	@Test(enabled = false)
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

	@Test(enabled = true)
	public void customerUpdate() throws InterruptedException, IOException {

		Utility.logger();
		custDetails = new CustomerDetails_Page();
		create_extent_test("Customer Update");
		new login().login(Utility.excelRead(2, 0, "CustomerDetails"), Utility.excelRead(2, 1, "CustomerDetails"));
		Thread.sleep(4000);
		Utility.click(custDetails.CustomersMenuBtn);
		Thread.sleep(1000);
		Utility.implicitwait();
		Utility.click(custDetails.update_customer_menu_button_for_first_row);
		Thread.sleep(2000);
		Utility.click(custDetails.edit_cust_option);
		Thread.sleep(2000);
	
		String newname=Utility.updatecompname(custDetails.companyName.getAttribute("value"));
		custDetails.companyName.clear();
		custDetails.companyName.sendKeys(newname);
		Utility.JS_Scrolldown(custDetails.save);
		Thread.sleep(2000);
		custDetails.save.click();
		Thread.sleep(2000);
		custDetails.save1.click();
		

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


}
