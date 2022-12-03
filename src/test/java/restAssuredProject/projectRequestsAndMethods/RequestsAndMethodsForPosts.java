package restAssuredProject.projectRequestsAndMethods;

import framework.BaseAPIRequests;
import restAssuredProject.dto.Posts.Posts;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class RequestsAndMethodsForPosts extends BaseAPIRequests {

    public Posts[] getAllPosts(int statusCode) {
        return gson.fromJson(get(configReader.getProperty("uriForPosts"), statusCode), Posts[].class);
    }

    public Posts getPost(String numberOfPost, int statusCode) {
        return gson.fromJson(get(configReader.getProperty("uriForPosts") + numberOfPost, statusCode), Posts.class);
    }

    public void createNewPost(Posts posts, int statusCode) {
        post(gson.toJson(posts), configReader.getProperty("uriForPosts"), statusCode);
    }

    public Posts getDataFromJsonFile(String dataFileName) throws FileNotFoundException {
        return gson.fromJson(new FileReader((configReader.getProperty("directoryForTestData") + dataFileName)),
                Posts.class);
    }
}
