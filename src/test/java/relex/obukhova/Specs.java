package relex.obukhova;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.UUID;

public class Specs {
    public static final String BASE_URI = "http://test-microcam.relex.ru:40000";

    public static final RequestSpecification REQUEST_SPECIFICATION = RestAssured.given()
            .baseUri(Specs.BASE_URI)
            .contentType(ContentType.JSON);

    public static final String ADMIN_AUTH_CREDENTIALS = "{\n" +
            "   \"username\": \"Adm1n!11\",\n" +
            "   \"password\": \"h_X___e$u#0\"\n" +
            "}";

    public static final String USER_AUTH_CREDENTIALS = "{\n" +
            "   \"username\": \"oapufzqean\",\n" +
            "   \"password\": \"SoME_PAssword1!!\"\n" +
            "}";

    public static final String VALID_USER_CREDS = "{\n" +
            "\"firstName\": \"user\",\n" +
            "\"lastName\": \"userovich\",\n" +
            "\"login\": \"user3Q2W\",\n" +
            "\"email\": \"user@post.com\",\n" +
            "\"password\": \"Pa$$w0rd\"\n" +
            "}";
    public static final String INVALID_USER_CREDS = "{\n" +
            "\"firstName\": \"user\",\n" +
            "\"lastName\": \"userovich\",\n" +
            "\"login\": \"user\",\n" +
            "\"email\": \"user@post.com\",\n" +
            "\"password\": \"Pa$$\"\n" +
            "}";

    public static final String GREETING = "\"Hellow world!\"";
}
