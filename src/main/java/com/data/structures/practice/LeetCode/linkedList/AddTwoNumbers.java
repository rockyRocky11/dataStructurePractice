package com.data.structures.practice.LeetCode.linkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNodeCode listNodeCode = new ListNodeCode();
//        listNodeCode.addToFront(3);
//        listNodeCode.addToFront(4);
//        listNodeCode.addToFront(2);
        listNodeCode.addToFront(9);
        listNodeCode.addToFront(9);
        listNodeCode.addToFront(9);
        listNodeCode.addToFront(9);
        listNodeCode.addToFront(9);
        listNodeCode.addToFront(9);
        listNodeCode.addToFront(9);
        ListNodeCode listNodeCode1 = new ListNodeCode();
//        listNodeCode1.addToFront(4);
//        listNodeCode1.addToFront(6);
//        listNodeCode1.addToFront(5);
        listNodeCode1.addToFront(9);
        listNodeCode1.addToFront(9);
        listNodeCode1.addToFront(9);
        listNodeCode1.addToFront(9);

        listNodeCode.PrintLinkedList();
        listNodeCode1.PrintLinkedList();
        ListNode node = addTwoNumbers(listNodeCode.getHead(), listNodeCode1.getHead());
        listNodeCode.PrintLinkedList(node);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode responseNode = new ListNode(0);
        ListNode tempResponseNode = responseNode;
        int carry=0;
        while(l1 !=null || l2 !=null|| carry !=0){
            int l1Val = 0;
            if(l1 !=null){
                l1Val = l1.val;
                l1=l1.next;

            }
            int l2Val = 0;
            if(l2 !=null){
                l2Val = l2.val;
                l2=l2.next;

            }
            int sum = l1Val+ l2Val+carry;
            carry=sum/10;
            tempResponseNode.next=new ListNode(sum%10);
            tempResponseNode = tempResponseNode.next;
        }
        return responseNode.next;
    }





    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        ListNode responseNode1 = new ListNode(0);
        ListNode responseNode2 = new ListNode(0);
        ListNode responseNode3 = new ListNode(0);
        ListNode responseNode = responseNode1;
        ListNode leftOverNode = responseNode2;
        ListNode leftOverNode2 = responseNode3;
        int[] carryArray ={0};
         addRecursive( l1,  l2,  responseNode, carryArray, leftOverNode);
        ListNode leftOverNode3 = leftOverNode.next;
         while(leftOverNode3.next!= null){
             int sum = leftOverNode3.val+ carryArray[0];
             carryArray[0]=sum/10;
             leftOverNode2.next = new ListNode(sum%10);
             leftOverNode2 = leftOverNode2.next;
             leftOverNode3 = leftOverNode3.next;
         }
        leftOverNode2.next= responseNode.next;
         return responseNode3.next;
    }

    public static ListNode addRecursive(ListNode l1, ListNode l2, ListNode responseNode, int[] carryArray, ListNode leftOverNode) {
        if(l1 == null || l2 == null){
            addLeftOvers(leftOverNode,  l1==null?l2:l1, carryArray);
            return responseNode;
        }

        responseNode =addRecursive(l1.next, l2.next, responseNode, carryArray, leftOverNode);
        System.out.println(carryArray[0]);
        int sum = l1.val+ l2.val+carryArray[0];
        carryArray[0]=sum/10;
        responseNode.next=new ListNode(sum%10);
        //responseNode= responseNode.next;
        return responseNode.next;
    }

    public static void addLeftOvers(ListNode leftOverNode, ListNode remainingNode, int[] carryArray) {

        while(remainingNode !=null){

            int sum = remainingNode.val+ carryArray[0];
            carryArray[0]=sum/10;
            leftOverNode.next = new ListNode(sum%10);
            leftOverNode = leftOverNode.next;
            remainingNode = remainingNode.next;

        }

    }
}
