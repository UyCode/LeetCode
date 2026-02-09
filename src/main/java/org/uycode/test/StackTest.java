package org.uycode.test;

import javafx.util.Pair;

import java.util.*;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 24/01/2026 13:12:42
 *
 */

public class StackTest {

    public static void main(String[] args) {
        //int[] target = {1, 2, 3};
        //System.out.println(operate(target, 3));

        //String[] arg = {"4","13","5","/","+"};
        //System.out.println(evalRPN(arg));

        /*List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");
        System.out.println(Arrays.toString(exclusiveTime(2, logs)));*/


        /*int[] prices = {73,74,75,71,69,72,76,73};

        System.out.println(Arrays.toString(dailyTemperatures(prices)));*/


        /*int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));*/


        /*int[] arr = {1,1,0,0};
        int[] arr2 = {0,1,0,1};
        System.out.println(countStudents(arr, arr2));*/

        /*int[] tickets = {5, 1, 1, 1};
        System.out.println(timeRequiredToBuy(tickets, 0));*/

        /*int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));*/

        /*int[] a = {1,1,2};
        int[] b = {1,2,3};

        System.out.println(kSmallestPairs(a, b, 2));*/


        String a = "cbacdcbc";

        System.out.println(removeDuplicateLetters(a));

    }

    public static List<String> operate(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int[] temp = new int[n];
        int m = target.length;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (index < m) {
                if (target[index] != i) {
                    ans.add("Push");
                    ans.add("Pop");
                } else {
                    temp[i - 1] = i;
                    index++;
                    ans.add("Push");
                }

                if (Arrays.equals(temp, target)) {
                    return ans;
                }
            }

        }

        return ans;

    }

    private static final Set<String> signs = Set.of("+", "-", "*", "/");

    public static int evalRPN(String[] tokens) {
        LinkedList<String> list = new LinkedList<>();
        for (String token : tokens) {
            if (!signs.contains(token)) {
                list.push(token);
                continue;
            }
            String second = list.pop();
            String first = list.pop();
            int res = calculate(Integer.parseInt(first), Integer.parseInt(second), token);
            list.push(String.valueOf(res));
        }


        String s = list.pop();
        return Integer.parseInt(s);


    }

    private static int calculate(int a, int b, String sign) {
        return switch (sign) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };

    }

    public static int[] exclusiveTime(int n, List<String> logs) {

        int[] ans = new int[n];

        LinkedList<String[]> temp = new LinkedList<>();

        int lastEnd = 0;
        for (String log : logs) {
            String[] chunk = log.split(":");
            String flag = chunk[1];

            if ("start".equals(flag)) {
                temp.push(chunk);
            }
            if ("end".equals(flag)) {
                String[] pop = temp.pop();
                lastEnd = Integer.parseInt(chunk[2]);
                int id = Integer.parseInt(chunk[0]);
                ans[id] += lastEnd - Integer.parseInt(pop[2]);
            }
        }

        return ans;

    }

    public static int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            ans[i] = prices[i];
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int idx = stack.pop();
                ans[idx] -= prices[i];
            }
            stack.push(i);
        }
        return ans;

    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ans[idx] = i - idx;
            }
            stack.push(i);
        }
        return ans;
    }

    public static int largestRectangleArea(int[] heights) {

        int ans = 0;
        int n = heights.length;

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            int cur = i == n ? 0 : heights[i];

            while (!deque.isEmpty() && cur < heights[deque.peek()]) {
                int h = heights[deque.pop()];
                int l = deque.isEmpty() ? -1 : deque.peek();
                int w = i - l - 1;
                ans = Math.max(ans, w * h);

            }
            deque.push(i);
        }

        return ans;
    }

    public static boolean validMountainArray(int[] arr) {

        if (arr.length < 3) return false;

        int n = arr.length;
        int i = 0;
        while (i < n - 1 && arr[i + 1] > arr[i]) {
            i++;
        }

        if (i == n - 1 || i == 0) return false;

        for (int j = i + 1; j < n; j++) {
            if (arr[j] >= arr[j - 1]) return false;
        }


        return true;
    }

    public static int countStudents(int[] students, int[] sandwiches) {

        ArrayDeque<Integer> stuq = new ArrayDeque<>();
        ArrayDeque<Integer> sanq = new ArrayDeque<>();

        int n = students.length;

        for (int i = n - 1; i >= 0; i--) {
            stuq.push(students[i]);
            sanq.push(sandwiches[i]);
        }

        int count = 0;
        while (!stuq.isEmpty()) {
            Integer head = stuq.poll();
            if (head.equals(sanq.peek())) {
                sanq.poll();
                count = 0;
                n--;
            } else {
                stuq.offer(head);
                count++;
            }

            if (count > n || sanq.isEmpty()) {
                return stuq.size();
            }
        }


        return 0;
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        ArrayDeque<Pair<Integer, Integer>> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            Pair<Integer, Integer> cur = new Pair<>(i, tickets[i]);
            stack.push(cur);
        }

        int counter = 0;
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> head = stack.pop();
            if (head.getKey() == k && head.getValue() == 1) {
                return ++counter;
            }
            if (head.getValue() > 1) {
                head = new Pair<>(head.getKey(), head.getValue() - 1);
                stack.offer(head);
            }
            counter++;

            if (stack.size() == 1 && stack.peek().getKey() == k) {
                return counter + stack.pop().getValue();
            }

        }

        return counter;

    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            heap.add(stone);
        }

        while (!heap.isEmpty()) {
            if (heap.size() > 1) {
                Integer a = heap.poll();
                Integer b = heap.poll();

                if (a > b) {
                    heap.offer(a - b);
                } else {
                    heap.offer(b - a);
                }
            } else {
                return heap.peek();
            }
        }
        return 0;

    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) return ans;

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> nums1[a[0]] + nums2[a[1]]));

        int size = Math.min(nums1.length, k);
        for (int i = 0; i < size; i++) {
            heap.offer(new int[]{i, 0});
        }


        while (k > 0 && !heap.isEmpty()) {
            int[] cur = heap.poll();
            int i = cur[0];
            int j = cur[1];

            ans.add(List.of(nums1[i], nums2[j]));

            k--;

            if (j+1 < nums2.length) {
                heap.offer(new int[]{i, j+1});
            }

        }

        return ans;
    }

    public static String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] inStack = new boolean[26];

        for(char c: s.toCharArray()) {
            count[c - 'a']++;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            count[idx]--;

            if (inStack[idx]) continue;

            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                inStack[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            inStack[idx] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }

        return sb.toString();
    }
}
