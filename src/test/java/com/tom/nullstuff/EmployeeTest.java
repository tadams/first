package com.tom.nullstuff;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.fail;

public class EmployeeTest {

    Employee employee;

    @Test
    public void shouldUseMethod() {
        employee.isRaiseDue();
    }

    @Test
    public void shouldSortEmployees() {
        Employee tom = new Employee().withName("Tom", "Adams", null);
        Employee ian = new Employee().withName("Ian", "Adams", null);
        Employee ian4 = new Employee().withName("Ian", "Adams", null);
        Employee ian2 = new Employee().withName("Ian", "Adams", "Ambros");
        Employee ian3 = new Employee().withName("Ian", "Adams", "Zebra");

        List<Employee> employees = Arrays.asList(ian4, tom, ian2, ian, ian3);
        Collections.sort(employees);
        if (employees.get(0) == ian || employees.get(0) == ian4) {
            return;
        }
        fail();
    }

}
