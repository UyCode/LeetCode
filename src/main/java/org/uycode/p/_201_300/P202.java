package org.uycode.p._201_300;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 15/02/2026 11:40:15
 *
 */

public class P202 {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {

        int fast=n;
        int slow=n;
        do{
            slow=squareSum(slow);
            fast=squareSum(fast);
            fast=squareSum(fast);
        }while(slow!=fast);
        return fast == 1;
    }

    private static int squareSum(int m){
        int squaresum=0;
        while(m!=0){
            squaresum+=(m%10)*(m%10);
            m/=10;
        }
        return squaresum;
    }
}
