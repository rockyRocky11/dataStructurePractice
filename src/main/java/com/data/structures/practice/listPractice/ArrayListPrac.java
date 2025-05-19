package com.data.structures.practice.listPractice;

import com.data.structures.practice.Employee;

import java.util.List;
import java.util.Vector;

public class ArrayListPrac {

    public static void main(String[] args) {
        List employeeList = new Vector();
        employeeList.add(new Employee(1,"vivek","dev"));
        employeeList.add(new Employee(2,"vivek2","dev1"));
        employeeList.add(new Employee(3,"vivek3","dev2"));
        employeeList.add(new Employee(4,"vivek4","dev3"));

        employeeList.set(3, new Employee(3, "vivek5", "dev5"));
        employeeList.forEach(emp -> System.out.println(emp));
        System.out.println(employeeList.contains(new Employee(3, "vivek5", "dev5")));

    }
}
