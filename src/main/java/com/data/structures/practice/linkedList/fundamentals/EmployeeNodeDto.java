package com.data.structures.practice.linkedList.fundamentals;

import com.data.structures.practice.Employee;

public class EmployeeNodeDto {
    Employee employee;

    EmployeeNodeDto next;

    public EmployeeNodeDto(Employee employee){
        this.employee= employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public EmployeeNodeDto getNext() {
        return next;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setNext(EmployeeNodeDto next) {
        this.next = next;
    }

    @Override
    public String  toString() {
        return employee.toString();
    }
}
