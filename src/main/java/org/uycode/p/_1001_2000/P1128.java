package org.uycode.p._1001_2000;

import java.util.Arrays;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 04/05/2025 00:25:31
 */

public class P1128 {

    public static void main(String[] args) {

        int[][] dominoes = {
                {1,2},
                {1,2},
                {1,1},
                {1,2},
                {2,2},
        };

        System.out.println(numEquivDominoPairs2(dominoes));
    }

    public static int numEquivDominoPairs(int[][] dominoes) {

        int ans = 0;

        int n = dominoes.length;
        for (int i = 0; i < n-1; i++) {
            int left = dominoes[i][0];
            int right = dominoes[i][1];
            for (int j = i+1; j < n; j++) {
                if ((dominoes[j][0] == left && dominoes[j][1] == right )|| (dominoes[j][0] == right && dominoes[j][1] == left)){
                    ans++;
                }
            }
        }


        return ans;

    }

    public static int numEquivDominoPairs2(int[][] dominoes) {

        int ans = 0;
        int[] cp = new int[100];
        for(int[] arr:dominoes){
            Arrays.sort(arr);
            ans+=cp[arr[0]*10+arr[1]]++;
        }
        return ans;
    }


}
