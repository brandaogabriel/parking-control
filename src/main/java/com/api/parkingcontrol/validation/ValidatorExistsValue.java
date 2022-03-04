package com.api.parkingcontrol.validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.List;

public class ValidatorExistsValue implements ConstraintValidator<ExistsValue, String> {

    private String atrribut;
    private Class<?> klass;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void initialize(ExistsValue constraintAnnotation) {
        atrribut = constraintAnnotation.fieldName();
        klass = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("SELECT 1 FROM " + klass.getName() + " WHERE " + atrribut + " = :value");
        query.setParameter("value", value);
        List<?> result = query.getResultList();
        return result.isEmpty();
    }
}
