package com.epam.tc.hw7;

import java.util.LinkedHashMap;
import java.util.Map;
import org.testng.annotations.DataProvider;

public class DataProviderClass {

    LinkedHashMap<String, JsonDataSet> map = JsonParserFile.fileToMap();

    Object[][] jsonObject;

    @DataProvider(name = "JsonData")
    public Object[][] getJsonData() {

        jsonObject = new Object[map.size()][1];
        int i = 0;
        for (Map.Entry<String, JsonDataSet> entry : map.entrySet()) {
            jsonObject[i][0] = entry.getValue();
            i++;
        }

        return jsonObject;
    }

}