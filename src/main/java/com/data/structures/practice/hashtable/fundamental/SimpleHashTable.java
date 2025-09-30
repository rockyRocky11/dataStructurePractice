package com.data.structures.practice.hashtable.fundamental;

import com.data.structures.practice.Employee;

public class  SimpleHashTable {
    private StoredEmployee[] hashtable;
    private SimpleHashTable(){
        hashtable = new StoredEmployee[10];
    }

    private int hashKey(String key){
        return key.length() % hashtable.length;
    }

    public void put(String key, Employee employee){
        int hashedKey = hashKey(key);
        if(occupied(hashedKey)){
            //This is to stop after wraping
            int stopIndex = hashedKey;
            //this if else only sets the first probe position
            if (hashedKey == hashtable.length-1){
                hashedKey = 0;
            }
            else{
                hashedKey++;
            }
            while(occupied(hashedKey) && hashedKey != stopIndex){
                //This formula make sure we wrap the array
                hashedKey = (hashedKey+1)%hashtable.length;
            }
        }
        if(occupied(hashedKey)){
            System.out.println("This is occupied"+hashedKey);
        }
        else {
            hashtable[hashedKey] = new StoredEmployee(key, employee);
        } 
    }

    public StoredEmployee get(String key){
        int hashKey = findKey(key);
        if(hashKey == -1){
            return null;
        }
        return hashtable[hashKey];
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null &&
                hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }
        //This is to stop after wraping
        int stopIndex = hashedKey;
        //this if else only sets the first probe position
        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }
        while (hashedKey != stopIndex && hashtable[hashedKey] != null && !hashtable[hashedKey].key.equals(key)) {
            //This formula make sure we wrap the array
            hashedKey = (hashedKey + 1) % hashtable.length;
        }
        if(hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)){
            return hashedKey;
        }
        else {
            return -1;
        }
    }

    public Employee remove(String key){
        int hashKey = findKey(key);
        if(hashKey == -1){
            return null;
        }
        StoredEmployee removeStroredEmployee =hashtable[hashKey];
        hashtable[hashKey]=null;
        StoredEmployee[] oldHashTables = hashtable;
        hashtable = new StoredEmployee[oldHashTables.length];
        for(int i=0;i< oldHashTables.length;i++){
            if(oldHashTables[i] != null) {
                put(oldHashTables[i].key, oldHashTables[i].employee);
            }
        }
        return removeStroredEmployee.employee;
    }

    public void printHashTable(){
        for(int i=0; i< hashtable.length;i++){
            System.out.println(hashtable[i]);
        }
    }

    private boolean occupied(int index){
        return hashtable[index] != null;
    }
}
