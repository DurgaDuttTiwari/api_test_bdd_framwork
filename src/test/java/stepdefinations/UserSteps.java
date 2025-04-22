package stepdefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class UserSteps {

    private int userId;
    private Response response;

    @Given("the user ID is {int}")
    public void theUserIDIs(int arg0) {
        this.userId = arg0;
    }

    @When("I send a GET request to the user API")
    public void iSendAGETRequestToTheUserAPI() {

        response = given()
                .baseUri("https://reqres.in")
                .when()
                .get("/api/users/" + userId);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @And("the response should contain the user's first name as {string}")
    public void theResponseShouldContainTheUserSFirstNameAs(String expectedName) {
        String actualName = response.jsonPath().getString("data.first_name");
        assertEquals(expectedName, actualName);
    }
}
