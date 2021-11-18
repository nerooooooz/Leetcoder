package test;

import java.util.ArrayList;
import java.util.List;

public class P658_KClosestElements {

    // 2 pointer
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i = 0;
        int j = arr.length - 1;
        while (j - i >= k) {
            if (Math.abs(arr[i] - x) > Math.abs(arr[j] - x)) {
                i++;
            } else {
                j--;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int element = i; element <= j; element++) {
            list.add(arr[element]);
        }
        return list;
    }

    // binary
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - k;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (x - arr[mid] > arr[mid+k] - x){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = low; i < low + k; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
