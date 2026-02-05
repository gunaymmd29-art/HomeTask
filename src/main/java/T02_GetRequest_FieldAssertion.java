import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertTrue;

public class T02_GetRequest_FieldAssertion {
    @Test
    public void getFieldAssertion(){
        //URL:
        //https://jsonplaceholder.typicode.com/posts/60
        //Test edin:- Status code 200 olmalidir-
        // id 60 olmalidir- userId 6 olmalidir-
        // body uzunlugu 20 simvoldan cox olmalidir- title icinde en az 1 bosluq (" ") olmalidir
        //Ipucu: String metodlarindan .length() ve .contains(" ") istifade edin

        // 1 Step Request Body ve endpoint hazirla
        String url = "https://jsonplaceholder.typicode.com/posts/60";
        // 2 Step Expected data body yarat
         // Step Request gonder donen Response yadda saxla
        Response response = given().when().get(url);
        //4 Step Assertions

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("id",equalTo(60))
                .body("userId",equalTo(6));
        assertTrue(response.jsonPath().getString("body").length() > 20);
        assertTrue(response.jsonPath().getString("title").contains(" "));


    }
}
