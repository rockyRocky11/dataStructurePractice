package com.data.structures.practice.hashtable;

import com.data.structures.practice.Employee;

public class StoredEmployee {
    public String key;
    public Employee employee;

    public StoredEmployee(String key, Employee employee) {
        this.key = key;
        this.employee = employee;
    }
}
