package automation_frontend.steps.APIs;

import automation_frontend.steps.BaseSteps;
import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.Reporter;
import org.json.simple.JSONObject;
import io.restassured.http.ContentType;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class APISteps extends BaseSteps {


    @Given("the URI of the environment by testng .xml file")
    public void theURIOfTheEnvironmentByTestngXmlFile() {

        //simply a step to add from the testng variables the URI that we will use. This allows us different Testng documents = Different environments
        baseURI = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("url");

    }

    @And("Find a specific user by {string} or by a {string}")
    public void findASpecificUserOrByALength(String name, String length) {

        //Use JSONObject dependency to use easily the request and response json
        JSONObject request1 = new JSONObject();

        //static import allows me to do the request directly from the given
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request1.toJSONString())
                .when()
                .get("/users?page=1")
                .then()
                .statusCode(200).log().all()
                //simply groovy assert through body response
                .assertThat().body("data[0].first_name", equalTo(name))
                .assertThat().body("data.first_name.findAll { it.length() <  " + length + "  }", hasItems("Eve"));
    }

    @Then("assert separately the first {string} on the list and all the fields for specific person with {string} and {string}")
    public void assertSeparatelyAllTheFields(String name, String FirstName,String LastName) {

        //Another way to assert results is with jsonPath
        Response response = get("/users");

        int statusCode = response.getStatusCode();
        String json = response.getBody().asString();

        //jsonPath allows me to use more complex querys for search the results
        String  firstNameOnList = JsonPath.parse(json).read("$.data[0].first_name");
        List<String> emails = JsonPath.parse(json).read("$.data[*].email");
        //Multiple predicates
        List<String>  onePersonSpecificFN = JsonPath.parse(json).read("$.data[?(@.first_name == '" + FirstName + "' && @.last_name == '" + LastName + "')].first_name");
        List<String>  onePersonSpecificLN = JsonPath.parse(json).read("$.data[?(@.first_name == '" + FirstName + "' && @.last_name == '" + LastName + "')].last_name");

        Assert.assertEquals(onePersonSpecificFN.get(0), FirstName);
        Assert.assertEquals(onePersonSpecificLN.get(0), LastName);
        Assert.assertEquals(emails.get(1), "janet.weaver@reqres.in");
        Assert.assertEquals(firstNameOnList, name);

    }

    @When("look for a {string} user and other filters")
    public void lookForAUnexistantUser(String Unexistant) {

        JSONObject request1 = new JSONObject();

        //create an empty array to validate when the assert result is equal to 0
        String notExist[] = new String[0];

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request1.toJSONString())
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200).log().all()
                .assertThat().body("data.findAll { it.first_name == '" + Unexistant + "' }", hasItems(notExist));
    }

    @And("post a user through a JsonObject with {string} and {string}")
    public void postAUserThroughAJsonObject(String LeaderName, String Job) {
        //Easy way to do request process trough JSONObject
        JSONObject request = new JSONObject();

        request.put("name", LeaderName);
        request.put("job", Job);

        //Convert the hashMap puts into Json
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                //Assert body response of the post, put, update
                .assertThat().body(
                        "name", equalTo(LeaderName),
                        "job", equalTo(Job))
                .log().all();
    }
}
