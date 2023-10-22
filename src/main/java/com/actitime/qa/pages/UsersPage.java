package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import functions.PageFunctions;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage extends TestBase  {
    public UsersPage() {
    }
    PageFunctions pageFunctions = new PageFunctions();
    Logger log = Logger.getLogger(HomePage.class);
    private By newUser = By.xpath("//div[@class='components_button_label' and contains(text(), 'New User')]");
    private By inputFirstName = By.id("createUserPanel_firstNameField");
    private By inputMI = By.id("createUserPanel_middleNameField");
    private By inputLastName = By.id("createUserPanel_lastNameField");
    private By inputEmail = By.id("createUserPanel_emailField");
    private By departmentButton = By.xpath("//div[@class='simpleListMenuButton components_userGroupSelectorMenu emptyList notEmpty']");
    private String inputDepartment = "//div[@class='itemsContainer']/div[@class='item' and contains(text(), '@department')]";
    private By saveNewUser = By.xpath("//div[@class='components_button_label' and contains(text(), 'Save & Send Invitation')]");
    private By newUserCloseButton = By.xpath("(//div[@class='closeLink']/span)[1]");
    private By userSearch = By.xpath("//div[@class='wordsFilter']");
    private By inputUserSearch = By.xpath("//div[@class='inputPlaceholder animShowWordsField active']/input[@type='text']");
    private String searchedName = "//span[@class='highlightToken' and contains(text(), '@name')]";



    public void clickOnNewUser() {
        pageFunctions.waitAndClickOnElement(newUser);
    }

    public void enterNewUserDetails(String firstName, String lastName, String email, String department) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterDepartment(department);
        clickSaveNewUser();
    }
    public void searchForUser(String firstName, String lastName)  {
        pageFunctions.waitAndClickOnElement(userSearch);
        pageFunctions.sendKeys(inputUserSearch, firstName + " " + lastName);
        pageFunctions.sendKeys(inputUserSearch, Keys.ENTER);
    }
    public void enterFirstName(String firstName) {
        pageFunctions.sendKeys(inputFirstName, firstName);
    }
    public void enterMiddleName(String middleName) {
        pageFunctions.sendKeys(inputMI, middleName);
    }
    public void enterLastName(String lastName) {
        pageFunctions.sendKeys(inputLastName, lastName);
    }
    public void enterEmail(String email) {
        pageFunctions.sendKeys(inputEmail, email);
    }
    public void enterDepartment(String department) {
        pageFunctions.waitAndClickOnElement(departmentButton);
        pageFunctions.waitAndClickOnElement(By.xpath(inputDepartment.replace("@department", department)));
    }
    public void clickSaveNewUser() {
        pageFunctions.waitAndClickOnElement(saveNewUser);
    }
    public void clickNewUserClose() {
        pageFunctions.waitAndClickOnElement(newUserCloseButton);
    }
    public boolean checkIfSearchedNameIsDisplayed(String firstName, String lastName) {
        return (pageFunctions.elementIsDisplayed(By.xpath(searchedName.replace("@name", firstName)))
                && pageFunctions.elementIsDisplayed(By.xpath(searchedName.replace("@name", lastName))));
    }
}
