package org.uycode.p._201_300;

import org.uycode.common.VersionControl;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 25/05/2025 13:28:15
 */

public class P278 extends VersionControl {

    public static void main(String[] args) {
        P278 p278 = new P278();
        System.out.println(p278.firstBadVersion(10));
    }

    public int firstBadVersion(int n) {

       int l = 1;
       int r = n;

       if (super.isBadVersion(l)) return 1;

       //int[] version = new int[n+1];
       while (l <= r) {
           int m = l + (r-l)/2;
           boolean isBad = super.isBadVersion(m);
           if (isBad){
               r = m-1;
               //version[m] = 1;
           } else {
               l = m+1;
           }
       }

        //for (int i = 0; i < version.length; i++) {
            //if(version[i] == 1) return i;
        //

        return l;

    }
}
