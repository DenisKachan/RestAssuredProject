package restAssuredProject.dto.Users;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Users {
    @Expose
    int id;
    @Expose
    String name;
    @Expose
    String username;
    @Expose
    String email;
    @Expose
    Address address;
    @Expose
    String phone;
    @Expose
    String website;
    @Expose
    Company company;
}
