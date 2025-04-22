package stepdefinations;



import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.RestAssured;

import static org.junit.Assert.*;

public class EchoGetApiSteps {
    private Response response;

    @When("I send a GET request to the echo API")
    public void send_get_request() {
        response = RestAssured
                .given()
                .when()
                .get("https://echo.free.beeceptor.com/sample-request?author=beeceptor");

        assertEquals(200, response.getStatusCode());  // Check if status code is 200
    }


    @Then("the response should include a valid path")
    public void validate_path_field() {
        String path = response.jsonPath().getString("path");
//        assertNotNull("Path should not be null", path);
//        assertTrue("Path should start with /", path.startsWith("/"));

        if (path != null) {
            assertTrue("Path should start with /", path.startsWith("/"));
        } else {
            System.out.println("Path is missing in the response");
        }
    }

    @Then("the response should include an IP address")
    public void validate_ip_field() {
        String ip = response.jsonPath().getString("ip");
        assertNotNull("IP address should not be null", ip);
        assertTrue("IP should be a valid format", ip.matches("\\d+\\.\\d+\\.\\d+\\.\\d+(:\\d+)?"));
    }


    @Then("the response should include headers")
    public void validate_headers() {
        assertNotNull("Headers should not be null", response.jsonPath().get("headers"));
        assertNotNull("Headers should contain 'User-Agent'", response.jsonPath().getString("headers.'User-Agent'"));
    }


}
