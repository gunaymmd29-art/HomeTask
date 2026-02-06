import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class T05_DeleteRequest {
//URL:
//https://jsonplaceholder.typicode.com/posts/8
//Test edin:- Status code 200 olmalidir- Response body bosh {} olmalidir
//Ipucu: .delete(url) ve .body(equalTo("{}")) istifade edin
    @Test
    public void deleteRequest(){

        //1Step request body ve endpoint yarat
        String url = "https://jsonplaceholder.typicode.com/posts/8";
        //2 Step expected data hazirla
        //3Step Request gonder donen response yadda saxla
        Response response =given().when().delete(url);
        //5Step Assertions
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body(equalTo("{}"));
    }

}
