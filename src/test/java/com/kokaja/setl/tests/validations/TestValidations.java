package com.kokaja.setl.tests.validations;

import com.kokaja.setl.Record;
import com.kokaja.setl.ValidationException;
import com.kokaja.setl.validate.CompositeValidation;
import com.kokaja.setl.Validation;
import com.kokaja.setl.validate.RequiredValidation;
import com.kokaja.setl.validate.TypeValidation;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestValidations {

    private static Record record;

    @BeforeClass
    public static void init() {
        record = new Record();
        record.add("id", 628);
        record.add("firstName", "Homer");
        record.add("lastName", "Simpson");
        record.add("change", 3.50);
    }

    // RequiredValidation

    @Test
    public void testRequiredValidation() throws ValidationException {
        Validation validation = new RequiredValidation();
        validation.validate(record, "id", record.get("id"));
    }

    @Test(expected = ValidationException.class)
    public void testRequiredValidationError() throws ValidationException {
        Validation validation = new RequiredValidation();
        validation.validate(record, "middleName", record.get("middleName"));
    }

    // TypeValidation

    @Test
    public void testTypeValidationInt() throws ValidationException, ClassNotFoundException {
        Validation validation = new TypeValidation("java.lang.Integer");
        validation.validate(record, "id", record.get("id"));
    }

    @Test
    public void testTypeValidationString() throws ValidationException, ClassNotFoundException {
        Validation validation = new TypeValidation("java.lang.String");
        validation.validate(record, "firstName", record.get("firstName"));
    }

    @Test
    public void testTypeValidationDouble() throws ValidationException, ClassNotFoundException {
        Validation validation = new TypeValidation("java.lang.Double");
        validation.validate(record, "change", record.get("change"));
    }

    @Test(expected = ClassNotFoundException.class)
    public void testBadTypeValidation() throws ClassNotFoundException {
        new TypeValidation("org.bad.foo.bar.Type");
    }

    @Test(expected = ValidationException.class)
    public void testWrongTypeInt() throws ValidationException, ClassNotFoundException {
        Validation validation = new TypeValidation("java.lang.Integer");
        validation.validate(record, "firstName", record.get("firstName"));
    }

    @Test(expected = ValidationException.class)
    public void testWrongTypeStr() throws ValidationException, ClassNotFoundException {
        Validation validation = new TypeValidation("java.lang.String");
        validation.validate(record, "change", record.get("change"));
    }

    // CompositeValidation

    @Test
    public void testCompositeValidation() throws ValidationException, ClassNotFoundException {
        Validation typeValidation = new TypeValidation("java.lang.String");
        Validation requiredValidation = new RequiredValidation();

        CompositeValidation compositeValidation = new CompositeValidation();
        compositeValidation.addValidation(requiredValidation);
        compositeValidation.addValidation(typeValidation);

        compositeValidation.validate(record, "firstName", record.get("firstName"));
    }

    @Test(expected = ValidationException.class)
    public void testCompositeValidationRequiredError() throws ValidationException, ClassNotFoundException {
        Validation typeValidation = new TypeValidation("java.lang.String");
        Validation requiredValidation = new RequiredValidation();

        CompositeValidation compositeValidation = new CompositeValidation();
        compositeValidation.addValidation(requiredValidation);
        compositeValidation.addValidation(typeValidation);

        compositeValidation.validate(record, "middleName", record.get("middleName"));
    }

    @Test(expected = ValidationException.class)
    public void testCompositeValidationTypeError() throws ValidationException, ClassNotFoundException {
        Validation typeValidation = new TypeValidation("java.lang.Integer");
        Validation requiredValidation = new RequiredValidation();

        CompositeValidation compositeValidation = new CompositeValidation();
        compositeValidation.addValidation(requiredValidation);
        compositeValidation.addValidation(typeValidation);

        compositeValidation.validate(record, "firstName", record.get("firstName"));
    }
}
