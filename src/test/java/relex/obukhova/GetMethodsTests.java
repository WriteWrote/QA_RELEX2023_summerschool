package relex.obukhova;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.is;


public class GetMethodsTests {
    @Test
    public void getGreeting2() {
        RestAssured
                .given(Specs.receivePrecondition())
//                .baseUri("http://test-microcam.relex.ru:40000")
//                .contentType(ContentType.JSON)
                .when()
                .get("/greet")
                .then()
                .statusCode(200)
                .body(is(Specs.receiveGreeting()));
    }

    @Test
    public void login() {
        String token = RestAssured
                .given(Specs.receivePrecondition())
                .when()
                .body(Specs.receiveAdminCredentials())
                .post("/login")
                .then()
                .statusCode(200)
                .extract().response().jsonPath().getString("access_token");

        String tokenType = RestAssured
                .given()
                .when()
                .body(Specs.receiveAdminCredentials())
                .post("/login")
                .then()
                .statusCode(200)
                .extract().response().jsonPath().getString("type");

        RestAssured
                .given()
                .baseUri(Specs.receiveBaseUri())
                .contentType(ContentType.JSON)
                .when()
                .body(Specs.receiveAdminCredentials())
                .post("/login")
                .then()
                .statusCode(200);
    }
}
