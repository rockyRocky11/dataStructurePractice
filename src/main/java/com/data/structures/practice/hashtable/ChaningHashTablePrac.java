package com.data.structures.practice.hashtable;

import com.data.structures.practice.Employee;

public class ChaningHashTablePrac {
    public static void main(String[] args) {
        ChainingHashTable list = new ChainingHashTable();
        Employee janeJones= new Employee(1, "Jane", "Jones");
        Employee johnDoe= new Employee(2, "John", "Doe");
        Employee marySmith= new Employee(3, "Mary", "Smith");
        Employee mikeWilson= new Employee(4, "Mike", "Wilson");

        list.put("Jones", janeJones);
        list.put("Doe", johnDoe);
        list.put("Smith", marySmith);
        list.put("Wilson", mikeWilson);

        list.printHasTable();

        System.out.println("Retrieve Key Smith: "+list.get("Smith"));
        list.remove("Doe");
        list.remove("Jones");
        list.printHasTable();
        System.out.println("Retrieve Key Smith: "+list.get("Smith"));

    }
}
