package org.uycode;

import org.uycode.p._1001_2000.P1295;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*P2302 p2302 = new P2302();

        int[] nums = {7,6,7,9,1,5,1,4,9,1,10,8,4,1,7,4,2};
        System.out.println(p2302.countSubarrays(nums, 65));*/


       /* P5 p5 = new P5();
        System.out.println(p5.longestPalindrome1("abcdefgfedcba"));*/

        try {
            File sample = new File("D:/opt/samples/sample-array.txt");

            FileInputStream is = new FileInputStream(sample);
            Scanner scanner = new Scanner(sample);
            String s = scanner.next();
            String[] split = s.split(",");
            int[] nums = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                nums[i]= Integer.parseInt(split[i]);
            }
            P1295 p1295 = new P1295();
            long start = System.currentTimeMillis();
            System.out.println(p1295.findNumbers(nums));
            System.out.println(System.currentTimeMillis() - start);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}