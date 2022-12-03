package restAssuredProject.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import restAssuredProject.dto.Users.Users;
import restAssuredProject.projectRequestsAndMethods.RequestsAndMethodsForUsers;

import java.io.FileNotFoundException;

public class UsersTests {

    RequestsAndMethodsForUsers requestsAndMethodsForUsers = new RequestsAndMethodsForUsers();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void getAllUsersTest() throws FileNotFoundException {
        Users[] allUsers = requestsAndMethodsForUsers.getAllUsers(200);
        Users theFifthUser = null;
        for (Users users : allUsers) {
            if (users.getId() == 5) {
                theFifthUser = users;
            }
        }
        Users dataFromJsonFile = requestsAndMethodsForUsers.getDataFromJsonFile("fifthUser.json");
        softAssert.assertEquals(theFifthUser.getName(), dataFromJsonFile.getName(), "Names are different");
        softAssert.assertEquals(theFifthUser.getUsername(), dataFromJsonFile.getUsername(),
                "Usernames are different");
        softAssert.assertEquals(theFifthUser.getEmail(), dataFromJsonFile.getEmail(),
                "Emails are different");
        softAssert.assertEquals(theFifthUser.getAddress().getStreet(),
                dataFromJsonFile.getAddress().getStreet(), "Streets are different");
        softAssert.assertEquals(theFifthUser.getAddress().getSuite(), dataFromJsonFile.getAddress().getSuite(),
                "Suites are different");
        softAssert.assertEquals(theFifthUser.getAddress().getCity(), dataFromJsonFile.getAddress().getCity(),
                "Cities are different");
        softAssert.assertEquals(theFifthUser.getAddress().getZipcode(), dataFromJsonFile.getAddress().getZipcode(),
                "Zipcodes are different");
        softAssert.assertEquals(theFifthUser.getAddress().getGeo().getLat(),
                dataFromJsonFile.getAddress().getGeo().getLat(), "Lat values are different");
        softAssert.assertEquals(theFifthUser.getAddress().getGeo().getLng(),
                dataFromJsonFile.getAddress().getGeo().getLng(), "Lng values are different");
        softAssert.assertEquals(theFifthUser.getPhone(), dataFromJsonFile.getPhone(),
                "Phone numbers are different");
        softAssert.assertEquals(theFifthUser.getWebsite(), dataFromJsonFile.getWebsite(),
                "Websites are different");
        softAssert.assertEquals(theFifthUser.getCompany().getName(), dataFromJsonFile.getCompany().getName(),
                "Company names are different");
        softAssert.assertEquals(theFifthUser.getCompany().getCatchPhrase(),
                dataFromJsonFile.getCompany().getCatchPhrase(), "Company catch phrases are different");
        softAssert.assertEquals(theFifthUser.getCompany().getBs(), dataFromJsonFile.getCompany().getBs(),
                "Bs values are different");
        softAssert.assertAll();
    }

    @Test
    public void getCertainUserTest() throws FileNotFoundException {
        Users certainUser = requestsAndMethodsForUsers.getUser("5", 200);
        Users dataFromJsonFile = requestsAndMethodsForUsers.getDataFromJsonFile("fifthUser.json");
        softAssert.assertEquals(certainUser.getName(), dataFromJsonFile.getName(), "Names are different");
        softAssert.assertEquals(certainUser.getUsername(), dataFromJsonFile.getUsername(),
                "Usernames are different");
        softAssert.assertEquals(certainUser.getEmail(), dataFromJsonFile.getEmail(),
                "Emails are different");
        softAssert.assertEquals(certainUser.getAddress().getStreet(),
                dataFromJsonFile.getAddress().getStreet(), "Streets are different");
        softAssert.assertEquals(certainUser.getAddress().getSuite(), dataFromJsonFile.getAddress().getSuite(),
                "Suites are different");
        softAssert.assertEquals(certainUser.getAddress().getCity(), dataFromJsonFile.getAddress().getCity(),
                "Cities are different");
        softAssert.assertEquals(certainUser.getAddress().getZipcode(), dataFromJsonFile.getAddress().getZipcode(),
                "Zipcodes are different");
        softAssert.assertEquals(certainUser.getAddress().getGeo().getLat(),
                dataFromJsonFile.getAddress().getGeo().getLat(), "Lat values are different");
        softAssert.assertEquals(certainUser.getAddress().getGeo().getLng(),
                dataFromJsonFile.getAddress().getGeo().getLng(), "Lng values are different");
        softAssert.assertEquals(certainUser.getPhone(), dataFromJsonFile.getPhone(),
                "Phone numbers are different");
        softAssert.assertEquals(certainUser.getWebsite(), dataFromJsonFile.getWebsite(),
                "Websites are different");
        softAssert.assertEquals(certainUser.getCompany().getName(), dataFromJsonFile.getCompany().getName(),
                "Company names are different");
        softAssert.assertEquals(certainUser.getCompany().getCatchPhrase(),
                dataFromJsonFile.getCompany().getCatchPhrase(), "Company catch phrases are different");
        softAssert.assertEquals(certainUser.getCompany().getBs(), dataFromJsonFile.getCompany().getBs(),
                "Bs values are different");
        softAssert.assertAll();
    }
}
