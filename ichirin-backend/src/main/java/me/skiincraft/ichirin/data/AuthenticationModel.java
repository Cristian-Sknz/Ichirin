package me.skiincraft.ichirin.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

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

    public AuthenticationModel(String accessToken, OffsetDateTime expires) {
        this(accessToken, ChronoUnit.SECONDS.between(OffsetDateTime.now(), expires));
    }

    public AuthenticationModel(String accessToken, long expires) {
        this.tokenType = "Bearer";
        this.accessToken = accessToken;
        this.expires = expires;
    }
}
