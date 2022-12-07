package restAssuredProject.projectRequestsAndMethods;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import restAssuredProject.pojo.Posts.PostsPojo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Posts {

    private SoftAssert softAssert = new SoftAssert();

    public void checkIdToBeEqual(PostsPojo requestPost, PostsPojo dataFromJsonFile) {
        softAssert.assertEquals(requestPost.getId(), dataFromJsonFile.getId(), "Id numbers are different");
    }

    public void checkUserIdToBeEqual(PostsPojo requestPost, PostsPojo dataFromJsonFile) {
        softAssert.assertEquals(requestPost.getUserId(), dataFromJsonFile.getUserId(),
                "UserId numbers are different");
    }

    public void checkBodyToBeNotEmpty(PostsPojo requestPost) {
        softAssert.assertFalse(requestPost.getBody().isEmpty(), "Body is empty");
    }

    public void checkPostToBeNotNull(PostsPojo requestPost) {
        softAssert.assertNull(requestPost.getBody(), "The body is not null");
        softAssert.assertNull(requestPost.getTitle(), "The title is not null");
    }

    public void checkTitleToBeNotEmpty(PostsPojo requestPost) {
        softAssert.assertFalse(requestPost.getTitle().isEmpty(), "Title is empty");
    }

    public void checkPostsToBeSortedById(PostsPojo[] allPosts) {
        Assert.assertEquals(allPosts[0].getId(), allPosts[1].getId() - 1);
    }

    public void checkCreatedPostToBeEqual(PostsPojo posts) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        String id = Integer.toString(posts.getId());
        String userId = Integer.toString(posts.getUserId());
        System.out.println(posts);
        softAssert.assertTrue(byteArrayOutputStream.toString().contains(posts.getTitle()), "Actual title is " +
                "not the same as in request");
        softAssert.assertTrue(byteArrayOutputStream.toString().contains(posts.getBody()), "Actual body is not " +
                "the same as in request");
        softAssert.assertTrue(byteArrayOutputStream.toString().contains(id), "Actual id is not the " +
                "same as in request");
        softAssert.assertTrue(byteArrayOutputStream.toString().contains(userId), "Actual userId is not the " +
                "same as in request");
        softAssert.assertAll();
        System.setOut(null);
    }
}
