package foo;

import foo.domain.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunxiansong on 16/3/13.
 */
public class SimpleRepeatTask {
    public static void main(String[] args) {
        Map<Integer,User> map = new HashMap<Integer, User>();
        int count = 0;
        while (true){
            System.out.println(count);
            User user = new User("u"+count, count, "male", new Date());
            map.put(count++, user);
            if (count % 1000 == 0) {
                map.clear();
            }
        }
    }
}
