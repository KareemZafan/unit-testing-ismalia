package org.iti.app;

public class StringManipulation {

    public boolean isPalindrome(String str) {
        StringBuilder strBuilder = new StringBuilder(str);
        return str.equals(strBuilder.reverse().toString());
    }


}
