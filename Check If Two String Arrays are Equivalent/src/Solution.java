class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2){
        if (getText(word1).contains(getText(word2))){
            return true;
        } else {
            return false;
        }

    }

    public String getText(String[] word){
        String text = "";
        for (int i = 0; i < word.length; i++){
            text += word[i];
        }
        return text;
    }

    public static void main(String[] args) {
        String[] word1 = new String[]{"abc", "d", "defg"};

    }
}