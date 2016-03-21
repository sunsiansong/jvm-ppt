package foo;

import foo.domain.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * java -Xms6m  -Xmx6m foo.OutOfMemoryErrorDemo
 * java -Xms6m  -Xmx12m foo.OutOfMemoryErrorDemo
 * <p/>
 * compare ok and error
 */
public class OutOfMemoryErrorDemo {
    private static final Map<Integer, User> USER_MAP = new HashMap<Integer, User>();

    public static void main(String[] args) {
        if (args.length == 0 || args[0].equals("error")) {
            error();
        } else if (args.length > 0 && args[0].equals("ok")) {
            ok();
        }
    }

    private static void error() {
        int count = 0;
        while (true) {
            User u = new User("name", 18, "male", new Date());
            System.out.println(++count);
            USER_MAP.put(count, u);
        }
    }

    private static void ok() {
        int count = 0;
        while (true) {
            User u = new User("name", 18, "male", new Date());
            System.out.println(++count);
            USER_MAP.put(count, u);
            if (count % 1000 == 0) {
                USER_MAP.clear();
            }
        }
    }

}
