package rest_assured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class createPet {

    Response response;

    // GET
    @Test
    public void testGet() {

        int id = 1;

        baseURI = "https://petstore.swagger.io/v2";
        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body("").when().
                get("/pet/" + id).then().statusCode(200).log().all();
    }


    //POST
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
        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).when().
                post("/pet").then().statusCode(200).log().all();
    }


    //Put
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
        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).when().
                put("/pet").then().statusCode(200).log().all();

    }

//    //Delete
//    @Test
//    public void deletePet() {
//        baseURI = "https://petstore.swagger.io/v2";
//        when().delete("/pet/5").then().statusCode(200).log().all();
//
//    }

    @Test
    public void getResponse() {
        baseURI = "https://petstore.swagger.io/v2";

        response = given().accept(ContentType.JSON).when().get("/pet/5");
        response.then().statusCode(200);
        ResponseBody body = response.getBody();
        Pet pet = body.as(Pet.class);
        Assertions.assertEquals(pet.getId(), 5);
        Assertions.assertEquals(pet.getName(), "San");
        Assertions.assertEquals(pet.getStatus(), "Someting");


    }

}
