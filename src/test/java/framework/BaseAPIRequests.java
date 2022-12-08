package framework;

import com.google.gson.Gson;
import framework.utils.PropertyReader;
import lombok.extern.log4j.Log4j2;

import static io.restassured.RestAssured.given;

@Log4j2
public class BaseAPIRequests {

    public PropertyReader configReader = new PropertyReader("config.properties");
    public String baseUrl = configReader.getProperty("baseAPIUrl");
    public Gson gson = new Gson();

    protected String get(String uri, int statusCode) {
        log.info("Send get request to uri {} ",uri);
        return given().
                log().all().
                header("Content-Type", "application/json").
                when().
                get(baseUrl + uri).
                then().
                assertThat().statusCode(statusCode).
                extract().body().asString();
    }

    protected void post(String entity, String uri, int statusCode) {
        log.info("Send post request to uri {} with body {}",uri,entity);
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