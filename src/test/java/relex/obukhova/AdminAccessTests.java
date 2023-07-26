package relex.obukhova;

import io.restassured.RestAssured;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;

import java.net.Authenticator;

public class AdminAccessTests {
    private final LoginTokenProvider tokenProvider = new LoginTokenProvider();

    @Test
    public void getAllUserInfo(){
        String adminToken = tokenProvider.logAsAdmin();
        RestAssured
                .given(Specs.REQUEST_SPECIFICATION)
                .when()
                .baseUri("/users/all")
                .header("Authorization", "Bearer " + adminToken)
                .then()
                .statusCode(200);

        String userToken = tokenProvider.logAsUser();
        RestAssured
                .given(Specs.REQUEST_SPECIFICATION)
                .when()
                .baseUri("/users/all")
                .header("Authorization", "Bearer " + userToken)
                .then()
                .statusCode(403);

        RestAssured
                .given(Specs.REQUEST_SPECIFICATION)
                .when()
                .baseUri("/users/all")
                .header("Authorization", "Bearer ")
                .then()
                .statusCode(401);
    }
}
