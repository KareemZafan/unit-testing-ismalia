package org.iti.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyStack {

    private ArrayList<Integer> stackList;

    public MyStack() {
        stackList = new ArrayList<>();
    }

    public void push(int i) {
        stackList.add(i);
    }

    public void push(List<Integer> stack) {
        stackList.addAll(stack);
    }

    public int getSize() {
        return stackList.size();
    }

    public int getPeek() {
        return stackList.get(stackList.size() - 1);
    }


    public List<Integer> getCurrentStack() {
        List<Integer> copyList = stackList;
        Collections.reverse(copyList);
        return copyList;
    }

    public int pop() {

        if (getSize() == 0) {
            throw new IllegalStateException("Your Stack Is Empty!");
        }
        int poppedItem = getPeek();
        stackList.remove(stackList.size() - 1);
        return poppedItem;
    }
}
