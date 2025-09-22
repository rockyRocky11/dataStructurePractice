package com.data.structures.practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueensII {
    List<Integer> sol;
    boolean[] cols;
    boolean[] dia1;
    boolean[] dia2;

    public int totalNQueens(int n) {

        sol = new ArrayList<>();
        cols = new boolean[n];// column occupied
        dia1 = new boolean[n * 2];// diagonal1 occupied (r - c + n)
        dia2 = new boolean[n * 2];// diagonal2 occupied (r + c)

        return backTrack(n, 0);

    }

    public int backTrack(int n, int i) {
        if (i == n) {
            if (sol.size() == n) {
                return 1;
            }
            return 0;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (cols[j] || dia1[i - j + n - 1] || dia2[i + j])
                continue;
            sol.add(j);
            cols[j] = dia1[i - j + n - 1] = dia2[i + j] = true;
            res += backTrack(n, i + 1);
            sol.remove(sol.size() - 1);
            cols[j] = dia1[i - j + n - 1] = dia2[i + j] = false;
        }
        return res;
    }

}
