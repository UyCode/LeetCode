package org.uycode.p._3001_4000;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 08/02/2026 10:57:42
 *
 */

public class P3606 {

    public static void main(String[] args) {

        String[] code = {"pBXoMqBU0_aMgc9F8dy6TaSzza3KjSJFjxZa_NuyMjzEBR7fJNwpGHh7lzuoZvQeEUeo6YumHmIOjjchXlzSVa4ItdyDOImQgm","P8rIIUl35MW8yrqRbO0N_IITptYOxz9tOCbPL6d1aIF_hM2sapaDtUzNpmAZRmJQB1WgjLh8bdYADuSRSU21OzttUkq73qiA66","aFWkYookQlHYMXzhVGxbnrXIl1810ws3qHtketHSECHqJoktWXVZGc6ZyeOuzA_VL9zFL9znpIHwbkwJF2bOPQqsz3_0PYgETJ"};
        String[] businessLine = {"pharmacy","invalid","pharmacy"};
        boolean[] isActive = {true, true, true};

        System.out.println(validateCoupons(code, businessLine, isActive));

    }

    private static final Set<String> business = Set.of("electronics","grocery","pharmacy","restaurant");

    public static List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        int n = code.length;

        Map<String, List<String>> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            if (isActive[i] && code[i].matches("^\\w+$") && business.contains(businessLine[i])) {
                List<String> codes = map.getOrDefault(businessLine[i], new ArrayList<>());
                codes.add(code[i]);
                map.put(businessLine[i], codes);
            }
        }

        List<String> ans = new ArrayList<>();
        for (List<String> value : map.values()) {
            Collections.sort(value);
            ans.addAll(value);
        }

        return ans;
    }
}
