package me.skiincraft.ichirin.validation;

import me.skiincraft.ichirin.repository.user.IchirinUserRepository;
import me.skiincraft.ichirin.validation.annotation.CheckEmail;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckEmailValidator implements ConstraintValidator<CheckEmail, String> {

    private final IchirinUserRepository repository;

    @Autowired
    public CheckEmailValidator(IchirinUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !repository.existsByEmail(value);
    }
}
