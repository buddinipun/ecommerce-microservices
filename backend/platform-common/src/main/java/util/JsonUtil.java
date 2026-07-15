package util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.experimental.UtilityClass;


@UtilityClass
public class JsonUtil {


    private final ObjectMapper OBJECT_MAPPER =
            new ObjectMapper();



    public String toJson(Object object) {


        if(object == null){
            return null;
        }


        try {

            return OBJECT_MAPPER.writeValueAsString(object);


        } catch (JsonProcessingException exception) {

            throw new IllegalArgumentException(
                    "Unable to convert object to JSON",
                    exception
            );

        }

    }



    public <T> T fromJson(
            String json,
            Class<T> clazz
    ) {


        if(json == null || clazz == null){
            return null;
        }


        try {

            return OBJECT_MAPPER.readValue(
                    json,
                    clazz
            );


        } catch (JsonProcessingException exception) {

            throw new IllegalArgumentException(
                    "Unable to parse JSON",
                    exception
            );

        }

    }

}