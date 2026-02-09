package org.uycode.p._201_300;

import java.util.HashMap;
import java.util.Map;


public class P242 {
    

    public static void main(String[] args) {
       System.out.println(isAnagram("rat", "cat")); 
    }

    public static boolean isAnagram(String s, String t) {

        Map<Character, Integer> original = new HashMap<>();

        for (char c : s.toCharArray()) {
            original.put(c, original.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
           original.put(c, original.getOrDefault(c, 0) - 1);
        }

        for (Integer counter : original.values()) {
            if (counter != 0) return false;
        }


        return true;
    }
}
