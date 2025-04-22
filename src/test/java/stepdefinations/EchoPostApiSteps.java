package stepdefinations;


import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import io.restassured.RestAssured;

public class EchoPostApiSteps {

    private Response response;
    private String payload;

    @Given("I prepare the JSON order payload from {string}")
    public void i_prepare_json_payload(String filename) throws IOException {
        payload = new String(Files.readAllBytes(Paths.get("src/test/resources/payloads/" + filename)));
    }


    @When("I send a POST request to the order endpoint")
    public void i_send_post_request() {
        response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("http://echo.free.beeceptor.com/sample-request?author=beeceptor");


        System.out.println("Full Response Body:\n" + response.getBody().asString());
    }


    @Then("the response should contain customer name as {string}")
    public void the_response_should_contain_customer_name_as(String expectedName) {
        String actualName = response.jsonPath().getString("parsedBody.customer.name");
        assertEquals(expectedName, actualName);
    }


    @Then("the response should contain product with ID {string}")
    public void the_response_should_contain_product_with_id(String productId) {
        String id1 = response.jsonPath().getString("parsedBody.items[0].product_id");
        String id2 = response.jsonPath().getString("parsedBody.items[1].product_id");
        assertTrue(id1.equals(productId) || id2.equals(productId));
    }

    @Then("the response should contain payment method as {string}")
    public void the_response_should_contain_payment_method(String method) {
        assertEquals(method, response.jsonPath().getString("parsedBody.payment.method"));
    }


}
