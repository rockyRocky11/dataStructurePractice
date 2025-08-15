package com.data.structures.practice.bitmanipulation;

public class Practice {
    public static void main(String[] args) {
        testingSomeTricks();
        bitwiseMaskPattern();
        practiceStringFormating();
        someDataTypeWithExample();
    }

    static void testingSomeTricks() {
        TASKS();
        OR();
        AND();
        NOT();
        XOR();
    }
    static void TASKS() {
        System.out.println("--------------TASKS Practice------------------");
        getTask();
        setTask();
        clearBit();
        updateBit();
    }

    public static void getTask() {
        System.out.println();
        System.out.println("     --------getTask---------     ");
        int num=0b10101;
        int num1=0b10001;

        int i=2;
        boolean b = (num & (1 << i)) != 0;
        System.out.println(b?1:0);
        boolean b1 = (num1 & (1 << i)) != 0;
        System.out.println(b1?1:0);
    }

    public static void setTask() {
        System.out.println();
        System.out.println("     --------setTask---------     ");
        int num=0b10101;
        System.out.println(num);
        int num1=0b10001;
        System.out.println(num1);


        int i=2;
        int b = (num | (1 << i)) ;
        System.out.println(b);
        int b1 = (num1 | (1 << i)) ;
        System.out.println(b1);
    }

    public static void updateBit() {
        System.out.println();
        System.out.println("     --------updateBit---------     ");
        int num = 0b10101;
        System.out.println(num);


        int i = 2;
        int v=0;
        int b = (num & ~(1 << i));
        System.out.println(b);
        int b1 = (b | (v << i));
        System.out.println(b1);
    }
    public static void clearBit() {
        System.out.println();
        System.out.println("     --------clearBit---------     ");
        int num=0b10101;
        System.out.println(num);
        int num1=0b10001;
        System.out.println(num1);


        int i=2;
        int b = (num & ~(1 << i)) ;
        System.out.println(b);
        int b1 = (num1 & ~(1 << i)) ;
        System.out.println(b1);

        System.out.println("     --------clearBit most sig exclusive---------     ");
        int b2 = (num & ((1 << (i+1))-1)) ;
        System.out.println(b2);

        System.out.println("     --------clearBit most sig inclusive---------     ");
        int b4 = (num & ((1 << (i))-1)) ;
        System.out.println(b4);

        System.out.println("     --------clearBit upto zero---------     ");
        int b3 = (num & (~((1 << (i+1))-1))) ;
        System.out.println(b3);
    }

    static void NOT() {
        //System.out.println(x^n);
        System.out.println("--------------NOT Practice------------------");
        twoComplementForm();
    }

    public static void twoComplementForm() {
        System.out.println();
        System.out.println("     --------twoComplementForm---------     ");
        int i =2;
        System.out.println(i);
        System.out.println(~i);
    }

    static void AND() {
        //System.out.println(x^n);
        System.out.println("--------------AND Practice------------------");
        sameNumberAnd();
    }
    public static void sameNumberAnd() {
        System.out.println();
        System.out.println("     --------sameNumberAnd---------     ");
        int i =0b11011;
        System.out.println(i);
        System.out.println(i&i);
    }
    static void OR() {
        System.out.println("--------------OR Practice------------------");
        int i =0b1010;
        System.out.println(i);
        System.out.println(i|0b0000);
        System.out.println(0b1111);
        System.out.println(i|0b1111);
        System.out.println(i|i);
    }

    static void XOR() {
        //System.out.println(x^n);
        System.out.println("--------------XOR Practice------------------");
        swapUsingXOR();
        findUniqueInArray();
        identityBehavior();
        bitwiseInversion();
        System.out.println();
    }
    public static void identityBehavior() {
        System.out.println();
        System.out.println("     --------identityBehavior---------     ");
        int i =5;
        int mask =0;
        System.out.println(i^mask);

    }

    public static void bitwiseInversion() {
        System.out.println();
        System.out.println("     --------bitwiseInversion---------     ");
        int i =5;
        int mask=~0;
        System.out.println(i^mask);

    }

    public static void findUniqueInArray(){
        System.out.println();
        System.out.println("     --------findUniqueInArray---------     ");
        int[] array ={9, 2, 2, 6, 6, 4, 9};
        int ans = 0;
        for (int val : array) {
            //duplicates cancel out (x ^ x = 0) and x ^ 0 = x, the result is the lone number that appears only
            //is ans and val are different it adds, if they are same then ans is zero
            ans ^= val;
        }
        System.out.println(ans);
    }

    public static void swapUsingXOR(){
        System.out.println();
        System.out.println("     --------swapUsingXOR------------     ");
        int x = 3;
        int y = 4;
       // System.out.println(x+" "+y);

        x = x ^ y;  // Step 1
       // System.out.println(x+" "+y);
        y = x ^ y;  // Step 2
        //System.out.println(x+" "+y);

        x = x ^ y;  // Step 3
        System.out.println(x+" "+y);
    }

    public static void bitwiseMaskPattern(){

        test(0b11010110, 3);  // clear 3 lowest bits
        test(0b1011, 2);      // clear 2 lowest bits
        test(0b1111, 4);      // clearing all bits

    }

    static void test(int x, int n) {
        int mask = ~0 << n;
        int result = x & mask;
        System.out.printf("x = %s (decimal %d)%n", toBinary(x), x);
        System.out.printf("mask = %s%n", toBinary(mask));
        System.out.printf("res = %s (decimal %d)%n%n", toBinary(result), result);
    }

    static String toBinary(int v) {
        System.out.println(Integer.toBinaryString(v));
        //this %32 is used so we dont skip leading zeros
        return String.format("%32s", Integer.toBinaryString(v))
                .replace(' ', '0');
    }
    static void someDataTypeWithExample(){
        byte b      = 0b101;       // 5
        short s     = 0B1111;      // 15
        int i       = 0b110101;    // 53
        long l      = 0b10101010L; // 170 (long)
        int neg     = -0b101;      // -5

        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(neg);
    }

    static void practiceStringFormating(){
        String name = "Alice";
        String padded = String.format("%32s", name);
        //%s%n --> just formating purpose
        System.out.printf("|%s|%n", padded);
    }

}
