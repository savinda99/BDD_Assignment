package com.actitime.qa.testcases;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.UsersPage;
import com.actitime.qa.testdata.TestData;
import org.apache.poi.ss.formula.functions.T;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateUserTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    UsersPage userPage;
    SoftAssert softAssert;
    public CreateUserTest() {
        super();

    }
    @BeforeMethod
    public void setup() throws InterruptedException {
        initialization();
        loginPage = new LoginPage();
        homePage = new HomePage();
        userPage = new UsersPage();
        softAssert = new SoftAssert();
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
    }
    @Test
    public void createUser() throws InterruptedException {
        homePage.clickOnUsersLink();
        userPage.clickOnNewUser();
        userPage.enterNewUserDetails(TestData.FIRST_NAME, TestData.LAST_NAME, TestData.EMAIL, TestData.DEPARTMENT);
        userPage.clickNewUserClose();
        userPage.searchForUser(TestData.FIRST_NAME, TestData.LAST_NAME);
        softAssert.assertTrue(userPage.checkIfSearchedNameIsDisplayed(TestData.FIRST_NAME, TestData.LAST_NAME), "Created user is not displayed");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
