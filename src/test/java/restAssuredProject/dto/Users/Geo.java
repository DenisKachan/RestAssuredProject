package restAssuredProject.dto.Users;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Geo {
    @Expose
    String lat;
    @Expose
    String lng;
}
