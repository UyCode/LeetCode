package org.uycode.p;

import javax.swing.*;
import java.util.Arrays;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 06/05/2025 18:59:58
 */

public class KthLargest {

    private final int k;
    private int[] nums;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        Arrays.sort(nums);
        this.nums = nums;
    }

    public int add(int val) {

        if (k > nums.length + 1) return -1;

        int[] temp = new int[nums.length + 1];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        temp[temp.length-1] = val;
        Arrays.sort(temp);
        nums = temp;

        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] nums = {-2};
        KthLargest obj = new KthLargest(1, nums);
        int i = obj.add(-3);
        System.out.println(i);
        i = obj.add(0);
        System.out.println(i);
        i = obj.add(9);
        System.out.println(i);
        i = obj.add(9);
        System.out.println(i);
        //i = obj.add(4);
        //System.out.println(i);
    }
}
