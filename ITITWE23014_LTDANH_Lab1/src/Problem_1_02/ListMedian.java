import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListMedian {
    public static void main(String[] args) throws Exception {
        List<Integer> BaseList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int iteration = 1;
        int result = 0;
        while (true) {
            try {
                System.out.print("input of " + (iteration) + "(Press other chars to stop):");
                int InputNum = sc.nextInt();
                result += InputNum;
                BaseList.add(InputNum);
            } catch (Exception e) {
                break;
            }
        }
        int length = BaseList.toArray().length;
        double median = result / (length);
        System.out.println(median);
    }
}
