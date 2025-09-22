package com.data.structures.practice.recursion.problems;

import java.util.Stack;

public class ClumsyFactII {

    public int clumsy(int n) {

        Stack<Integer> s = new Stack<>();
        int i=0;
        int l = n;
        s.add(n--);
        while(i<l-1){
            // System.out.println(n);
            if(i%4==0){
                s.add(s.pop()*n);
            }else if(i%4==1){
                s.add(s.pop()/n);
            } else if(i%4 ==2){
                s.add(n);
            } else if(i%4==3){
                s.add(-n);
            }
            i++;
            n--;
        }
        int ans=0;
        while(!s.isEmpty()){
            ans+=s.pop();
            // System.out.println(ans);

        }
        return ans;
    }
}
