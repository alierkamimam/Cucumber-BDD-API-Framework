package bdd_APIFramework.stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import bdd_APIFramework.resources.APIResources;
import bdd_APIFramework.resources.TestDataBuild;
import bdd_APIFramework.resources.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.FileNotFoundException;
import java.io.IOException;

public class stepDefinition extends Utils {
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    TestDataBuild data = new TestDataBuild();
    String place_id;
    JsonPath js;


    @Given("Add Place Payload with {string}")
    public void add_place_payload(String name) throws IOException {

        res = given().spec(requestSpecification()).body(data.addPlacePayload(name));


    }


    @When("user calls {string} with {string} Http request")
    public void user_calls_with_post_http_request(String resource, String methods) {

        APIResources resourceAPI = APIResources.valueOf(resource);
        System.out.println(resourceAPI.getResources());
        resspec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
        if (methods.equalsIgnoreCase("POST"))
            response = res
                    .when()
                    .post(resourceAPI.getResources());

        else if (methods.equalsIgnoreCase("GET"))
            response = res
                    .when()
                    .get(resourceAPI.getResources());

    }


    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {
        assertEquals(response.getStatusCode(), 200);


    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String key, String value) {
        assertEquals(getJsonPath(response, key), value);

    }

    @And("verify place_id created maps to {string} using {string}")
    public void verifyPlace_idCreatedMapsToUsing(String expectedName, String resources) throws IOException {
        place_id = getJsonPath(response, "place_id");
        res = given().spec(requestSpecification()).queryParam("place_id", place_id);
        user_calls_with_post_http_request(resources,"GET");
        String actualName= getJsonPath(response, "name");
        assertEquals(actualName,expectedName);
        // System.out.println(place_id);
    }
}
