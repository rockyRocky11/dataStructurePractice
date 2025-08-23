package com.data.structures.practice.linkedList.fundamentals;

import com.data.structures.practice.Employee;

public class EmployeeDoublyNodeDto {
    Employee employee;

    EmployeeDoublyNodeDto next;
    EmployeeDoublyNodeDto previous;

    @Override
    public String toString() {
        return
                "employee=" + employee.toString() ;
    }

    public EmployeeDoublyNodeDto getPrevious() {
        return previous;
    }

    public void setPrevious(EmployeeDoublyNodeDto previous) {
        this.previous = previous;
    }

    public EmployeeDoublyNodeDto(Employee employee){
        this.employee= employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public EmployeeDoublyNodeDto getNext() {
        return next;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setNext(EmployeeDoublyNodeDto next) {
        this.next = next;
    }


}
