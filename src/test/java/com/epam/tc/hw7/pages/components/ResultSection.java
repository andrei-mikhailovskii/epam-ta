package com.epam.tc.hw7.pages.components;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import java.util.ArrayList;

public class ResultSection {

    @FindBy(css = ".results>li")
    private WebList resultData = new WebList();

    public ArrayList<String> getActualResultSectionData() {
        ArrayList<String> actualResultSectionData = new ArrayList<>();
        resultData.forEach(resultString -> actualResultSectionData.add(resultString.getText()));
        return actualResultSectionData;
    }

}
