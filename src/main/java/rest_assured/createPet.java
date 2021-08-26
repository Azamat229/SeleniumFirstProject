package rest_assured;


import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class createPet {
    @Test
    public void testPost() {
        JSONObject request = new JSONObject();
        request.put("id", 5);

        Map<String, Object> categorySet = new HashMap<>();
        categorySet.put("id", 7);
        categorySet.put("name", "Chubakabra");

        request.put("category", categorySet);
        request.put("name", "San");

        List<String> photoUrlsSet1 = Arrays.asList("SomeLink", "someLink");

        request.put("photoUrls", photoUrlsSet1);

        Map<String, Object> tag1 = new HashMap<>();

        tag1.put("id", 1);
        tag1.put("name", "someTag");

        Map<String, Object> tag2 = new HashMap<>();
        tag2.put("id", 2);
        tag2.put("name", "someTag");
        List<Map<String,Object>> tagsSet = Arrays.asList(tag1, tag2);

        request.put("tags", tagsSet);

        request.put("status", "Someting");
        System.out.println("REQUEST"+request);

        baseURI = "https://petstore.swagger.io/v2";
        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).when().
                post("/pet").then().statusCode(200).log().all();


    }
}
