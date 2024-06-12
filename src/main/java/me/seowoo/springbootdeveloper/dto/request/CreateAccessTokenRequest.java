package me.seowoo.springbootdeveloper.dto.request;

import lombok.Data;

@Data
public class CreateAccessTokenRequest {
    private String refreshToken;
}
