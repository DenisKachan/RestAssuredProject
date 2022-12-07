package restAssuredProject.pojo.Users;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class GeoPojo {
    @SerializedName("lat")
    String lat;
    @SerializedName("lng")
    String lng;
}
