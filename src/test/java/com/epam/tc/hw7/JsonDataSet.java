package com.epam.tc.hw7;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

import com.jdiai.tools.DataClass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonDataSet {

    //@JsonProperty("summary")
    private List<String> summary;
    //@JsonProperty("elements")
    private List<String> elements;
    //@JsonProperty("color")
    private String color;
    //@JsonProperty("metals")
    private String metals;
    //@JsonProperty("vegetables")
    private List<String> vegetables;

    public JsonDataSet() {
    }

    public JsonDataSet(List<String> summary, List<String> elements, String color, String metals, List<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }

}
