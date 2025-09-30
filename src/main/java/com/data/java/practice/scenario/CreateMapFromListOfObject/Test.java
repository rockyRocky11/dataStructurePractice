package com.data.java.practice.scenario.CreateMapFromListOfObject;

import java.time.LocalTime;
import java.util.*;

public class Test {

    public static void main(String[] args) {
        List<Order> orderList = Arrays.asList(new Order("123TY", Arrays.asList(new Product("5FG", 12344, true)
                        , new Product("56FG", 123944, false)), 1343, LocalTime.now().minusHours(1))
                , new Order("124TY", Arrays.asList(new Product("56FG", 123447, true)
                        , new Product("562FG", 1231447, true)), 1343, LocalTime.now().minusHours(2))
        ,new Order("124TY", Arrays.asList(new Product("56FG", 123447, true)
                , new Product("562FG", 1231447, true)), 1343, LocalTime.now().minusHours(26)));
        List<Order> neworderList=orderList.stream().filter(order -> order.orderTime.isAfter(LocalTime.now().minusHours(24))).toList();
        System.out.println(orderList);
    }


}
