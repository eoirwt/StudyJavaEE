import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * InetAddress 类的基本使用
 */
public class InetAddressTest {
    @Test
    public void test() throws UnknownHostException {
        // 获取回环地址
        InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
        System.out.println(loopbackAddress); // localhost/127.0.0.1

        // 获取指定 IP 的 InetAddress 对象
        byte[] bytes = {127,0,0,1};
        InetAddress byAddress1 = InetAddress.getByAddress(bytes);
        System.out.println(byAddress1); // /127.0.0.1

        // 获取指定 域名 的 InetAddress 对象
        InetAddress byAddress2 = InetAddress.getByName("www.baidu.com");
        System.out.println(byAddress2); // www.baidu.com/120.232.145.185

        // 获取指定 主机名 和 IP 的 InetAddress 对象
        InetAddress byAddress3 = InetAddress.getByAddress("DESKTOP-S2VQ6E3", bytes);
        System.out.println(byAddress3); // DESKTOP-S2VQ6E3/127.0.0.1

        // 获取指定 域名 或 主机名 的多个 InetAddress 对象
        InetAddress[] allByName1 = InetAddress.getAllByName("www.baidu.com");
        System.out.println(Arrays.toString(allByName1)); // [www.baidu.com/120.232.145.144, www.baidu.com/120.232.145.185]

        InetAddress[] allByName2 = InetAddress.getAllByName("DESKTOP-S2VQ6E3");
        System.out.println(Arrays.toString(allByName2)); // [DESKTOP-S2VQ6E3/192.168.101.9, DESKTOP-S2VQ6E3/fe80:0:0:0:3145:b384:104c:97b5%17]

    }
}
