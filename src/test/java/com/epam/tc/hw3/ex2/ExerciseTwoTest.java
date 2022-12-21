package com.epam.tc.hw3.ex2;

import com.epam.tc.hw3.AbstractChromeTest;
import com.epam.tc.hw3.page.DifferentElementsPage;
import com.epam.tc.hw3.page.DifferentElementsPageMainContainer;
import com.epam.tc.hw3.page.IndexPage;
import org.testng.annotations.Test;

public class ExerciseTwoTest extends AbstractChromeTest {

    private String pageTitleIndexPage = "Home Page";
    private String userName = "Roman";
    private String userPassword = "Jdi1234";
    private String correctUserName = "ROMAN IOVLEV";

    @Test
    public void exerciseTwo() {

        //Assert Browser title
        //Perform login, Assert Username is loggined
        IndexPage indexPage = new IndexPage(driver);
        indexPage.verifyTitle(driver, pageTitleIndexPage)
                .loginUser(driver, userName, userPassword)
                .searchForUserNameElement()
                .verifyLogin(correctUserName);

        //Open through the header menu Service -> Different Elements Page
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
        differentElementsPage.openDifferentElementsPage(driver, userName, userPassword);

        //select Water and Wind checkboxes
        //select Selen radio button
        DifferentElementsPageMainContainer diffElemPageMainContainer = new DifferentElementsPageMainContainer(driver);
        diffElemPageMainContainer.selectCheckboxes()
                .selectRadiobuttons()
                .selectColor();



        /*
        //select Yellow color in dropdown
        Select color = new Select(driver.findElement(By.cssSelector("div.colors>.uui-form-element")));
        color.selectByVisibleText("Yellow");


        //turn boolean values of checkboxes into char sequences for further check in assertions
        CharSequence water = null;
        CharSequence wind = null;
        for (WebElement opt : checkboxes) {
            if (opt.getText().equals("Water")) {
                water = String.valueOf(opt.findElement(By.cssSelector("input")).isSelected());
            } else if (opt.getText().equals("Wind")) {
                wind = String.valueOf(opt.findElement(By.cssSelector("input")).isSelected());
            }
        }

        //turn boolean value of radio button into char sequence for further check in assertions
        CharSequence metal = null;
        for (WebElement opt : radio) {
            if (opt.findElement(By.cssSelector("input")).isSelected()) {
                metal = opt.getText();
            }
        }

        //turn color option into char sequence for further check in assertions
        WebElement o = color.getFirstSelectedOption();
        CharSequence colorOption = o.getText();

        //find log entries and turn them into list of strings for further checks in assertions
        List<WebElement> logs = driver.findElements(By.cssSelector(".panel-body-list.logs>li"));
        List<String> logList = new ArrayList();
        for (WebElement e : logs) {
            logList.add(String.valueOf(e.getText()));
        }

        //check that each element has an individual log
        //check that log values correspond the values of checkboxes, radio button, dropdown
        int individualLogs = 0;
        for (String s : logList) {
            if (s.contains("Water")) {
                individualLogs++;
                softly.assertThat(s.contains(water))
                        .as("Log value for Water checkbox des not match it's value").isTrue();
            } else if (s.contains("Wind")) {
                individualLogs++;
                softly.assertThat(s.contains(wind)).as("Log value for Wind checkbox des not match it's value").isTrue();
            } else if (s.contains("metal")) {
                individualLogs++;
                softly.assertThat(s.contains(metal)).as("Log value for Metal radio des not match it's value").isTrue();
            } else if (s.contains("Color")) {
                individualLogs++;
                softly.assertThat(s.contains(colorOption))
                        .as("Log value for Selen radio des not match it's value").isTrue();
            }
        }
        softly.assertThat(individualLogs == 4).as("Lack of log entries").isTrue();

        softly.assertAll();*/

    }

}
