package com.epam.tc.hw7;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonDataSet {

    private List<String> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public JsonDataSet() {
    }

    public JsonDataSet(List<String> summary, List<String> elements,
                       String color, String metals, List<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }

}
