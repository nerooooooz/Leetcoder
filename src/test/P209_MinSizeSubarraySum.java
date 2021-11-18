package test;

public class P209_MinSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,3,1,4,4};
        int target = 7;
        System.out.println();
    }

    // 2 pointer #1
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int low = 0, high = 0, sum = 0;
        int min = Integer.MAX_VALUE;
        while (high < nums.length) {
            sum = sum + nums[high];
            if (sum >= target) {
                while (low <= high && sum - nums[low] >= target) {
                    sum = sum - nums[low];
                    low++;
                }
                min = Math.min(min, high - low + 1);
            }
            high++;
        }
        return min != Integer.MAX_VALUE ? min : 0;
    }

    // 2 pointer #2
    public int minSubArrayLen2(int target, int[] nums) {
        int n = nums.length;
        int low = 0, sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= target) {
                min = Math.min(min, i - low + 1);
                sum -= nums[low];
                low++;
            }
        }
        return min != Integer.MAX_VALUE ? min : 0;
    }


}
