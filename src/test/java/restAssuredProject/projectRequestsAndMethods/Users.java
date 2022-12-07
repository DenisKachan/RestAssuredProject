package restAssuredProject.projectRequestsAndMethods;

import org.testng.asserts.SoftAssert;
import restAssuredProject.pojo.Users.UsersPojo;

public class Users {

    private SoftAssert softAssert = new SoftAssert();

    public void checkNameToBeEqual(UsersPojo requestUser, UsersPojo dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getName(), dataFromJsonFile.getName(), "Names are different");
    }

    public void checkUsernameToBeEqual(UsersPojo requestUser, UsersPojo dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getUsername(), dataFromJsonFile.getUsername(),
                "Usernames are different");
    }

    public void checkEmailToBeEqual(UsersPojo requestUser, UsersPojo dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getEmail(), dataFromJsonFile.getEmail(),
                "Emails are different");
    }

    public void checkStreetToBeEqual(UsersPojo requestUser, UsersPojo dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getAddressPojo().getStreet(),
                dataFromJsonFile.getAddressPojo().getStreet(), "Streets are different");
    }

    public void checkSuiteToBeEqual(UsersPojo requestUser, UsersPojo dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getAddressPojo().getSuite(), dataFromJsonFile.getAddressPojo().getSuite(),
                "Suites are different");
    }

    public void checkCityToBeEqual(UsersPojo requestUser, UsersPojo dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getAddressPojo().getCity(), dataFromJsonFile.getAddressPojo().getCity(),
                "Cities are different");
    }

    public void checkZipcodeToBeEqual(UsersPojo requestUser, UsersPojo dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getAddressPojo().getZipcode(), dataFromJsonFile.getAddressPojo().getZipcode(),
                "Zipcodes are different");
    }

    public void checkLatValueToBeEqual(UsersPojo requestUser, UsersPojo dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getAddressPojo().getGeoPojo().getLat(),
                dataFromJsonFile.getAddressPojo().getGeoPojo().getLat(), "Lat values are different");
    }

    public void checkLngValueToBeEqual(UsersPojo requestUser, UsersPojo dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getAddressPojo().getGeoPojo().getLng(),
                dataFromJsonFile.getAddressPojo().getGeoPojo().getLng(), "Lng values are different");
    }

    public void checkPhoneNumbersToBeEqual(UsersPojo requestUser, UsersPojo dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getPhone(), dataFromJsonFile.getPhone(),
                "Phone numbers are different");
    }

    public void checkWebsiteToBeEqual(UsersPojo requestUser, UsersPojo dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getWebsite(), dataFromJsonFile.getWebsite(),
                "Websites are different");
    }

    public void checkCompanyNameToBeEqual(UsersPojo requestUser, UsersPojo dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getCompanyPojo().getName(), dataFromJsonFile.getCompanyPojo().getName(),
                "Company names are different");
    }

    public void checkCompanyCatchPhraseToBeEqual(UsersPojo requestUser, UsersPojo dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getCompanyPojo().getCatchPhrase(),
                dataFromJsonFile.getCompanyPojo().getCatchPhrase(), "Company catch phrases are different");
    }

    public void checkCompanyBsToBeEqual(UsersPojo requestUser, UsersPojo dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getCompanyPojo().getBs(), dataFromJsonFile.getCompanyPojo().getBs(),
                "Bs values are different");
    }

    public UsersPojo getUserByIdFromAllUsers(UsersPojo[] users, int id) {
        UsersPojo certainUser = null;
        for (UsersPojo user : users) {
            if (user.getId() == id) {
                certainUser = user;
            }
        }
        return certainUser;
    }
}
