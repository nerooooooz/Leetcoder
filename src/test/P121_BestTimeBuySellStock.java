package test;

public class P121_BestTimeBuySellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int current = prices[i];
            min = Math.min(min, current);
            profit = Math.max(current - min, profit);
        }
        return Math.max(0, profit);
    }
}
