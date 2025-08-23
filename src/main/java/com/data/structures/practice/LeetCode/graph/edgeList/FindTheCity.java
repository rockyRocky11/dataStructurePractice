package com.data.structures.practice.LeetCode.graph.edgeList;

import java.util.Arrays;

public class FindTheCity {

   /* 📊 Time & Space
    Time Complexity: O(n^3) because of triple loop.

    Space Complexity: O(n^2) because of dist[][].*/

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 100002);
            dist[i][i] = 0;
        }

        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            int w = edge[2];
            dist[i][j] = w;
            dist[j][i] = w;//bi-directional
        }

        //well warshall
        for (int k = 0; k < n; k++) {//intermediate
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != 0 && dist[k][j] !=0 && (dist[i][k] + dist[k][j]) < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
*/
        int[] ans = new int[3];
        ans[1] = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cityCOunt = 0;
            int greatestNumber = 0;
            for (int j = 0; j < n; j++) {
                if (i!=j && dist[i][j] <= distanceThreshold) {
                    cityCOunt++;
                    greatestNumber = Math.max(greatestNumber, dist[i][j]);
                }
            }
            if (i == 0) {
                ans[1] = cityCOunt;
                ans[2] = greatestNumber;
            } else if (cityCOunt <= ans[1]) {
                ans[0] = i;
                ans[1] = cityCOunt;
                ans[2] = greatestNumber;
            }

            //System.out.println(ans[0] + " "+ans[1]+ " "+ans[2]);
        }
        return ans[0];
    }
}
