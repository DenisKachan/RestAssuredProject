package restAssuredProject.tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import restAssuredProject.dto.Posts.Posts;
import restAssuredProject.projectRequestsAndMethods.CommonRequestsAndMethods;
import restAssuredProject.projectRequestsAndMethods.PostsMethods;

import java.io.FileNotFoundException;

public class PostsTests {

    CommonRequestsAndMethods commonRequestsAndMethods = new CommonRequestsAndMethods(new Posts());
    PostsMethods postsMethods = new PostsMethods();
    Faker faker = new Faker();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void getAllPostsTest() {
        Posts[] allPosts = (Posts[]) commonRequestsAndMethods.getAllEntities(200);
        postsMethods.checkPostsToBeSortedById(allPosts);
    }

    @Test
    public void getCertainPostTest() throws FileNotFoundException {
        Posts certainPost = (Posts) commonRequestsAndMethods.getEntity("99", 200);
        Posts dataFromJsonFile = (Posts) commonRequestsAndMethods.getDataFromJsonFile("ninetyNinthPost.json");
        postsMethods.checkUserIdToBeEqual(certainPost, dataFromJsonFile);
        postsMethods.checkIdToBeEqual(certainPost, dataFromJsonFile);
        postsMethods.checkBodyToBeNotEmpty(certainPost);
        postsMethods.checkTitleToBeNotEmpty(certainPost);
        softAssert.assertAll();
    }

    @Test
    public void getNonexistentPostTest() {
        Posts actualPost = (Posts) commonRequestsAndMethods.getEntity("150", 404);
        postsMethods.checkPostToBeNotNull(actualPost);
        softAssert.assertAll();
    }

    @Test
    public void createNewPostTest() throws FileNotFoundException {
        Posts newPost = (Posts) commonRequestsAndMethods.getDataFromJsonFile("postForCreation.json");
        newPost.setBody(faker.business().toString());
        newPost.setTitle(faker.name().toString());
        commonRequestsAndMethods.createNewEntity(newPost, 201);
        postsMethods.checkCreatedPostToBeEqual(newPost);
    }
}
