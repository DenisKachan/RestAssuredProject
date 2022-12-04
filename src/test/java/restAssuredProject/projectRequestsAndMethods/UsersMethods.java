package restAssuredProject.projectRequestsAndMethods;

import org.testng.asserts.SoftAssert;
import restAssuredProject.dto.Users.Users;

public class UsersMethods {

    private SoftAssert softAssert = new SoftAssert();

    public void checkNameToBeEqual(Users requestUser, Users dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getName(), dataFromJsonFile.getName(), "Names are different");
    }

    public void checkUsernameToBeEqual(Users requestUser, Users dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getUsername(), dataFromJsonFile.getUsername(),
                "Usernames are different");
    }

    public void checkEmailToBeEqual(Users requestUser, Users dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getEmail(), dataFromJsonFile.getEmail(),
                "Emails are different");
    }

    public void checkStreetToBeEqual(Users requestUser, Users dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getAddress().getStreet(),
                dataFromJsonFile.getAddress().getStreet(), "Streets are different");
    }

    public void checkSuiteToBeEqual(Users requestUser, Users dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getAddress().getSuite(), dataFromJsonFile.getAddress().getSuite(),
                "Suites are different");
    }

    public void checkCityToBeEqual(Users requestUser, Users dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getAddress().getCity(), dataFromJsonFile.getAddress().getCity(),
                "Cities are different");
    }

    public void checkZipcodeToBeEqual(Users requestUser, Users dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getAddress().getZipcode(), dataFromJsonFile.getAddress().getZipcode(),
                "Zipcodes are different");
    }

    public void checkLatValueToBeEqual(Users requestUser, Users dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getAddress().getGeo().getLat(),
                dataFromJsonFile.getAddress().getGeo().getLat(), "Lat values are different");
    }

    public void checkLngValueToBeEqual(Users requestUser, Users dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getAddress().getGeo().getLng(),
                dataFromJsonFile.getAddress().getGeo().getLng(), "Lng values are different");
    }

    public void checkPhoneNumbersToBeEqual(Users requestUser, Users dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getPhone(), dataFromJsonFile.getPhone(),
                "Phone numbers are different");
    }

    public void checkWebsiteToBeEqual(Users requestUser, Users dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getWebsite(), dataFromJsonFile.getWebsite(),
                "Websites are different");
    }

    public void checkCompanyNameToBeEqual(Users requestUser, Users dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getCompany().getName(), dataFromJsonFile.getCompany().getName(),
                "Company names are different");
    }

    public void checkCompanyCatchPhraseToBeEqual(Users requestUser, Users dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getCompany().getCatchPhrase(),
                dataFromJsonFile.getCompany().getCatchPhrase(), "Company catch phrases are different");
    }

    public void checkCompanyBsToBeEqual(Users requestUser, Users dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getCompany().getBs(), dataFromJsonFile.getCompany().getBs(),
                "Bs values are different");
    }

    public Users getUserByIdFromAllUsers(Users[] users, int id) {
        Users certainUser = null;
        for (Users user : users) {
            if (user.getId() == id) {
                certainUser = user;
            }
        }
        return certainUser;
    }
}
