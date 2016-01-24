package com.tom.nullstuff;


import lombok.Data;

import java.util.Comparator;

import static org.apache.commons.lang3.StringUtils.EMPTY;

@Data
public class Employee implements Comparable<Employee> {

    String firstName;
    String middleName;
    String lastName;

    Comparator<String>   nullFirstCompare = Comparator.nullsFirst(String::compareTo);
    Comparator<Employee> comparator       = Comparator.comparing(Employee::getLastName)
                                                      .thenComparing(Employee::getFirstName)
                                                      .thenComparing(Employee::getMiddleName, nullFirstCompare);

    @Override
    public int compareTo(Employee other) {
        return comparator.compare(this, other);
    }

    //@Override
    public int vcompareTo(Employee other) {
        int returnCode = firstName.compareTo(other.getFirstName());
        if (returnCode != 0) {
        return returnCode;
    }
    returnCode = lastName.compareTo(other.getLastName());
    if (returnCode != 0) {
        return returnCode;
    }
    String thisMiddleName  = nullToEmpty(middleName);
    String otherMiddleName = nullToEmpty(other.getMiddleName());
    return thisMiddleName.compareTo(otherMiddleName);
}
    
private String nullToEmpty(String value) {
    return value == null ? EMPTY : value;
}



    @Data
    public static class Address {
        String street;
    }

    JobRole jobRole;

    Address address;

    public boolean isRaiseDue() {
        return jobRole.isUnderSalaryBand() ||
               jobRole.isHighTurnOverRole();
    }

    public Employee withName(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.middleName = middleName;
        return this;
    }
}
