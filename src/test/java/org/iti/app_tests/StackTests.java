package org.iti.app_tests;

import org.iti.app.MyStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StackTests {

    private MyStack myStack;

    @BeforeEach
    void setUp() {
        myStack = new MyStack();

    }

    // peek


    //size

    // push

    @Test
    void testPushElementToStack() {
        myStack.push(List.of(1, 100, 1000));


        assertEquals(3, myStack.getSize());
        assertEquals(1000, myStack.getPeek());
        assertEquals(List.of(1000, 100, 1), myStack.getCurrentStack());

    }

    // pop

    @Test
    void testPopElementFromStack() {
        Exception ex = assertThrowsExactly(IllegalStateException.class, () -> myStack.pop());
        assertEquals("Your Stack Is Empty!", ex.getMessage());
        myStack.push(1);
        myStack.push(List.of(2, 3, 4, 5, 6, 700));

        assertEquals(700, myStack.pop());
        assertEquals(6, myStack.getSize());
        assertEquals(6, myStack.getPeek());
        assertEquals(List.of(6, 5, 4, 3, 2, 1), myStack.getCurrentStack());

    }

    @Test
    void testGetAllStackElements() {
        assertTrue(myStack.getCurrentStack().isEmpty());
        myStack.push(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        myStack.pop();
        myStack.pop();
        assertEquals(List.of(8, 7, 6, 5, 4, 3, 2, 1), myStack.getCurrentStack());
    }

}
