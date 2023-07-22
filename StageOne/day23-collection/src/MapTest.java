import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * HashMap 的使用
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap<String, User> hashMap = new HashMap<>();
        // put()
        hashMap.put("001x", new User("ZS", 18));
        hashMap.put("002x", new User("LS", 15));
        hashMap.put("003x", new User("WW", 19));
        hashMap.put("004x", new User("ZL", 23));
        System.out.println(hashMap);
        // {002x=User{name='LS', age=15}, 001x=User{name='ZS', age=18}, 004x=User{name='ZL', age=23}, 003x=User{name='WW', age=19}}

        // keySet()
        Set<String> strings = hashMap.keySet();
        System.out.println(strings); // [002x, 001x, 004x, 003x]
        // values()
        Collection<User> values = hashMap.values();
        System.out.println(values); // [User{name='LS', age=15}, User{name='ZS', age=18}, User{name='ZL', age=23}, User{name='WW', age=19}]

    }
}
