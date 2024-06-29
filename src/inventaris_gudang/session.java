package inventaris_gudang;

public class session {

    private static int id;
    private static String username;
    private static String email;
    private static int level;

    public static int get_id() {

        return id;

    }

    public static void set_id(int id) {

        session.id = id;

    }

    public static int get_level() {

        return level;

    }

    public static void set_level(int level) {

        session.level = level;

    }

    public static String get_username() {

        return username;

    }

    public static void set_username(String username) {

        session.username = username;
        
    }

    public static String get_email() {

        return email;

    }

    public static void set_email(String email) {

        session.email = email;

    }

}