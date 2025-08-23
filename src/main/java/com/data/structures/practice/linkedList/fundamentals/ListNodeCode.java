package com.data.structures.practice.linkedList.fundamentals;

public class ListNodeCode {

    private ListNode head;

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    //O(1)
    public void addToFront (int val){
        ListNode node = new ListNode(val);
        node.next=head;
        head = node;
    }

    //O(n)
    public void addToTail (int val){
        ListNode node = new ListNode(val);

        if(head == null){
            head = node;
        }
        ListNode curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next=node;
    }

    public boolean search(int val){
        if(head == null){
            return false;
        }
        ListNode cur = head;

        while(cur != null){
            if(cur.val == val){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void PrintLinkedList(){
        ListNode current = head;
        System.out.print("HEAD -> ");
        while (current != null){
            System.out.print(current.val);
            System.out.print(" -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
