package relex.obukhova;

import io.restassured.RestAssured;

public class LoginTokenProvider {
    public String logAsAdmin() {
        return RestAssured
                .given(Specs.REQUEST_SPECIFICATION)
                .when()
                .body(Specs.ADMIN_AUTH_CREDENTIALS)
                .post("/login")
                .then()
                .statusCode(200)
                .extract().response().jsonPath().getString("access_token");
    }

    public String logAsUser() {
        return RestAssured
                .given(Specs.REQUEST_SPECIFICATION)
                .when()
                .body(Specs.USER_AUTH_CREDENTIALS)
                .post("/login")
                .then()
                .statusCode(200)
                .extract().response().jsonPath().getString("access_token");
    }
}
