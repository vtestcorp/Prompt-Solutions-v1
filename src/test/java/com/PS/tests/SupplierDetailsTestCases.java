package com.PS.tests;

import com.PS.base.Base;
import com.PS.pages.CustomerDetails_Page;
import com.PS.pages.SupplierDetails_Page;
import com.PS.pages.login;
import com.PS.util.Utility;
import com.TestNG.listener.CustomListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class SupplierDetailsTestCases extends Base {
    SupplierDetails_Page suppDetails;
    ;
    public String totalCustCount;


    @Test(enabled = true)
    public void CreateSupplier() throws Exception {
        Utility.logger();
        suppDetails = new SupplierDetails_Page();
        create_extent_test("Create customer");
        new login().login(Utility.excelRead(2, 0, "CustomerDetails"), Utility.excelRead(2, 1, "CustomerDetails"));
        Thread.sleep(4000);
        suppDetails.createSupplier();
    }

}
