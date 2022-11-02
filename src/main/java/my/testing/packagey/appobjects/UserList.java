package my.testing.packagey.appobjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserList {
    private Integer page;
    @JsonProperty("per_page")
    private Integer perPage;
    private Integer total;
    @JsonProperty("total_pages")
    private Integer totalPages;
    private List<UserData> data;
    private Support support;

    @Data
    private static class UserData {
        private Integer id;
        private String email;
        @JsonProperty("first_name")
        private String firstName;
        @JsonProperty("total_pages")
        private String totalPages;
        private String avatar;
    }

    @Data
    private static class Support {
        private String url;
        private String text;
    }
}
