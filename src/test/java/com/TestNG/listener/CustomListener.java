package com.TestNG.listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.PS.base.Base;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListener extends Base implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		try {
			
			et.log(LogStatus.PASS, "Test case passed", et.addScreenCapture(pass(result.getMethod().getMethodName())));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestFailure(ITestResult result) {

		System.out.println("Test Failed");
		try {
			fail(result.getMethod().getMethodName());
			et.log(LogStatus.FAIL, "Test case failed", et.addScreenCapture(fail(result.getMethod().getMethodName())));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
