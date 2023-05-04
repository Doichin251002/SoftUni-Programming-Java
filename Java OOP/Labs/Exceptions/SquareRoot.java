import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputData = scan.nextLine();
        try {
            int num = Integer.parseInt(inputData);
            double rooted = calculateSqrt(num);
            System.out.printf("%.2f\n", rooted);
        } catch (NumberFormatException e) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }
    }

    private static double calculateSqrt(double num) {
        double rooted = Math.sqrt(num);

        if (num <= 0) {
            throw new NumberFormatException("Cannot be less or equals than 0 like: " + num);
        }

        return rooted;
    }
}
