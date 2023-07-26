package relex.obukhova;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.is;


public class GetMethodsTests {
    @Test
    public void getGreeting2() {
        RestAssured
                .given(Specs.REQUEST_SPECIFICATION)
                .when()
                .get("/greet")
                .then()
                .statusCode(200)
                .body(is(Specs.GREETING));
    }
}
