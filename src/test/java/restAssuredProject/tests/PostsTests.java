package restAssuredProject.tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import restAssuredProject.pojo.Posts.PostsPojo;
import restAssuredProject.projectRequestsAndMethods.CommonRequestsAndMethods;
import restAssuredProject.projectRequestsAndMethods.Posts;

import java.io.FileNotFoundException;

public class PostsTests {

    CommonRequestsAndMethods commonRequestsAndMethods = new CommonRequestsAndMethods(new PostsPojo());
    Posts posts = new Posts();
    Faker faker = new Faker();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void getAllPostsTest() {
        PostsPojo[] allPosts = (PostsPojo[]) commonRequestsAndMethods.getAllEntities(200);
        posts.checkPostsToBeSortedById(allPosts);
    }

    @Test
    public void getCertainPostTest() throws FileNotFoundException {
        PostsPojo certainPost = (PostsPojo) commonRequestsAndMethods.getEntity("99", 200);
        PostsPojo dataFromJsonFile = (PostsPojo) commonRequestsAndMethods.getDataFromJsonFile("ninetyNinthPost.json");
        posts.checkUserIdToBeEqual(certainPost, dataFromJsonFile);
        posts.checkIdToBeEqual(certainPost, dataFromJsonFile);
        posts.checkBodyToBeNotEmpty(certainPost);
        posts.checkTitleToBeNotEmpty(certainPost);
        softAssert.assertAll();
    }

    @Test
    public void getNonexistentPostTest() {
        PostsPojo actualPost = (PostsPojo) commonRequestsAndMethods.getEntity("150", 404);
        posts.checkPostToBeNotNull(actualPost);
        softAssert.assertAll();
    }

    @Test
    public void createNewPostTest() throws FileNotFoundException {
        PostsPojo newPost = (PostsPojo) commonRequestsAndMethods.getDataFromJsonFile("postForCreation.json");
        newPost.setBody(faker.business().toString());
        newPost.setTitle(faker.name().toString());
        commonRequestsAndMethods.createNewEntity(newPost, 201);
        posts.checkCreatedPostToBeEqual(newPost);
    }
}
