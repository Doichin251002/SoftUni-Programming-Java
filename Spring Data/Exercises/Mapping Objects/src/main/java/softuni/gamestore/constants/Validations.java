package softuni.gamestore.constants;

public enum Validations {
    ;
    public static final String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String PASSWORD_PATTERN = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$";
    public static final String GAME_TITLE_PATTERN = "^([A-Z]([a-zA-Z]){3,100})$";
    public static final String GAME_URL_PATTERN = "^(http|https)?:(\\/{2})(\\S+)$";
}
