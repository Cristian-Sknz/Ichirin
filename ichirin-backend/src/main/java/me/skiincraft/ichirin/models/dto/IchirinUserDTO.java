package me.skiincraft.ichirin.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.skiincraft.ichirin.validation.annotation.CheckEmail;
import me.skiincraft.ichirin.validation.annotation.CheckNickname;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class IchirinUserDTO {

    @NotBlank(message = "validation.user.name")
    @Length(min = 5, max = 40)
    private String name;

    @NotBlank(message = "validation.user.nickname")
    @Length(min = 4, max = 40, message = "validation.user.nickname.length")
    @CheckNickname
    private String nickname;

    @NotBlank(message = "validation.user.email")
    @Email(message = "validation.user.email")
    @CheckEmail
    private String email;

    @NotBlank(message = "validation.user.password")
    @Length(min = 8, max = 64, message = "validation.user.password")
    private String password;
    
}
