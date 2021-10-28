package me.skiincraft.ichirin.data;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class IchirinUserDTO {

    @NotBlank
    @Length(min = 5, max = 40)
    private String name;
    @Length(min = 4, max = 40)
    private String nickname;
    @Email
    private String email;
    @NotBlank
    @Length(min = 8, max = 64)
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
