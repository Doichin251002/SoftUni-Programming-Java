import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(sum(numbers, 0));
    }

    private static int sum(int[] array, int index) {
        if (index == array.length - 1) {
            return array[index];
        }

        return array[index] + sum(array, index + 1);
    }
}