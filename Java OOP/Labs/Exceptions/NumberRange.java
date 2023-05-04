import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class NumberRange {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] range = scan.nextLine().split(" ");
        int lowerBound = parseInt(range[0]);
        int upperBound = parseInt(range[1]);
        System.out.printf("Range: [%d...%d]\n", lowerBound, upperBound);

        int number = 0;
        boolean isValidNumber = false;
        while (!isValidNumber) {
            String inputData = scan.nextLine();
            try {
                number = parseNumberInRange(inputData, lowerBound, upperBound);
                isValidNumber = true;
            } catch (RuntimeException e) {
                System.out.println("Invalid number: " + inputData);
            }
        }

        System.out.println("Valid number: " + number);
    }

    private static int parseNumberInRange(String input, int startBound, int endBound) {
        int num = Integer.parseInt(input);

        if (num < startBound || num > endBound) {
            throw new RuntimeException("Number is out of bounds: " + startBound + ", " + endBound);
        }

        return num;
    }
}