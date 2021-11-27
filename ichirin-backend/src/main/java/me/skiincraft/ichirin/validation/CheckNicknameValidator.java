package me.skiincraft.ichirin.validation;

import me.skiincraft.ichirin.repository.user.IchirinUserRepository;
import me.skiincraft.ichirin.validation.annotation.CheckNickname;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckNicknameValidator implements ConstraintValidator<CheckNickname, String> {

    private final IchirinUserRepository repository;

    @Autowired
    public CheckNicknameValidator(IchirinUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return repository.existsByNickname(value);
    }
}
