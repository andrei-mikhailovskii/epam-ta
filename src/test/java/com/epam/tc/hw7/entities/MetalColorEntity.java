package com.epam.tc.hw7.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetalColorEntity {

    //@JsonProperty("summary")
    private List<Integer> summary;
    //@JsonProperty("elements")
    private List<String> elements;
    //@JsonProperty("color")
    private String color;
    //@JsonProperty("metals")
    private String metals;
    //@JsonProperty("vegetables")
    private List<String> vegetables;

    public MetalColorEntity(List<Integer> summary, List<String> elements,
                            String color, String metals, List<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    /*@Override
    public String toString() {
        return "DataSet{" + "summary=" + summary
                + "elements=" + elements
                + "color=" + color
                + "metals=" + metals
                + "vegetables=" + vegetables + "}";
    }*/

}
