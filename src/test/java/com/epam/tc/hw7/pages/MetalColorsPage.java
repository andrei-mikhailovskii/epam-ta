package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.tc.hw7.entities.MetalColorEntity;
import com.epam.tc.hw7.forms.MetalColorsForm;

@Url("/metals-colors.html")
public class MetalColorsPage extends WebPage {

    private MetalColorsForm metalColorsForm;

    public void fillForm(MetalColorEntity metalColorEntity) {
        metalColorsForm.fill(metalColorEntity);
    }

}
