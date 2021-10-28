package me.skiincraft.ichirin.data;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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

    public IchirinUserDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
