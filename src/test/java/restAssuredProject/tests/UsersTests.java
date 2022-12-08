package restAssuredProject.tests;

import framework.utils.JSONReader;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import restAssuredProject.pojo.Users.UsersPojo;
import restAssuredProject.projectRequestsAndMethods.CommonRequestsAndMethods;
import restAssuredProject.projectRequestsAndMethods.Users;

import java.io.FileNotFoundException;

public class UsersTests {

    CommonRequestsAndMethods commonRequestsAndMethods = new CommonRequestsAndMethods(new UsersPojo());
    JSONReader jsonReader = new JSONReader(new UsersPojo());
    Users users = new Users();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void getAllUsersTest() throws FileNotFoundException {
        UsersPojo[] allUsers = (UsersPojo[]) commonRequestsAndMethods.getAllEntities(200);
        UsersPojo theFifthUser = users.getUserByIdFromAllUsers(allUsers, 5);
        UsersPojo dataFromJsonFile = (UsersPojo) jsonReader.getDataFromJsonFile("fifthUser.json");
        users.checkNameToBeEqual(theFifthUser, dataFromJsonFile);
        users.checkUsernameToBeEqual(theFifthUser, dataFromJsonFile);
        users.checkEmailToBeEqual(theFifthUser, dataFromJsonFile);
        users.checkStreetToBeEqual(theFifthUser, dataFromJsonFile);
        users.checkSuiteToBeEqual(theFifthUser, dataFromJsonFile);
        users.checkCityToBeEqual(theFifthUser, dataFromJsonFile);
        users.checkZipcodeToBeEqual(theFifthUser, dataFromJsonFile);
        users.checkLatValueToBeEqual(theFifthUser, dataFromJsonFile);
        users.checkLngValueToBeEqual(theFifthUser, dataFromJsonFile);
        users.checkPhoneNumbersToBeEqual(theFifthUser, dataFromJsonFile);
        users.checkWebsiteToBeEqual(theFifthUser, dataFromJsonFile);
        users.checkCompanyNameToBeEqual(theFifthUser, dataFromJsonFile);
        users.checkCompanyCatchPhraseToBeEqual(theFifthUser, dataFromJsonFile);
        users.checkCompanyBsToBeEqual(theFifthUser, dataFromJsonFile);
        softAssert.assertAll();
    }

    @Test
    public void getCertainUserTest() throws FileNotFoundException {
        UsersPojo certainUser = (UsersPojo) commonRequestsAndMethods.getEntity("5", 200);
        UsersPojo dataFromJsonFile = (UsersPojo) jsonReader.getDataFromJsonFile("fifthUser.json");
        users.checkNameToBeEqual(certainUser, dataFromJsonFile);
        users.checkUsernameToBeEqual(certainUser, dataFromJsonFile);
        users.checkEmailToBeEqual(certainUser, dataFromJsonFile);
        users.checkStreetToBeEqual(certainUser, dataFromJsonFile);
        users.checkSuiteToBeEqual(certainUser, dataFromJsonFile);
        users.checkCityToBeEqual(certainUser, dataFromJsonFile);
        users.checkZipcodeToBeEqual(certainUser, dataFromJsonFile);
        users.checkLatValueToBeEqual(certainUser, dataFromJsonFile);
        users.checkLngValueToBeEqual(certainUser, dataFromJsonFile);
        users.checkPhoneNumbersToBeEqual(certainUser, dataFromJsonFile);
        users.checkWebsiteToBeEqual(certainUser, dataFromJsonFile);
        users.checkCompanyNameToBeEqual(certainUser, dataFromJsonFile);
        users.checkCompanyCatchPhraseToBeEqual(certainUser, dataFromJsonFile);
        users.checkCompanyBsToBeEqual(certainUser, dataFromJsonFile);
        softAssert.assertAll();
    }
}
