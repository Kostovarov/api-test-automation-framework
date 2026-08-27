package kz.template.api.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatePostResponse {

    private int id;
    private String title;
    private String body;
    private int userId;
}