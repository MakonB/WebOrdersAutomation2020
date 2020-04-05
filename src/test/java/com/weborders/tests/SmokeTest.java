package com.weborders.tests;

import com.weborders.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SmokeTest extends AbstractBaseTest {


    @Test(dataProvider = "smokeTestData")
    public void verifyAllProductsPage(String component, String  expSubTitle){

        extentTest = extentReports.createTest("Verify " + component);
        LoginPage loginPage = new LoginPage();
        loginPage.Login();
        loginPage.navigateTo(component);
        Assert.assertEquals(loginPage.getPageSubtitle(),expSubTitle);
        extentTest.pass(component + " verified!");

    }



    @DataProvider
    public Object[][] smokeTestData(){
        return new Object[][]{
                {"View all orders", "List of All Orders"},
                {"View all products", "List of Products"},
                {"Order", "Order"}
        };
    }
}
