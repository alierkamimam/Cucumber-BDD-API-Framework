package bdd_APIFramework.resources;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {
    RequestSpecification req;

    public RequestSpecification requestSpecification() throws IOException {
        //we see all logs
        PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

        req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON).build();

        return req;
    }

    public static String getGlobalValue(String key) throws IOException {

        Properties prop = new Properties();
        String path = System.getProperty("user.dir") + "\\src\\test\\java\\bdd_APIFramework\\resources\\global.properties";
        FileInputStream fis = new FileInputStream(path);
        prop.load(fis);
        return prop.getProperty(key);


    }

    public String getJsonPath(Response response, String key) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();


    }
}