import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        System.out.println(fact(num));
    }

    private static int fact(int num) {
        if (num - 1 == 0) {
            return num;
        }
        return num * fact(num - 1);
    }

}
