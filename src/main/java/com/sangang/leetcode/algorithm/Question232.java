package com.sangang.leetcode.algorithm;

import java.util.Stack;

/**
 * @author linsong
 * @date 2019/4/10 14:58
 **/

public class Question232 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        System.out.println(myQueue.empty());
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);

        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());

    }


}

class MyQueue {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (this.empty()) {
            throw new RuntimeException();
        }
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public int peek() {
        if (this.empty()) {
            throw new RuntimeException();
        }
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty() {
        if(in.empty()&&out.empty()){
            return true;
        }
        return false;
    }
}
