package rest;

import static io.restassured.RestAssured.given;

public class PatchRequest {
    public void updateCrocoPropertyByID(PostRequests newToken, PostRequests newCrocoID) {
        String userToken = newToken.getToken();
        String crocoID = newCrocoID.getcrocoID();
        given().header("Authorization", userToken).header("Content-Type","application/json")
                .body("{\n" +
                        "    \"date_of_birth\": \"1930-1-13\"\n" +
                        "}")
                .when().patch("/my/crocodiles/" + crocoID + "/")
                .then().log().all().assertThat().statusCode(200);       //put i patch imaju statusCode 200! a ne 201!
    }
}
