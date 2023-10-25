package rest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import rest.PostRequests;

public class GetRequests {
    //PostRequests newCrocoID = new PostRequests();
    //PostRequests newToken = new PostRequests();
    //String userToken = newToken.getToken();
    //String crocoID = newCrocoID.getcrocoID();
    //Iz nekog razloga nisam mogao ovako da instanciram i getujem varijablu
    //Morao sam direktno da pozivam instancu kao argument u metodi i da getujem varijablu unutar metode

    public void listPublicCroco() {
        given().log().all().header("Content-Type","application/json")
                .when().get("/public/crocodiles/")
                .then().log().all().assertThat().statusCode(200);
    }
    public void listMyCrocos(PostRequests newToken) {
        String userToken = newToken.getToken();
        given().header("Authorization", userToken)
                .when().get("/my/crocodiles/")
                .then().log().all().assertThat().statusCode(200);
    }
    public void getCrocoById(PostRequests newToken, PostRequests newCrocoID) {
        String userToken = newToken.getToken();
        String crocoID = newCrocoID.getcrocoID();
        given().log().all().header("Content-Type","application/json").header("Authorization", userToken)
                .when().get("/my/crocodiles/" + crocoID + "/")
                .then().log().all().assertThat().statusCode(200);
    }
}
