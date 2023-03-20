package blackBoxInteger;

import java.lang.reflect.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scan = new Scanner(System.in);
        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = blackBoxIntClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        String command = scan.nextLine();
        while (!command.equals("END")) {
            String methodName = command.split("_")[0];
            int parameter = Integer.parseInt(command.split("_")[1]);

            Method method = blackBoxIntClass.getDeclaredMethod(methodName, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, parameter);

            Field field = blackBoxIntClass.getDeclaredField("innerValue");
            field.setAccessible(true);
            int currentValue = field.getInt(blackBoxInt);
            System.out.println(currentValue);

            command = scan.nextLine();
        }
    }
}
