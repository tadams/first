package com.tom.func;

import com.tom.nullstuff.Employee;
import lombok.NonNull;
import org.junit.Test;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class FailFastWhenNull {

    @Test
    public void testAnnotation() {
        generatePaycheck(null);
        noNulls(null);
    }

    public class ErrorMsgProducer {
        public String getNullMessage(String field){ return"";}
    }

    public void generatePaycheck(Employee employee) {

        ErrorMsgProducer errorMsgProducer = new ErrorMsgProducer();

        // throws a NullPointerException when null
        requireNonNull(employee);

        // throws a NullPointerException with a message
        requireNonNull(employee, "employee reference is null");

        // throws a NullPointerException with a message from a supplier function
        requireNonNull(employee, () -> errorMsgProducer.getNullMessage("employee"));

        // do paycheck stuff ...
    }

    public void noNulls(@NonNull String nonNull) {
        System.out.println(nonNull);
    }

}
