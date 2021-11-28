package me.skiincraft.ichirin.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AuthenticationModel {

    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private long expires;

    public AuthenticationModel(String accessToken, long expires) {
        this.tokenType = "Bearer";
        this.accessToken = accessToken;
        this.expires = expires;
    }
}
