package com.data.structures.practice.LeetCode.greedy;

public class Lemonade {

    static {
        int[] bills = { 5, 5, 10 };
        for (int i = 0; i < 300; i++) lemonadeChange(bills);
    }
    public static void main(String[] args) {


        //int[] bills ={5,5,5,10,20};
        int[] bills ={5,5,10,10,20};
        System.out.println(lemonadeChange(bills));

    }
    public static boolean lemonadeChange(int[] bills) {

        int fiveDollars=0;
        int tenDollars=0;
        int twentyDollars=0;

        for(int i=0;i<bills.length;i++){
            if(bills[i] ==5){
                fiveDollars++;
            }else  if(bills[i] == 10){
                tenDollars++;
                if(fiveDollars>0){
                    fiveDollars--;
                }else{
                    return false;
                }
            }
            else{
                twentyDollars++;
                if(tenDollars>0 && fiveDollars >0){
                    tenDollars--;
                    fiveDollars--;
                }
                else if(fiveDollars >2){
                    fiveDollars=fiveDollars-3;
                }
                else{
                    return false;
                }

            }
        }
        return true;
    }
}
