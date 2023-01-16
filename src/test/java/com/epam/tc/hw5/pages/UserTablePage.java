package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.DriverSetup;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserTablePage extends DriverSetup {

    private WebDriver driver;

    @FindBy(css = "td>select")
    private List<WebElement> listOfUserTypeDropdowns;

    @FindBy(css = "td>a[href]")
    private List<WebElement> listOfUserNames;

    @FindBy(css = ".user-descr>span")
    private List<WebElement> listOfDescriptionsUnderImages;

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> listOfCheckboxes;

    @FindBy(xpath = "//tbody/tr/td[1]")
    private List<WebElement> listOfUserNumbers;

    @FindBy(xpath = "//a[text()='Roman']/../../td/select/option")
    private List<WebElement> listOfDropDownOptionsUserRoman;

    public UserTablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getUserTypeDropdownsQuantity() {
        int dropdownsQuantity = listOfUserTypeDropdowns.size();
        return dropdownsQuantity;
    }

    public int getUsernamesQuantity() {
        int usernamesQuantity = listOfUserNames.size();
        return usernamesQuantity;
    }

    public int getDescriptionsUnderImagesQuantity() {
        int descriptionsQuantity = listOfDescriptionsUnderImages.size();
        return descriptionsQuantity;
    }

    public int getCheckboxesQuantity() {
        int checkboxesQuantity = listOfCheckboxes.size();
        return checkboxesQuantity;
    }

    public List<String> getUserNumbers() {
        List<String> userNumbersList = new ArrayList<>();;
        for (WebElement userNumber : listOfUserNumbers) {
            userNumbersList.add(userNumber.getText());
        }
        return userNumbersList;
    }

    public List<String> getUserNames() {
        List<String> usernamesList = new ArrayList<>();
        for (WebElement username : listOfUserNames) {
            usernamesList.add(username.getText());
        }
        return usernamesList;
    }

    public List<String> getDescriptions() {
        List<String> descriptionList = new ArrayList<>();
        for (WebElement description : listOfDescriptionsUnderImages) {
            descriptionList.add(description.getText().replaceAll("\\r\\n|\\r|\\n", " "));
        }
        return descriptionList;
    }

    public List<WebElement> getDropdownOptions() {
        return listOfDropDownOptionsUserRoman;
    }

    public List<String> getCheckboxIdList() {
        List<String> checkboxIdList = new ArrayList<>();
        for (WebElement element : listOfCheckboxes) {
            checkboxIdList.add(element.getAttribute("id"));
        }
        return checkboxIdList;
    }

}
