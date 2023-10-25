package rest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class PutRequests {
    //PostRequests newCrocoID = new PostRequests();
    //PostRequests newToken = new PostRequests();
    //String userToken = newToken.getToken();
    //String crocoID = newCrocoID.getcrocoID();
    public void updateCrocobyID(PostRequests newToken, PostRequests newCrocoID) {
        String userToken = newToken.getToken();
        String crocoID = newCrocoID.getcrocoID();
        given().log().all().header("Authorization", userToken).header("Content-Type","application/json")
                .body("{\n" +
                        "    \"name\": \"Mrs. All-Sunday\",\n" +
                        "    \"sex\": \"F\",\n" +
                        "    \"date_of_birth\": \"1700-11-13\"\n" +
                        "}")
                .when().put("/my/crocodiles/" + crocoID + "/")
                .then().log().all().assertThat().statusCode(200);       //za put nam je statusResponse 200 a ne 201!?
    }
}
