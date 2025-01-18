package CodingBat.Warmup2;

public class Array123 {

    public static void main(String[] args) {}

    public boolean array123(int[] nums) {
        boolean sequence = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1 && (i + 2) < nums.length) {
                if (nums[i + 1] == 2) {
                    if (nums[i + 2] == 3) {
                        sequence = true;
                    } 
                }
            }
        }

        return sequence;
    }
}
