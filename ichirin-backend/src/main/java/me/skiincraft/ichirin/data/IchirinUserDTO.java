package me.skiincraft.ichirin.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
    private String nickname;

    @NotBlank(message = "validation.user.email")
    @Email(message = "validation.user.email")
    private String email;

    @NotBlank(message = "validation.user.password")
    @Length(min = 8, max = 64, message = "validation.user.password")
    private String password;
    
}
