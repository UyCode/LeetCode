package org.uycode.p._2001_3000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 28/04/2025 18:02:02
 */

public class P2302 {

    public long countSubarrays(int[] nums, long k) {

        int n = nums.length;
        long sum = 0;

        for (int num : nums) {
            sum +=num;
        }
        sum *= n;
        if (sum == k) return 1;

        if (sum < k) {
            return ((long) n * n + n)/2;
        }

        long ans = 0;
        int left = 0;
        sum = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (left <= right && sum * (right - left + 1) >= k) {
                sum -= nums[left];
                left++;
            }
            ans += right - left + 1;
        }



        return ans;
    }
}
