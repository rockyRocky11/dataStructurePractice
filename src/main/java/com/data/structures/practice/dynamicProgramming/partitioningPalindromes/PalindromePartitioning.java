package com.data.structures.practice.dynamicProgramming.partitioningPalindromes;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    List<List<String>> res;
    List<String> sol;
    int n;
    int[][] store;

    public List<List<String>> partition(String s) {
        n = s.length();
        res = new ArrayList<>();
        sol = new ArrayList<>();
        store = new int[n][n];
        backTrack(s, 0);
        return res;
    }

    public void backTrack(String s, int idx) {
        if (idx >= n) {
            res.add(new ArrayList<>(sol));
            return;
        }
        for (int i = 1; i <= n; i++) {//i is the partition length
            if (idx + i > n) {
                return;
            }
            if (!isPalindrome(s, idx, idx + i - 1))
                continue;
            sol.add(s.substring(idx, idx + i));
            backTrack(s, idx + i);

            sol.remove(sol.size() - 1);
        }

    }

    public boolean isPalindrome(String s, int i, int j) {
        if (store[i][j] == 1)
            return true;
        if (store[i][j] == -1)
            return false;
        int a =i;
        int b = j;
        while (a < b) {
            if (s.charAt(a) != s.charAt(b)) {
                store[i][j] = -1;
                return false;
            }
            a++;
            b--;
        }
        store[i][j] = 1;
        return true;
    }
}
