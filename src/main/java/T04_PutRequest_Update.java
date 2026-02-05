import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

public class T04_PutRequest_Update {
    @Test
    public void putRequest(){
        //URL:
        //https://jsonplaceholder.typicode.com/posts/10
        //Request Body:{
              //}
               //"id": 10,
              //"title": "Updated Post",
               //"body": "Post was updated",
               //"userId": 4
        //Test edin:- Status code 200 olmalidir- title "Updated Post" olmalidir-
        // body icinde "updated" sozu kecmelidir- userId 4 olmalidir
        //Ipucu: .put(url) metodu istifade edin ve containsStringIgnoringCase() faydali ola biler

        //1 Step request body ve endpoint yarat
        String url ="https://jsonplaceholder.typicode.com/posts/10";
        JSONObject requestBody =new JSONObject();
        requestBody.put("id", 10);
        requestBody.put("title", "Updated Post");
        requestBody.put("body", "Post was updated");
        requestBody.put("userId",4);
        //2 Step expected data yarat
        //3 Step Request gonder donen cavabi yadda saxla
        Response response = given().contentType(ContentType.JSON).when()
                .body(requestBody.toString())
                .put(url);
         response.prettyPrint();
        //4Step Assertions
       response
                .then()
                .assertThat()
                .statusCode(200)
                .body("title", equalTo("Updated Post"))
                .body("title", containsStringIgnoringCase("updated"))
                .body("userId",equalTo(4));




    }
}
