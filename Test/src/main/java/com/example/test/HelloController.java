package com.example.test;

class Solution {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2){
        if (getText(word1).equals(getText(word2))){
            return true;
        } else {
            return false;
        }

    }

    public static String getText(String[] word){
        String text = "";
        for (int i = 0; i < word.length; i++){
            text += word[i];
        }
        System.out.println(text);
        return text;
    }

    public static void main(String[] args) {
        String[] word1 = new String[]{"abc", "d", "defg"};
        String[] word2 = new String[]{"abcddef"};
        System.out.println(arrayStringsAreEqual(word1, word2));
    }
}