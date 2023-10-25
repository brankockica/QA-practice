package rest;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class PostRequests {
    private String username;
    private String password = "brbrbr123";
    String token;
    String crocoID;

    public String userCreateRequestBody(String username1, String email1){
        return "{\n" +
                "    \"username\": \""+username1+"\",\n" +
                "    \"first_name\": \"bane\",\n" +
                "    \"last_name\": \"radi\",\n" +
                "    \"email\": \""+email1+"\",\n" +
                "    \"password\": \""+password+"\"\n" +
                "}";
    }
    public void userCreate() {
        String response = given().log().all().header("Content-Type","application/json")
                .body(userCreateRequestBody("branebe+test20", "brbr+test20@gmail.com"))
                .when().post("/user/register/")
                .then().log().all().assertThat().body("first_name", equalTo("bane")).statusCode(201)
                .extract().response().asString();

        JsonPath json = new JsonPath(response);
        username = json.getString("username");
    }
    public void userLoginToken() {
        String response1 = given().header("Content-Type","application/json")
                .body("{\n" +
                        "    \"username\": \""+username+"\",\n" +
                        "    \"password\": \""+password+"\"\n" +
                        "}")
                .when().post("/auth/token/login/")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath json1 = new JsonPath(response1);
        token = "Bearer " + json1.getString("access");
    }
    public String getToken() {
        return token;
    }

    public void createNewCroco(String name, String sex, String date) {
        String response2 = given().header("Content-Type","application/json").header("Authorization", token)
                .body("{\n" +
                        "    \"name\": \""+name+"\",\n" +
                        "    \"sex\": \""+sex+"\",\n" +
                        "    \"date_of_birth\": \""+date+"\"\n" +
                        "}")
                .when().post("/my/crocodiles/")
                .then().log().all().assertThat().statusCode(201)
                .extract().response().asString();
        JsonPath json2 = new JsonPath(response2);
        crocoID = json2.getString("id");
    }
    public String getcrocoID() {
        return crocoID;
    }

}
