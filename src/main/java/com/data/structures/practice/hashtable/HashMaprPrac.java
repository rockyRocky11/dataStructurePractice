package com.data.structures.practice.hashtable;

import com.data.structures.practice.Employee;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMaprPrac {
    public static void main(String[] args) {
        Employee janeJones= new Employee(1, "Jane", "Jones");
        Employee johnDoe= new Employee(2, "John", "Doe");
        Employee marySmith= new Employee(3, "Mary", "Smith");
        Employee mikeWilson= new Employee(4, "Mike", "Wilson");

        Map<String, Employee> mapPrac = new HashMap<String, Employee>();
        mapPrac.put("Jones", janeJones);
        mapPrac.put("Doe", johnDoe);
        mapPrac.put("Smith", marySmith);
        mapPrac.put("Wilsom", mikeWilson);

        Iterator iterator = mapPrac.values().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        Employee employee = mapPrac.putIfAbsent("Doe", mikeWilson);
        System.out.println("putIfAbsent "+employee);

        mapPrac.forEach((k, v)->System.out.println("Key ="+k+" Employee "+v));

        System.out.println(mapPrac.containsKey("Doe"));
        System.out.println(mapPrac.containsValue(janeJones));
    }
}
