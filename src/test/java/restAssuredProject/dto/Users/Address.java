package restAssuredProject.dto.Users;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Address {
    @Expose
    String street;
    @Expose
    String suite;
    @Expose
    String zipcode;
    @Expose
    Geo geo;
    @Expose
    String city;
}
