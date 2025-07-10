package com.data.structures.practice.LeetCode.string;

import java.util.HashMap;
import java.util.Iterator;

public class FindAllUnique {

    public static void main(String[] args) {
        String s = "letcod";
        //String s = "loveleetcode";
        //String s = "aabb";
       // String s = "dddccdbba";
        System.out.println(fhasAllUniqChar(s));

    }

    public static int firstUniqChar2(String s) {

        int[] countingArray = new int[250];


        StringBuffer res = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            countingArray[curr]++;
        }
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (countingArray[curr] == 1) {
                return i;
            }

        }

        return -1;

    }

    public static int firstUniqChar3(String s)
    {
        int ch[]=new int[26];
        char sChar[]=s.toCharArray();
        for (char i: sChar)
        {
            ch[i-'a']++;
        }
        for (int i=0;i<sChar.length;i++)
        {
            if (ch[sChar[i]-'a']==1)
            {
                return i;
            }
        }
        return -1;

    }

    public static boolean fhasAllUniqChar(String s)
    {
        int ch[]=new int[26];
        char sChar[]=s.toCharArray();
        for (char i: sChar)
        {
            ch[i-'a']++;
        }
        for (int i=0;i<sChar.length;i++)
        {
            if (ch[sChar[i]-'a']!=1)
            {
                return false;
            }
        }
        return true;

    }

}
