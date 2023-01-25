package com.epam.tc.hw7;

import com.epam.tc.hw7.entities.MetalColorEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonParserFile {

    public LinkedHashMap<String, MetalColorEntity> fileToMap() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        FileReader reader = new FileReader("src/test/resources/JDI_ex8_metalsColorsDataSet.json");

        LinkedHashMap<String, MetalColorEntity> map = objectMapper
                .readValue(reader, new TypeReference<LinkedHashMap<String, MetalColorEntity>>() {
                    });

        reader.close();

        return  map;
    }

}
