package com.epam.tc.hw7.entities;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetalColorEntity {

    private List<String> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public MetalColorEntity() {
    }

    public MetalColorEntity(List<String> summary, List<String> elements,
                            String color, String metals, List<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public String getCalculatedSummary() {
        int oddNumber = Integer.valueOf(getSummary().get(0));
        int evenNumber = Integer.valueOf(getSummary().get(1));
        return Integer.toString(oddNumber + evenNumber);
    }

}
