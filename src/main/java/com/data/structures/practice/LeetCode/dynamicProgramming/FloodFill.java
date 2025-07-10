package com.data.structures.practice.LeetCode.dynamicProgramming;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image=    {{1,1,1}, {1,1,0}, {1,0,1}};
        int sr=1, sc=1, color=2;

                floodFill(image,  sr,  sc,  color);
        System.out.println();

    }

    //Time - O(MxN)
    //space -O(MxN)
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        dfsRec(image,  sr,  sc,  color, image[sr][sc]);

        return image;

    }

    public static void dfsRec(int[][] image, int sr, int sc, int color, int startingColor) {
        if(!checkBoundryAndColor( image,  sr,  sc,  color, startingColor)){
            return;
        }
        image[sr][sc]=color;
        dfsRec(image,  sr+1,  sc,  color, startingColor);//down
        dfsRec(image,  sr-1,  sc,  color, startingColor);//up
        dfsRec(image,  sr,  sc+1,  color, startingColor);//right
        dfsRec(image,  sr,  sc-1,  color, startingColor);//left

    }

    public  static boolean checkBoundryAndColor(int[][] image, int sr, int sc, int color, int startingColor) {

        if(sr<0 || sc <0 || sr >= image.length || sc >=image[sr].length || image[sr][sc] != startingColor|| image[sr][sc] == color){
            return false;
        }
        return true;
    }
}
