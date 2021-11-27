package me.skiincraft.ichirin.validation.annotation;

import me.skiincraft.ichirin.validation.CheckEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CheckEmailValidator.class)
@Target(value = {ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckNickname {

    String message() default "validation.user.nickname.already";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
