package com.api.parkingcontrol.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = ValidatorExistsValue.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ExistsValue {

    public String message() default "Validation Constraint Error";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};

    public boolean allowNull() default false;

    String fieldName();

    Class<?> domainClass();
}