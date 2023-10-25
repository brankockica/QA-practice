package rest;
import rest.GetRequests;
import rest.PostRequests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestBasics {
    GetRequests getRequest;
    PostRequests postRequest;
    PutRequests putRequest;
    DeleteRequest deleteRequest;
    PatchRequest patchRequest;

    @BeforeTest
    void setup () {
        baseURI = "https://test-api.k6.io/";
        getRequest = new GetRequests();
        postRequest = new PostRequests();
        putRequest = new PutRequests();
        deleteRequest = new DeleteRequest();
        patchRequest = new PatchRequest();

    }
    @Test
    public void apiTest1() {
        getRequest.listPublicCroco();
        postRequest.userCreate();
        postRequest.userLoginToken();
        postRequest.createNewCroco("Zika", "M", "1900-10-5");

    }
    @Test
    public void apiTest2() {
        postRequest.userLoginToken();
        postRequest.createNewCroco("Mika", "F", "1950-3-12");
        postRequest.createNewCroco("Keka", "F", "1960-11-12");
        getRequest.listMyCrocos(postRequest);
        putRequest.updateCrocobyID(postRequest,postRequest);
        getRequest.listMyCrocos(postRequest);
        patchRequest.updateCrocoPropertyByID(postRequest,postRequest);
        getRequest.getCrocoById(postRequest,postRequest);
        deleteRequest.deleteCrocoById(postRequest,postRequest);         //updatujem u argumentu token i crocoID
    }
}
