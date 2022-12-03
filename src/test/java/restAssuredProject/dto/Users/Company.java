package restAssuredProject.dto.Users;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Company {
    @Expose
    String name;
    @Expose
    String catchPhrase;
    @Expose
    String bs;
}
