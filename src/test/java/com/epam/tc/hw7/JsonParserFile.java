package com.epam.tc.hw7;

import com.epam.tc.hw7.entities.MetalColorEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonParserFile {

    public LinkedHashMap fileToMap() {

        //Gson gson = new Gson();
        ObjectMapper objectMapper = new ObjectMapper();

        try(FileReader reader = new FileReader("src/test/resources/JDI_ex8_metalsColorsDataSet.json")) {

            LinkedHashMap<String, MetalColorEntity> map = objectMapper.readValue(reader, new TypeReference<LinkedHashMap<String, MetalColorEntity>>() {
            });
            return  map;


            //Map<String, JsonDataSet> map = gson.fromJson(reader, Map.class);



            /*for (Map.Entry<String, JsonDataSet> entry : map.entrySet()) {
                System.out.println(entry.getValue());
            }*/


        } catch (IOException exception) {
            System.out.println("JSON parsing error: " + exception);
        }
        return null;

    }

}
