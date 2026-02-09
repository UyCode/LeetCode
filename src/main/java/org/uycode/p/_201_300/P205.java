package org.uycode.p._201_300;

import java.util.*;

public class P205 {
    
    public static void main(String[] args) {
        System.out.println(isIsomorphic("bbbaaaba", "aaabbbba"));
    }


    public static boolean isIsomorphic(String s, String t) {

        Map<Character, Character> source = new HashMap<>();
        Map<Character, Character> target = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i);
            char tt = t.charAt(i);

            if ((source.containsKey(ss) && source.get(ss) != tt) ||
                    (target.containsKey(tt) && target.get(tt) != ss)) {
                return false;
            }
            source.put(ss, tt);
            target.put(tt, ss);
        }


        return true;
    }
}
