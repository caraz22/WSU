import java.util.HashMap;
//import java.util.Scanner;

public class HashMapExample {

    public static void main(String[] args) {

        HashMap<Character, Integer> charFreqs = new HashMap<>();

        String s = "Hello, my name is Cara.";
        s = s.toLowerCase();

        char[] letters = s.toCharArray();

        for (char letter: letters) {

            if (!Character.isLetter(letter)) continue;
            if (charFreqs.containsKey(letter)) {
                //we've already seen this letter -- just increment its value by one
                int currentCount = charFreqs.get(letter);
                charFreqs.put(letter, currentCount+1);
            } else {
                //we haven't seen this letter before -- its value is just one now
                charFreqs.put(letter, 1);
            }
        }

        System.out.println(charFreqs);

        int maxTimes = 0;
        char maxLetter = '\0';

        for (char c: charFreqs.keySet()) {
            int currentCount = charFreqs.get(c);
            if (currentCount > maxTimes) {
                maxTimes = currentCount;
                maxLetter = c;
            }
        }

        System.out.println("The most frequent letter is " + maxLetter);
        System.out.println("It occurs " + maxTimes + " times.");
    }
    
}
