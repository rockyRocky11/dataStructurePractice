package com.data.structures.practice.LeetCode.dynamicProgramming;

public class LnterleavingString {

    public static void main(String[] args) {
       //String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
        System.out.println(isInterleave1(s1, s2, s3));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if (n1 + n2 < n3) {
            return false;
        }
        int l1 = 0;
        int l2 = 0;
        int l3 = 0;
        while (l3 < n3) {
            if (l1 < n1 && s3.charAt(l3) == s1.charAt(l1)) {
                System.out.println("l1");
                l1++;
            } else if (l2 < n2 && s3.charAt(l3) == s2.charAt(l2)) {
                System.out.println("l2");
                l2++;
            } else {
                System.out.println(s3.charAt(l3) + " " + l1 + " " + l2 + " " + n1 + " " + n2);
                return false;
            }


            l3++;

        }
        return true;

    }

    public static boolean isInterleave1(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if (n1 + n2 != n3) {
            return false;
        }
        int l1 = 0;
        int l2 = 0;
        int l3 = 0;
        Boolean[][] memo = new Boolean[n1+1][n2+1];
        return dfs(s1, s2, s3, l1, l2, l3, n1, n2, n3, memo);

    }

    public static boolean dfs(String s1, String s2, String s3, int l1, int l2, int l3, int n1, int n2, int n3,  Boolean[][] memo) {
        if (l3 == n3) {
            return true;
        }
        if(memo[l1][l2] != null){
            return memo[l1][l2];
        }
        boolean picks1=false;
        boolean picks2=false;
        if (l1 < n1 && s3.charAt(l3) == s1.charAt(l1)) {
           picks1= dfs(s1, s2, s3, l1+1, l2, l3+1, n1, n2, n3, memo);
        }
        if (l2 < n2 && s3.charAt(l3) == s2.charAt(l2)) {
            picks2=dfs(s1, s2, s3, l1, l2+1, l3+1, n1, n2, n3, memo);
        }
        //System.out.println(l1+","+l2+" "+(picks1 || picks2));
        memo[l1][l2]=picks1 || picks2;
        return picks1 || picks2;


    }
}
