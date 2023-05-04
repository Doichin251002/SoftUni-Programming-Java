package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;
		Field[] fields = richSoilLandClass.getDeclaredFields();

		String command = scan.nextLine();
		while (!command.equals("HARVEST")) {
			for (Field field : fields) {
				String modifier = getAccessModifierName(field.getModifiers());
				if (command.equals("all") || command.equals(modifier)) {
					System.out.printf("%s %s %s\n", modifier, field.getType().getSimpleName(), field.getName());
				}
			}
			command = scan.nextLine();
		}
	}

	private static String getAccessModifierName(int modifiers) {
		String modifierName;
		if (Modifier.isPrivate(modifiers)) {
			modifierName = "private";
		} else if (Modifier.isProtected(modifiers)) {
			modifierName = "protected";
		} else if (Modifier.isPublic(modifiers)) {
			modifierName = "public";
		} else {
			throw new IllegalArgumentException("Expected to be either private, protected or public!");
		}
		return modifierName;
	}
}
