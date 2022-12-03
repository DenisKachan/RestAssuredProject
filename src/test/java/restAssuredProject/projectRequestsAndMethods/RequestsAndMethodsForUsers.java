package restAssuredProject.projectRequestsAndMethods;

import framework.BaseAPIRequests;
import restAssuredProject.dto.Users.Users;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class RequestsAndMethodsForUsers extends BaseAPIRequests {

    public Users[] getAllUsers(int statusCode) {
        return gson.fromJson(get(configReader.getProperty("uriForUsers"), statusCode), Users[].class);
    }

    public Users getUser(String numberOfUser, int statusCode) {
        return gson.fromJson(get(configReader.getProperty("uriForUsers") + numberOfUser, statusCode), Users.class);
    }

    public Users getDataFromJsonFile(String dataFileName) throws FileNotFoundException {
        return gson.fromJson(new FileReader((configReader.getProperty("directoryForTestData") + dataFileName)),
                Users.class);
    }
}
