package relex.obukhova;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

public class UserProfilesTests {
    private LoginTokenProvider tokenProvider = new LoginTokenProvider();

    private UUID savedUserUUID;

    @Test
    public void createUser() {
        RestAssured
                .given(Specs.REQUEST_SPECIFICATION)
                .when()
                .body(Specs.INVALID_USER_CREDS)
                .post("/users")
                .then()
                .statusCode(400);

        savedUserUUID = UUID.fromString(RestAssured
                .given(Specs.REQUEST_SPECIFICATION)
                .when()
                .body(Specs.VALID_USER_CREDS)
                .post("/users")
                .then()
                .statusCode(201)
                .extract().response().jsonPath().getString("uuid"));

        RestAssured
                .given(Specs.REQUEST_SPECIFICATION)
                .when()
                .body(Specs.VALID_USER_CREDS)
                .post("/users")
                .then()
                .statusCode(409);
    }

    // couldn't do deleting user

//    @Test
//    public void deleteUserAsAdmin() {
//        createUser();   // i don't know how to trigger it via annotation
//                        // or how to do it properly so i'm doing direct call
//
//        RestAssured
//                .given(Specs.REQUEST_SPECIFICATION)
//                .when()
//                .delete("/users/" + savedUserUUID)
//                .then()
//                .statusCode(401);
//
//        String adminToken = tokenProvider.logAsAdmin();
//        String userToken = tokenProvider.logAsUser();
//
//        RestAssured
//                .given(Specs.REQUEST_SPECIFICATION)
//                .when()
//                .header("Authorization", "Bearer" + adminToken)
//                .delete("/users/" + savedUserUUID)
//                .then()
//                .statusCode(401);
//
//        RestAssured
//                .given(Specs.REQUEST_SPECIFICATION)
//                .when()
//                .header("Authorization", "Bearer" + userToken)
//                .delete("/users/" + savedUserUUID)
//                .then()
//                .statusCode(200);
//
//        RestAssured
//                .given(Specs.REQUEST_SPECIFICATION)
//                .when()
//                .delete("/users/" + savedUserUUID)
//                .then()
//                .statusCode(404);
//    }
}
