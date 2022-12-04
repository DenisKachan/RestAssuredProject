package restAssuredProject.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import restAssuredProject.dto.Users.Users;
import restAssuredProject.projectRequestsAndMethods.CommonRequestsAndMethods;
import restAssuredProject.projectRequestsAndMethods.UsersMethods;

import java.io.FileNotFoundException;

public class UsersTests {

    CommonRequestsAndMethods commonRequestsAndMethods = new CommonRequestsAndMethods(new Users());
    UsersMethods usersMethods = new UsersMethods();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void getAllUsersTest() throws FileNotFoundException {
        Users[] allUsers = (Users[]) commonRequestsAndMethods.getAllEntities(200);
        Users theFifthUser = usersMethods.getUserByIdFromAllUsers(allUsers, 5);
        Users dataFromJsonFile = (Users) commonRequestsAndMethods.getDataFromJsonFile("fifthUser.json");
        usersMethods.checkNameToBeEqual(theFifthUser, dataFromJsonFile);
        usersMethods.checkUsernameToBeEqual(theFifthUser, dataFromJsonFile);
        usersMethods.checkEmailToBeEqual(theFifthUser, dataFromJsonFile);
        usersMethods.checkStreetToBeEqual(theFifthUser, dataFromJsonFile);
        usersMethods.checkSuiteToBeEqual(theFifthUser, dataFromJsonFile);
        usersMethods.checkCityToBeEqual(theFifthUser, dataFromJsonFile);
        usersMethods.checkZipcodeToBeEqual(theFifthUser, dataFromJsonFile);
        usersMethods.checkLatValueToBeEqual(theFifthUser, dataFromJsonFile);
        usersMethods.checkLngValueToBeEqual(theFifthUser, dataFromJsonFile);
        usersMethods.checkPhoneNumbersToBeEqual(theFifthUser, dataFromJsonFile);
        usersMethods.checkWebsiteToBeEqual(theFifthUser, dataFromJsonFile);
        usersMethods.checkCompanyNameToBeEqual(theFifthUser, dataFromJsonFile);
        usersMethods.checkCompanyCatchPhraseToBeEqual(theFifthUser, dataFromJsonFile);
        usersMethods.checkCompanyBsToBeEqual(theFifthUser, dataFromJsonFile);
        softAssert.assertAll();
    }

    @Test
    public void getCertainUserTest() throws FileNotFoundException {
        Users certainUser = (Users) commonRequestsAndMethods.getEntity("5", 200);
        Users dataFromJsonFile = (Users) commonRequestsAndMethods.getDataFromJsonFile("fifthUser.json");
        usersMethods.checkNameToBeEqual(certainUser, dataFromJsonFile);
        usersMethods.checkUsernameToBeEqual(certainUser, dataFromJsonFile);
        usersMethods.checkEmailToBeEqual(certainUser, dataFromJsonFile);
        usersMethods.checkStreetToBeEqual(certainUser, dataFromJsonFile);
        usersMethods.checkSuiteToBeEqual(certainUser, dataFromJsonFile);
        usersMethods.checkCityToBeEqual(certainUser, dataFromJsonFile);
        usersMethods.checkZipcodeToBeEqual(certainUser, dataFromJsonFile);
        usersMethods.checkLatValueToBeEqual(certainUser, dataFromJsonFile);
        usersMethods.checkLngValueToBeEqual(certainUser, dataFromJsonFile);
        usersMethods.checkPhoneNumbersToBeEqual(certainUser, dataFromJsonFile);
        usersMethods.checkWebsiteToBeEqual(certainUser, dataFromJsonFile);
        usersMethods.checkCompanyNameToBeEqual(certainUser, dataFromJsonFile);
        usersMethods.checkCompanyCatchPhraseToBeEqual(certainUser, dataFromJsonFile);
        usersMethods.checkCompanyBsToBeEqual(certainUser, dataFromJsonFile);
        softAssert.assertAll();
    }
}
