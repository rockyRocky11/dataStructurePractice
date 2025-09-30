package com.data.structures.practice.hashtable.fundamental;

import com.data.structures.practice.Employee;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainingHashTable {
    private LinkedList<StoredEmployee>[] hashtable;
    public ChainingHashTable(){
        hashtable = new LinkedList[10];
        for(int i=0;i<hashtable.length;i++){
            hashtable[i] = new LinkedList<StoredEmployee>();
        }
    }

    public void put(String key, Employee employee){
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new StoredEmployee(key, employee));
    }

    public Employee get(String key){
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        StoredEmployee employee = null;
        while (iterator.hasNext()){
            employee = iterator.next();
            if (employee.key.equals(key)){
                return employee.employee;
            }
        }
        return null;
    }

    public Employee remove(String key){
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        StoredEmployee employee = null;
        int index = 0;
        while (iterator.hasNext()){
            employee = iterator.next();
            if (employee.key.equals(key)){
                hashtable[hashedKey].remove(index);
                return employee.employee;
            }
            index++;
        }
        return null;
    }

    public void printHasTable(){
        for(int i=0;i< hashtable.length;i++){
            if(hashtable[i].isEmpty()){
                System.out.println("Position ="+i+" is Empty");
            }
            else{
                System.out.println("");
                ListIterator<StoredEmployee> iterator = hashtable[i].listIterator();
                while (iterator.hasNext()){
                    System.out.print(iterator.next().employee);
                    System.out.print("-->");
                }
                System.out.println("null");
            }
        }
    }

    private int hashKey(String key){
        //return key.length() % hashtable.length;
        return Math.abs(key.hashCode()%hashtable.length);
    }

}
