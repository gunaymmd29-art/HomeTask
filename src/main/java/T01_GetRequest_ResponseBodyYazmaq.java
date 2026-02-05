import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.Argument;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.emptyString;

public class T01_GetRequest_ResponseBodyYazmaq {
    //URL:
    //https://jsonplaceholder.typicode.com/posts/25
    //Test edin:- Status code 200 olmalidir- Content-Type application/json olmalidir-
    // Response body-de id 25 olmalidir- Response body-de userId 3 olmalidir-
    // title fieldi bosh olmamalidir
    //Ipucu: .body("id", equalTo(25)) ve .body("title", not(emptyString())) istifade edin

    @Test
    public void test(){
        // 1 Step- request body ve endpoint hazirlanmasi

        String url ="https://jsonplaceholder.typicode.com/posts/25";

        //2 Step Expected Data hazirla


        //3 Request gonder donen Response yadda saxla

        Response response = given().when().get(url);
        // 4 Step Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("id",equalTo(25))
                .body("userId",equalTo(3))
                .body("title", Matchers.not(emptyString()));




    }
}

