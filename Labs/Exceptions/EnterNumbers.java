import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnterNumbers {
    private static Scanner scan;

    public static class NumbersException extends RuntimeException {
        public NumbersException(String message, NumberFormatException cause) {
            super(message, cause);
        }

        public NumbersException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        int lowerBound = 1;
        int upperBound = 100;

        int enteredNumbers = 0;
        while (enteredNumbers < 10) {
            int next;
            try {
                next = readNumber(lowerBound, upperBound);
            } catch (NumbersException e) {
                System.out.println(e.getMessage());
                continue;
            }

            lowerBound = next;
            numbers.add(next);
            enteredNumbers++;
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
    }

    private static int readNumber(int lowerBound, int upperBound) {
        String input = scan.nextLine();
        int num;
        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumbersException("Invalid Number!", e);
        }

        if (num <= lowerBound || num >= upperBound) {
            throw new NumbersException("Your number is not in range " + lowerBound + " - " + upperBound + "!");
        }

        return num;
    }
}
