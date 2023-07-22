package chat.constant;

import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: Constant
 * @Package: chat.constant
 * @Description:
 */
public class Constant {
    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";
    public static final String SERVER_NAME = "server";
    public static final String OK = "ok";
    public static final String DEFAULT_PASSWORD = "123";
    public static final Map<String, Socket> USER_TABLE = new ConcurrentHashMap<>(8);
}
