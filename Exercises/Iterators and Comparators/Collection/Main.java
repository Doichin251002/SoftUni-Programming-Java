package Collection;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        ListyIterator<String> listyIterator = new ListyIterator<String>();

        while (!command.equals("END")) {
            String [] data = command.split("\\s+");

            switch (data[0]) {
                case "Create":
                    if (data.length > 1) {
                        listyIterator = new ListyIterator<>(Arrays.copyOfRange(data, 1, data.length));
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "PrintAll":
                    listyIterator.forEach(e -> System.out.print(e + " "));
                    System.out.println();
            }
            command = scan.nextLine();
        }
    }
}