package me.seowoo.springbootdeveloper.dto.request;

import lombok.Data;

@Data
public class AddUserRequest {
    private String email;
    private String password;
}
