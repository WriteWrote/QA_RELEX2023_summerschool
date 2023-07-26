package relex.obukhova;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specs {
    private static final String BASE_URI = "http://test-microcam.relex.ru:40000";

    private static final RequestSpecification precondition = RestAssured.given()
            .baseUri(Specs.receiveBaseUri())
            .contentType(ContentType.JSON);

    private static final String ADMIN_AUTH_CREDENTIALS = "{\n" +
            "   \"username\": \"Adm1n!11\",\n" +
            "   \"password\": \"h_X___e$u#0\"\n" +
            "}";

    private static final String USER_AUTH_CREDENTIALS = "{\n" +
            "   \"username\": \"admin\",\n" +
            "   \"password\": \"password\"\n" +
            "}";

    private static final String GREETING = "\"Hellow world!\"";
    public static String receiveBaseUri() {
        return BASE_URI;
    }

    public static RequestSpecification receivePrecondition(){
        return precondition;
    }

    public static String receiveAdminCredentials(){
        return ADMIN_AUTH_CREDENTIALS;
    }

    public static String receiveUserCredentials(){
        return USER_AUTH_CREDENTIALS;
    }

    public static String receiveGreeting(){
        return GREETING;
    }
}
