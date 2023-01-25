package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.tc.hw7.entities.MetalColorEntity;
import com.epam.tc.hw7.forms.MetalColorsForm;
import com.epam.tc.hw7.pages.components.ResultSection;
import org.assertj.core.api.SoftAssertions;

@Url("/metals-colors.html")
public class MetalColorsPage extends WebPage {

    ResultSection resultSection = new ResultSection();

    private MetalColorsForm metalColorsForm;

    public void fillForm(MetalColorEntity metalColorEntity) {
        metalColorsForm.fill(metalColorEntity);
    }

    public void clickSubmit() {
        metalColorsForm.getSubmitButton().click();
    }

    public void checkResultSection(MetalColorEntity metalColorEntity) {
        String actualResultText = String.join(", ", resultSection.getActualResultSectionData());

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(actualResultText)
                .as("Inconsistency in Summary").contains(metalColorEntity.getCalculatedSummary());
        metalColorEntity.getElements().forEach(element ->
                softly.assertThat(actualResultText)
                        .as("Inconsistency in Elements").contains(element));
        softly.assertThat(actualResultText)
                .as("Inconsistency in Color").contains(metalColorEntity.getColor());
        softly.assertThat(actualResultText)
                .as("Inconsistency in Metals").contains(metalColorEntity.getMetals());
        metalColorEntity.getVegetables().forEach(vegetable ->
                softly.assertThat(actualResultText)
                        .as("Inconsistency in vegetables").contains(vegetable));

        softly.assertAll();
    }

}
