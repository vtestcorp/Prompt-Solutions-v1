package com.PS.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.PS.base.Base;
import com.PS.pages.CustomerDetails_Page;
import com.relevantcodes.extentreports.LogStatus;

public class Utility extends Base {

	public static Date date;
	public static String text;
	public static String intText;
	public static JavascriptExecutor js;
	public static Actions act;
	public static Select drpCountry;
	

	public static String Date_Time() {
		date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String dateText = sdf.format(date);

		return dateText;
	}

	public static void click(WebElement element) {
		element.click();
	}
	
	public static void ActionClick(WebElement element) {
		act = new Actions(driver);
		Action seriesOfActions = act.moveToElement(element).click().build();
		seriesOfActions.perform();
	}

	public static void scrollToElement_N_click(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		element.click();
	}

	public static void JSClick(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		element.click();
		System.out.println("Clicked");
	}

	public static void JS_Scrolldown(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static void JS_ScrollUP()
	{
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-500)");
	}
	
	public static void JS_ScrollDown()
	{
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");	
	}

	public static void enterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public static void enter(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
		element.click();
	}
	
	public static String getURL()
	{
		String currentURL = driver.getCurrentUrl();
		
		return currentURL;
	}

	public static void implicitwait() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}
	
	public static void wait(WebElement element) {
		WebDriverWait wt = new WebDriverWait(driver, 1000);
		wt.until(ExpectedConditions.visibilityOf(element));
	}

	public static void mouseHover(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}

	public static void selectByText(WebElement ele, String text) {
		Select dpdwn = new Select(ele);
		dpdwn.selectByVisibleText(text);
	}

	public static void selectByValue(WebElement ele, String value) {
		Select dpdwn = new Select(ele);
		dpdwn.selectByValue(value);
	}

	public static void selectByIndex(WebElement ele, String index) {
		Select dpdwn = new Select(ele);
		dpdwn.selectByValue(index);
	}

	public static void wait_N_click(WebElement element) {
		WebDriverWait wt = new WebDriverWait(driver, 10);
		wt.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public static void closeCurrentBrowser() {
		driver.close();
	}

	public static void closeAllOpenBrowser() {
		driver.quit();
	}
	
	public static void selectDropdownValue(WebElement ele, String CountryName)
	{
		drpCountry = new Select(ele);
		drpCountry.selectByVisibleText(CountryName);
	}
	
	public static String excelRead(int row, int cell, String File) {
		try {
			File src = new File(prop.getProperty(File));
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh1 = wb.getSheetAt(0);
			text = sh1.getRow(row).getCell(cell).getStringCellValue();
			//System.out.println(text);
			fis.close();
		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
		return text;
	}

	public static String excelReadInt(int row, int cell, String File) {
		try {
			File src = new File(prop.getProperty(File));
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh1 = wb.getSheetAt(0);
			int x = (int) sh1.getRow(row).getCell(cell).getNumericCellValue();
			intText = String.valueOf(x);
			fis.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return intText;
	}

	public static void ExcelReadAndWrite(int row, int cell) {
		try {
			File src = new File(prop.getProperty("CustomerDetails"));
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh1 = wb.getSheetAt(0);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String datetext = dateFormat.format(date);
			String q = sh1.getRow(row).getCell(cell).getStringCellValue().substring(0, 6);
			String s1 = q + datetext;
			fis.close();

			File src1 = new File(prop.getProperty("CustomerDetails"));
			FileInputStream fis1 = new FileInputStream(src1);
			XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
			XSSFSheet sh12 = wb1.getSheetAt(0);
			sh12.getRow(row).createCell(cell).setCellValue(s1);

			FileOutputStream fout = new FileOutputStream(new File(prop.getProperty("CustomerDetails")));

			wb1.write(fout);

			fout.close();

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

	}

	public static void ExcelWrite(int row, int cell, String text) {
		try {
			File src1 = new File(prop.getProperty("CustomerDetails"));
			FileInputStream fis1 = new FileInputStream(src1);
			XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
			XSSFSheet sh12 = wb1.getSheetAt(0);
			sh12.getRow(row).createCell(cell).setCellValue(text);

			FileOutputStream fout = new FileOutputStream(new File(prop.getProperty("CustomerDetails")));

			wb1.write(fout);

			fout.close();

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
	}
	public static  String updatecompname(String oldName) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String datetext = dateFormat.format(date);
		
		String q = oldName.substring(0, 6);
		String s1 = q + datetext;
		return s1;
	}

}
