package org.uycode.interviews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 15/03/2026 14:04:28
 *
 */

public class Fancy {

    List<long[]> factors = new ArrayList<>();
    List<Integer> values = new ArrayList<>();

    public Fancy() {
        factors.add(new long[]{0, 0});
    }

    public void append(int val) {
        values.add(val);
        factors.add(new long[]{1, 0});
    }

    public void addAll(int inc) {
        int i = factors.size() - 1;
        while (i > 0) {
            long[] factor = factors.get(i);
            factor[1] += inc;
            i -= (i & -i);
        }
    }

    public void multAll(int m) {
        int i = factors.size() - 1;
        while (i > 0) {
            long[] factor = factors.get(i);
            factor[0] = (factor[0] * m) % 1000_000_007L;
            factor[1] = factor[1] * m  % 1000_000_007L;
            i -= (i & -i);
        }
    }

    public int getIndex(int idx) {
        if (idx >= values.size()) {
            return -1;
        }
        // 依次获取所有上层操作，最后就是当前下标的值
        long val = values.get(idx);
        idx++;
        while (idx < factors.size()) {
            long[] factor = factors.get(idx);
            val = (val * factor[0] + factor[1]) % 1000_000_007L;
            idx += (idx & -idx);
        }
        return (int) val;
    }
}
