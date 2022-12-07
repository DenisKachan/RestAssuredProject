package restAssuredProject.pojo.Users;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class UsersPojo {
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("username")
    String username;
    @SerializedName("email")
    String email;
    @SerializedName("address")
    AddressPojo addressPojo;
    @SerializedName("phone")
    String phone;
    @SerializedName("website")
    String website;
    @SerializedName("company")
    CompanyPojo companyPojo;
}
