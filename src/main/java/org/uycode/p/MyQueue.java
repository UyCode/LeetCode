package org.uycode.p;

import java.util.Stack;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 09/05/2025 15:03:28
 */

public class MyQueue {

    private final Stack<Integer> first;
    private final Stack<Integer> second;

    /** Initialize your data structure here. */
    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        first.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        int size = first.size();
        for (int i = 0; i < size-1; i++) {
            second.push(first.pop());
        }

        int temp = first.pop();

        while (!second.isEmpty()) {
            first.push(second.pop());
        }

        return temp;
    }

    /** Get the front element. */
    public int peek() {
        int size = first.size();
        for (int i = 0; i < size-1; i++) {
            second.push(first.pop());
        }

        int temp = first.peek();

        while (!second.isEmpty()) {
            first.push(second.pop());
        }

        return temp;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {

        return first.isEmpty();
    }


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.peek());
    }
}
