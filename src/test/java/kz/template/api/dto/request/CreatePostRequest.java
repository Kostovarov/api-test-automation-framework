package kz.template.api.dto.request;

import lombok.Data;

@Data
public class CreatePostRequest {

    private String title;
    private String body;
    private int userId;
}