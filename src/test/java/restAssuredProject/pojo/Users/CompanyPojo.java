package restAssuredProject.pojo.Users;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CompanyPojo {
    @SerializedName("name")
    String name;
    @SerializedName("catchPhrase")
    String catchPhrase;
    @SerializedName("bs")
    String bs;
}
