package restAssuredProject.dto.Posts;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Posts {
    @Expose
    int userId;
    @Expose
    int id;
    @Expose
    String title;
    @Expose
    String body;
}
