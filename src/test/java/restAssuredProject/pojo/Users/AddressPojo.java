package restAssuredProject.pojo.Users;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class AddressPojo {
    @SerializedName("street")
    String street;
    @SerializedName("suite")
    String suite;
    @SerializedName("zipcode")
    String zipcode;
    @SerializedName("geo")
    GeoPojo geoPojo;
    @SerializedName("city")
    String city;
}
