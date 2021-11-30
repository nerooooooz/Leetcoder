package BinarySearch;

import java.util.Arrays;

public class P34_FirstLastIndexOfTarget {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(binarySearch(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    public static int[] binarySearch(int[] nums, int target) {
        int begin = 0, end = nums.length - 1;
        int[] ans = new int[]{-1, -1};
        // search first
        while (begin <= end) {
            int mid = (end + begin) / 2;
            if (nums[mid] == target) {
                if (mid == begin || nums[mid - 1] != target) {
                    ans[0] = mid;
                }
                end = mid - 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }

        begin = 0; end = nums.length - 1;
        while (begin <= end) {
            int mid = (end + begin) / 2;
            if (nums[mid] == target) {
                if (mid == end || nums[mid + 1] != target) {
                    ans[1] = mid;
                }
                begin = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return ans;
    }
}
