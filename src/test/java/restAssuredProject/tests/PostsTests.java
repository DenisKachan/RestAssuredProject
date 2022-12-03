package restAssuredProject.tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import restAssuredProject.dto.Posts.Posts;
import restAssuredProject.projectRequestsAndMethods.RequestsAndMethodsForPosts;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PostsTests {

    RequestsAndMethodsForPosts requestsAndMethodsForPosts = new RequestsAndMethodsForPosts();
    Faker faker = new Faker();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void getAllPostsTest() {
        Posts[] allPosts = requestsAndMethodsForPosts.getAllPosts(200);
        Assert.assertEquals(allPosts[0].getId(), allPosts[1].getId() - 1);
    }

    @Test
    public void getCertainPostTest() throws FileNotFoundException {
        Posts certainPost = requestsAndMethodsForPosts.getPost("99", 200);
        Posts dataFromJsonFile = requestsAndMethodsForPosts.getDataFromJsonFile("ninetyNinthPost.json");
        softAssert.assertEquals(certainPost.getUserId(), dataFromJsonFile.getUserId(),
                "UserId numbers are different");
        softAssert.assertEquals(certainPost.getId(), dataFromJsonFile.getId(), "Id numbers are different");
        softAssert.assertFalse(certainPost.getBody().isEmpty(), "Body is empty");
        softAssert.assertFalse(certainPost.getTitle().isEmpty(), "Title is empty");
        softAssert.assertAll();
    }

    @Test
    public void getNonexistentPostTest() {
        Posts actualPosts = requestsAndMethodsForPosts.getPost("150", 404);
        softAssert.assertNull(actualPosts.getBody(), "The body is not null");
        softAssert.assertAll();
    }

    @Test
    public void createNewPostTest() throws FileNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        String randomBody = faker.company().toString();
        String randomTitle = faker.animal().toString();
        Posts newPost = requestsAndMethodsForPosts.getDataFromJsonFile("postForCreation.json");
        newPost.setBody(randomBody);
        newPost.setTitle(randomTitle);
        requestsAndMethodsForPosts.createNewPost(newPost, 201);
        System.out.println(newPost);
        String id = Integer.toString(newPost.getId());
        String userId = Integer.toString(newPost.getUserId());
        softAssert.assertTrue(byteArrayOutputStream.toString().contains(randomTitle), "Actual title is not the " +
                "same as in request");
        softAssert.assertTrue(byteArrayOutputStream.toString().contains(randomBody), "Actual body is not the " +
                "same as in request");
        softAssert.assertTrue(byteArrayOutputStream.toString().contains(id), "Actual id is not the " +
                "same as in request");
        softAssert.assertTrue(byteArrayOutputStream.toString().contains(userId), "Actual userId is not the " +
                "same as in request");
        softAssert.assertAll();
        System.setOut(null);
    }
}
