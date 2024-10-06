import java.lang.Math;

public class ArrayToNum {
    public static void main(String[] args) throws Exception {
        int[] digits = { 2, 0, 1, 8, 0, 0, 5 };
        int result = 0;
        int pow = digits.length - 1;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 0) {
                result += digits[i] * Math.pow(10, pow);
                System.out.println(result);
            }
            pow--;

        }
    }
}
