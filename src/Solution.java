import java.util.*;

public class Solution {

    public static int getMaximumCount(int[] arr, int k) {
        // Count total occurrences of k in arr
        int totalKCount = 0;
        for (int num : arr) {
            if (num == k) totalKCount++;
        }

        int result = 0;
        int n = arr.length;

        // Iterate over all subarray lengths
        for (int length = 1; length <= n; length++) {
            // Iterate over all subarray start positions
            for (int start = 0; start <= n - length; start++) {
                int end = start + length - 1;

                // Count frequencies in subarray arr[start..end]
                Map<Integer, Integer> numCount = new HashMap<>();
                for (int i = start; i <= end; i++) {
                    numCount.put(arr[i], numCount.getOrDefault(arr[i], 0) + 1);
                }

                int kCount = 0;
                int maxCount = Collections.max(numCount.values());
                Set<Integer> numsWithMaxCount = new HashSet<>();

                for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
                    int num = entry.getKey();
                    int cnt = entry.getValue();
                    if (num == k) {
                        kCount++;
                    }
                    if (cnt == maxCount) {
                        numsWithMaxCount.add(num);
                    }
                }

                // Only update if k is not in numsWithMaxCount
                if (!numsWithMaxCount.contains(k)) {
                    int remainingKCount = totalKCount - kCount;
                    result = Math.max(result, maxCount + remainingKCount);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getMaximumCount(new int[]{2, 3, 2, 4, 3, 2}, 2)); // 4
        System.out.println(getMaximumCount(new int[]{6, 4, 4, 6, 4, 4}, 6)); // 5
        System.out.println(getMaximumCount(new int[]{2, 5, 2, 5, 2}, 2));    // 4
    }
}