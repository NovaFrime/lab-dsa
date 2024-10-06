import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinGap {
    public static void main(String[] args) throws Exception {
        int[] intArray = new int[] { 1, 3, 6, 7, 12 };
        int result=0;
        for (int i = 0; i < intArray.length - 1; i++) {
            result= Math.abs(intArray[i]-intArray[i+1]);
            System.out.println(result);
        }
    }
}
