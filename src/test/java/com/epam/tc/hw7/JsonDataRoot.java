/*
package com.epam.tc.hw7;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonDataRoot {

    @SerializedName("data_1")
    private Object dataSetName;
    private JsonDataSet jsonDataSet;

    List<String> summary = jsonDataSet.getSummary();
    List<String> elements = jsonDataSet.getElements();
    String color = jsonDataSet.getColor();
    String metals = jsonDataSet.getMetals();
    List<String> vegetables = jsonDataSet.getVegetables();

    public JsonDataRoot(Object data_1, JsonDataSet jsonDataSet) {
        this.dataSetName = data_1;
        this.jsonDataSet = jsonDataSet;
    }


    @Override
    public String toString() {
        return "DataSet{" + "dataSetName=" + dataSetName
//                + " summary=" + summary
//                + " elements=" + elements
//                + " color=" + color
//                + " metals=" + metals
//                + " vegetables=" + vegetables
                + "}";
    }

}
*/
