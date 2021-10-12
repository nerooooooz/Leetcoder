package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P1_2SUM {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n = 0; n < nums.length; n++) {
            int secondNum = target - nums[n];
            if (map.containsKey(secondNum)) {
                return new int[]{map.get(secondNum), n};
            }
            map.put(nums[n], n);
        }
        return null;
    }
}
