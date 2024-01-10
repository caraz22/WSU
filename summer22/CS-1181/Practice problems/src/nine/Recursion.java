package nine;

//Received help from and collaborated with Steve Burke

public class Recursion {
    
    public static void anagram(String word, String smallerWord) {       
        if (smallerWord.length() == 0) {
            System.out.println(word);
        }

        for (int i = 0; i < smallerWord.length(); i++) {
            String newWord = word + smallerWord.charAt(i);
            String newSmallerWord = smallerWord.substring(0, i) + smallerWord.substring(i + 1);
            anagram(newWord, newSmallerWord);
        }
    }

    public static String permutation(String word, int index) {
        String s1 = word.substring(0, index);
        String s2 = word.substring(index + 1, word.length());
        StringBuilder str = new StringBuilder(s1 + s2);
        return str.toString();
    }

    public static void main(String[] args) {

        String word = "frog";

        for (int i = 0; i < word.length(); i++) {
            anagram(word.substring(i, i+1), permutation(word, i));
        }
    }
}
