package br.com.reviewraid.reviewraid.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TipoTagsValidator.class)
public @interface TipoTags {
    String message() default "{tags.tipo.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
