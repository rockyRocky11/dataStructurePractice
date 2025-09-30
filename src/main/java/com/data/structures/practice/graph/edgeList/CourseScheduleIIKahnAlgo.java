package com.data.structures.practice.graph.edgeList;

import java.util.*;

public class CourseScheduleIIKahnAlgo {

  /*  Time Complexity: O(V + E)
    Space Complexity: O(V + E) (graph + recursion stack + result stack)*/
  public static int[] findOrder(int numCourses, int[][] prerequisites) {

      Map<Integer, List<Integer>> al = new HashMap<>();
      int[] inDegree = new int[numCourses];
      Queue<Integer> q = new LinkedList<>();
      for (int[] pre : prerequisites) {
          int x = pre[0];
          int y = pre[1];
          al.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
          inDegree[x]++;
      }

      for (int i = 0; i < numCourses; i++) {
          if (inDegree[i] == 0)
              q.offer(i);
      }
      int[] topo = new int[numCourses];
      int idx = 0;
      while (!q.isEmpty()) {
          int u = q.poll();
          ///System.out.println(u);
          topo[idx++] = u;
          for (int pre : al.getOrDefault(u, Collections.emptyList())) {
              inDegree[pre]--;
              if (inDegree[pre] == 0)
                  q.offer(pre);
          }
      }
      //System.out.println(idx);
      return idx == numCourses ? topo : new int[] {};
  }
}
