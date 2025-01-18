package CodingBat.Logic2;

public class LuckySum {
    
    public static void main(String[] args) {
        System.out.println(luckySum(13, 2, 13));
    }

    public static int luckySum(int a, int b, int c) {
        int[] nums = {a, b, c};
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 13) {
                sum += nums[i];
            } else {
                break;
            }
        }

        return sum;
    }
}
