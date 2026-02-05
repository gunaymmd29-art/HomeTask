import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.Argument;
import org.hamcrest.Matcher;
import org.json.JSONObject;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class T03_PostRequest_ResponseBody{
    //https://jsonplaceholder.typicode.com/posts
    //Request Body:
    //{
    //  "title": "Automation Test",
    //  "body": "API testing with Rest Assured",
    //  "userId": 9
    //}
    //Test edin:- Status code 201 olmalidir-
    // Content-Type application/json olmalidir-
    // Response body-de title "Automation Test" olmalidir-
    // Response body-de userId 9 olmalidir- body fieldi icinde "Rest" sozu kecmelidir
    //Ipucu: .body(requestBody).post(url) ve .body("body", containsString("Rest")) istifade et

    @Test
    public void post_ResponseBody(){
        //1Step requuest body ve endpoin yarat
        String url ="https://jsonplaceholder.typicode.com/posts";
        JSONObject requestBody =new JSONObject();
        requestBody.put("title", "Automation Test");
        requestBody.put("body", "API testing with Rest Assured");
        requestBody.put( "userId",9);
        //2Step expected data yarat
        //3Step Request gonder donen cavabi yadda saxla

        Response response = given().contentType(ContentType.JSON).when()
                           .body(requestBody.toString()).post(url);
        response.prettyPrint();
        //4Step Assertions


        response
                .then()
                .assertThat()
                .statusCode(201)
                .contentType("application/json")
                .body("title", equalTo("Automation Test"))
                .body("userId", equalTo(9))
                .body("body", containsString("Rest"));




    }
}
