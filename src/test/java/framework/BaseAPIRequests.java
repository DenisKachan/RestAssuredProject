package framework;

import com.google.gson.Gson;

import static io.restassured.RestAssured.given;

public class BaseAPIRequests {

    protected PropertyReader configReader = new PropertyReader("config.properties");
    protected String baseUrl = configReader.getProperty("baseAPIUrl");
    protected Gson gson = new Gson();

    protected String get(String uri, int statusCode) {
        return given().
                log().all().
                header("Content-Type", "application/json").
                when().
                get(baseUrl + uri).
                then().assertThat().statusCode(statusCode).
                extract().body().asString();
    }

    protected void post(String entity, String uri, int statusCode) {
        given().
                log().all().
                header("Content-Type", "application/json").
                body(entity).
                when().
                post(baseUrl + uri).
                then().assertThat().statusCode(statusCode).
                extract().body().asString();
    }
}