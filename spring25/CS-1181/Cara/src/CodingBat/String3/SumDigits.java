package CodingBat.String3;

import java.util.ArrayList;

public class SumDigits {
    
    public static void main(String[] args) {
        System.out.println(sumDigits("aa1bc2d3"));
    }

    public static int sumDigits(String str) {
        ArrayList<Integer> nums = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                nums.add(Character.getNumericValue(str.charAt(i)));
            }
        }

        System.out.println(nums);

        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }

        return sum;
    }
}
