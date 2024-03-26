package br.com.reviewraid.reviewraid.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoTagsValidator implements ConstraintValidator<TipoTags, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equals("JOGO") || value.equals("TAG");
    }

}
