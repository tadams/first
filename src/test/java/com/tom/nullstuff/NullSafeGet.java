package com.tom.nullstuff;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.tom.nullstuff.Employee.Address;
import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.*;
import static org.junit.Assert.*;

public class NullSafeGet {

    Long employeeId = 1L;

    @Test
    public void shouldThrowNpe() {
        Employee employee = findEmployeeById(employeeId);
        if (employee == null) {
            return;
        }
        Address address = employee.getAddress();
        if (address == null) {
            return;
        }
        String street = employee.getAddress().getStreet();
    }

    public Employee findEmployeeById(Long id) {
        Employee employee = new Employee();
        if (id > 1) {
            employee.address = new Employee.Address();
            if (id > 2) {
                employee.address.setStreet("Main");
            }
        }
        return employee;
    }

    private String getEmployeeStreet1(Long employeeId) {
        Employee employee = findEmployeeById(employeeId);
        if (employee != null) {
            Address address = employee.getAddress();
            if (address != null) {
                String street = address.getStreet();
                if (street != null) {
                    return street;
                }
            }
        }
        return EMPTY;
    }

    private String getEmployeeStreet(Long employeeId) {
        Optional<Employee> employee = Optional.of(findEmployeeById(employeeId));
        return employee.map(Employee::getAddress)
                       .map(Address::getStreet)
                       .orElse(EMPTY);
    }

    public void shouldGetStreetName(Long employeeId, String expectedStreetName) {
        String street = getEmployeeStreet(employeeId);
        assertEquals(expectedStreetName, street);
    }

    @Test
    public void shouldMatchStreetName() {
        shouldGetStreetName(1L, EMPTY);
        shouldGetStreetName(2L, EMPTY);
        shouldGetStreetName(3L, "Main");
        shouldGetStreetName(4L, "Main");
    }

    public static <T> T get(Object target, Supplier<T> supplier) {

        if (Objects.isNull(target)) {
            return null;
        }
        return supplier.get();
    }

}
