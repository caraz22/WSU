package Recursion;

public class RecursiveMethods {
    
    public static void countDown(int n) {
        if (n == 0) {
            System.out.println("Blastoff!");
        } else {
            countDown(n-1);            
            System.out.println(n);
        }
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        return n*factorial(n-1);
    }

    public static int fibonacci(int n) {
        if (n == 0) { //base cases
            return 1;
        }
        if (n == 1) { 
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    //sum of integers from 1 to n
    public static int sumUpToN(int n) {
        if (n == 1) {
            return 1;
        }

        return n + sumUpToN(n - 1);
    }

    //given a number n, return the sum of all the digits
    //123 -> 1 + 2 + 3 = 6
    public static int sumOfDigits(int n) {
        if (n / 10 == 0) { //single digit
            return n;
        }

        return n % 10 + sumOfDigits(n / 10);
    }

    //abcd -> reverse(bcd) + a
    public static String reverse(String s) {
        if (s.length() <= 1) {
            return s;
        }

        return reverse(s.substring(1)) + s.charAt(0);
    }

    //isPalindrome -> abba
    public static boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        } else {
            return s.charAt(0) == s.charAt(s.length() - 1) && isPalindrome(s.substring(1, s.length() - 1));
        }
    }

    //all substrings are subsequences, but not all subsequences are substrings
    public static boolean isSubsequence(String s1, String s2) {
        if (s1.equals("")) {
            return true;
        }

        if (s2.equals("") && !s1.equals("")) {
            return false;
        }

        int index;

        return ((index = s2.indexOf(s1.charAt(0))) != -1) && isSubsequence(s1.substring(1), s2.substring(index + 1));
    }

    public static String noX(String s, char x) {
        if (s.length() == 0) {
            return "";
        }

        if (s.charAt(0) == x) {
            return noX(s.substring(1), x);
        } else {
            return s.substring(0, 1) + noX(s.substring(1), x);
        }
    }

    public static void main(String[] args) {
        // countDown(10);
        // System.out.println(factorial(10));
        //System.out.println(sumUpToN(100));
        // System.out.println(sumOfDigits(123));
        System.out.println(reverse("abcdef"));
        // System.out.println(isPalindrome("abbba"));
        // System.out.println(isSubsequence("ace", "fabcde"));
        // System.out.println(noX("axdbcsxf", 'x'));
    }
}
