package com.epam.tc.hw7;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.epam.tc.hw7.entities.MetalColorEntity;
import org.testng.annotations.DataProvider;

public class DataProviderClass {

    LinkedHashMap<String, MetalColorEntity> map = JsonParserFile.fileToMap();

    Object[][] jsonObject;

    @DataProvider(name = "JsonData")
    public Object[][] getJsonData() throws IOException {

        jsonObject = new Object[map.size()][1];
        int i = 0;
        for (Map.Entry<String, MetalColorEntity> entry : map.entrySet()) {
            jsonObject[i][0] = entry.getValue();
            i++;
        }

        return jsonObject;
    }

}