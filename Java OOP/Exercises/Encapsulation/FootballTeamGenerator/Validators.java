package FootballTeamGenerator;

public class Validators {
    public static void validateName (String name) {
        if (name == null || name.trim().isEmpty() || name.equals(" ")) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }
}
