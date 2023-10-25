package rest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class DeleteRequest {
    PostRequests newCroco = new PostRequests();
    PostRequests newToken = new PostRequests();
    String userToken = newToken.getToken();
    String crocoID = newCroco.getcrocoID();

    public void deleteCrocoById(PostRequests newToken, PostRequests newCrocoID) {
        String userToken = newToken.getToken();
        String crocoID = newCrocoID.getcrocoID();
        given().header("Authorization",userToken)
                .when().delete("/my/crocodiles/" + crocoID + "/")
                .then().log().all().assertThat().statusCode(204);

    }
}
