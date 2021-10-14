package DP;

import java.util.ArrayList;
import java.util.List;

public class P279_PerfectSquares {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    public static int numSquares(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 0; i < memo.length; i++) {
            int ans = i;
            for (int j = 1; j * j <= i; j++) {
                ans = Math.min(ans, memo[i - j * j] + 1);
            }
            memo[i] = ans;
        }
        return memo[n];
    }
}
