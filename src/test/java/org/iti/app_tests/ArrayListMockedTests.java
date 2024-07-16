package org.iti.app_tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ArrayListMockedTests {

    @Mock
    private ArrayList<String> myList;

    @Test
    void testListSizeIs50() {
        // stubs
        when(myList.size()).thenReturn(50);

        //Assert
        assertEquals(50, myList.size());
        System.out.println(myList.size());
        verify(myList, atLeastOnce()).size();

    }

    @Test
    void testGettingTenthElement() {
        // stubs
        when(myList.get(10)).thenReturn("HelloWorld");

        //Assert
        assertEquals("HelloWorld", myList.get(10));
        System.out.println(myList.get(10));
        verify(myList, atLeastOnce()).get(10);
    }

    @Test
    void testListContainsJavaBooks() {
        // stubs
        when(myList.contains("Effective Java")).thenReturn(true);

        //Assert
        assertTrue(myList.contains("Effective Java"));
        verify(myList, atLeastOnce()).contains("Effective Java");
    }


}
