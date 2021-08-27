package rest_assured;

import io.restassured.http.ContentType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class createPet {

    // GET
    @Test
    public void testGet() {

        int id = 5;

        baseURI = "https://petstore.swagger.io/v2";
        given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body("").when().get("/pet/" + id).then().statusCode(200).log().all();
    }

    // POST
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
        List<Map<String, Object>> tagsSet = Arrays.asList(tag1, tag2);

        request.put("tags", tagsSet);

        request.put("status", "Someting");
        System.out.println("REQUEST" + request);

        baseURI = "https://petstore.swagger.io/v2";
        given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when().post("/pet").then().statusCode(200).log().all();
    }

    // Put
    @Test
    public void testPut() {
        JSONObject request = new JSONObject();
        request.put("id", 6);
        Map<String, Object> categorySet = new HashMap<>();
        categorySet.put("id", 2);
        categorySet.put("name", "Hell");

        request.put("category", categorySet);
        request.put("name", "Jo");

        List<String> photoUrlsSet1 = Arrays.asList("SomeLink", "someLink");

        request.put("photoUrls", photoUrlsSet1);

        Map<String, Object> tag1 = new HashMap<>();

        tag1.put("id", 1);
        tag1.put("name", "someTag");

        Map<String, Object> tag2 = new HashMap<>();
        tag2.put("id", 2);
        tag2.put("name", "someTag");
        List<Map<String, Object>> tagsSet = Arrays.asList(tag1, tag2);

        request.put("tags", tagsSet);

        request.put("status", "Someting");
        System.out.println("REQUEST" + request);

        baseURI = "https://petstore.swagger.io/v2";
        given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when().put("/pet").then().statusCode(200).log().all();

    }

    // Delete
    @Test
    public void deletePet() {
        baseURI = "https://petstore.swagger.io/v2";
        when().delete("/pet/5").then().statusCode(200).log().all();

    }

}
