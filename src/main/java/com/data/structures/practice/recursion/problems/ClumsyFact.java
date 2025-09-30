package com.data.structures.practice.recursion.problems;

public class ClumsyFact {
    public static void main(String[] args) {
        ClumsyFact solution = new ClumsyFact();
        System.out.println(solution.clumsy(10));
    }


    public int clumsy(int n) {
        int[] store = new int[n + 1];
        return rec(n, new Clumsy(1, ""), store).val;
    }

    public Clumsy rec(int n, Clumsy clumsy, int[] store) {
        //System.out.println("input :" + clumsy.val);
        if (n == clumsy.val) {
            //System.out.println(clumsy.val);
            return new Clumsy(clumsy.val, "mul");
        }
        Clumsy temp = rec(n, new Clumsy(clumsy.val + 1, getOp(clumsy.op)), store);
        int ans = 0;
        if (temp.op.equals("sub") && clumsy.val > 1) {
            ans = clumsy.val;
            store[clumsy.val] = temp.val;

        } else if (temp.op.equals("mul") && clumsy.val == 1 && n - clumsy.val > 2) {
            ans = getNewVal(temp.op, temp.val, clumsy.val);
            ans = store[clumsy.val + 1] - ans;

        } else if (temp.op.equals("div") && n - clumsy.val > 2) {
            ans = getNewVal(temp.op, temp.val, clumsy.val);
            ans = store[clumsy.val + 2] - ans;
        } else {
            ans = getNewVal(temp.op, temp.val, clumsy.val);
        }

        //System.out.println(ans);
        return new Clumsy(ans, getOp(temp.op));
    }

    public String getOp(String cur) {
        if (cur.equals("mul"))
            return "div";
        if (cur.equals("div"))
            return "add";
        if (cur.equals("add"))
            return "sub";
        if (cur.equals("sub"))
            return "mul";
        return "";
    }

    public int getNewVal(String op, int i, int j) {
        if (op.equals("mul"))
            return i * j;
        if (op.equals("div"))
            return i / j;
        if (op.equals("add"))
            return i + j;
        if (op.equals("sub"))
            return i - j;
        return -1;
    }

    static class Clumsy {
        int val;
        String op;

        public Clumsy(int val, String op) {
            this.val = val;
            this.op = op;
        }
    }

}
