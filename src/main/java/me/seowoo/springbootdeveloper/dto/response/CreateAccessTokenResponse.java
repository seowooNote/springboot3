package me.seowoo.springbootdeveloper.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateAccessTokenResponse {
    private String accessToken;
}
