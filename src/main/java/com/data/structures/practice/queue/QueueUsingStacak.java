package com.data.structures.practice.queue;

import java.util.Stack;

public class QueueUsingStacak {

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();

        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.pop());
        myQueue.push(5);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());

//        myQueue.push(1);
//        myQueue.push(2);
//        System.out.println(myQueue.peek());
//        System.out.println(myQueue.pop());
//        System.out.println(myQueue.empty());

//        myQueue.push(1);
//        System.out.println(myQueue.pop());
//        System.out.println(myQueue.empty());


    }

    static class MyQueue {

        Stack<Integer> first = new Stack<>();
        Stack<Integer> last = new Stack<>();
        ;

        public MyQueue() {

        }

        public void push(int x) {

            if (first.isEmpty()) {
                last.push(x);
                first.push(last.peek());
            }else{
                last.push(x);
            }

        }

        public int pop() {

            if(!first.isEmpty()){
                int curr  =first.pop();
                last.remove(0);
                if(!last.isEmpty()){
                    first.push(last.get(0));
                }
//                Object[] lastArray = last.toArray();
//                for(int i=0;i<lastArray.length;i++){
//                    int temp = (int)lastArray[i];
//                    if(temp!= curr){
//                        first.push(temp);
//                        break;
//                    }
//                }

                return curr;

            }
            return -1;
        }

        public int peek() {
            if(!first.isEmpty()){
                return first.peek();

            }
            return -1;
        }

        public boolean empty() {
            return first.isEmpty();
        }
    }

}
