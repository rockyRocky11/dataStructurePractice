package com.data.structures.practice.bitmanipulation;

public class AddTwoNumbers {
    public static void main(String[] args) {
        //System.out.println(getSum(1, 2));
       // System.out.println(getSum(1, 1));
       // System.out.println(getSum(4, 8));
       // System.out.println(getSum(3, 8));
        //System.out.println(getSum(4, 7));
        System.out.println(getSum(20, 30));
        System.out.println(getSum(4, 5));
    }
    public static int getSum(int a, int b) {
        if(a==b){
            return a<<1;
        }else{
            int res=0;
            int carry =0;
            for (int i = 0; i < 32; i++) {
                int tempa = (a & (1 << i)) != 0 ? 1 : 0;
                int tempb = (b & (1 << i)) != 0 ? 1 : 0;

                int temp = tempa ^ tempb;         // sum bit (ignoring carry)
                int temp1 = temp ^ carry;         // sum bit (including carry)

                res = res | (temp1 << i);         // set ith bit of result

                // update carry
                carry = (tempa == 1 && tempb == 1) ||
                        (temp == 1 && carry == 1) ? 1 : 0;
            }
            return res;
        }
    }

    public int getSumClean(int a, int b) {
        int res = 0, carry = 0;
        for (int i = 0; i < 32; i++) {
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;

            int sumBit = bitA ^ bitB ^ carry;
            res |= (sumBit << i);

            carry = (bitA & bitB) | (bitA & carry) | (bitB & carry);
        }
        return res;
    }

}
