import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * UDP的实现
 * 实现一个客户端与服务端基于 UDP 协议特性的通讯
 */
public class UDPTest {
    // 发送端
    @Test
    public void udpClientTest() throws IOException {
        // 创建socket，可以在构造器内指定端口，如果不指定会随机开一个端口，一般我们客户端都会选择随机端口
        DatagramSocket socket = new DatagramSocket();
        String info = "hello UDP!";
        // 构建一个数据包
        DatagramPacket packet = new DatagramPacket(
                info.getBytes(), // 字节数组，具体包含的数据
                0,// 字节数组开始位置
                info.getBytes().length, // 字节数组开始位置
                InetAddress.getLoopbackAddress(), // 目标 IP
                8888 // 端口
        );
        // 直接放松，方法会阻塞
        socket.send(packet);
        socket.close();
        // 连续发送
        /*
        while (true) {
            socket.send(packet);
        }
        */
    }

    // 接收端
    @Test
    public void udpServerTest() throws IOException {
        // 指定目标端口，创建 Socket
        DatagramSocket socket = new DatagramSocket(8888);
        byte[] buffer = new byte[1024];
        // 数据包
        DatagramPacket packet = new DatagramPacket(
                buffer,
                0,
                buffer.length
        );
        // 接受，阻塞方法
        socket.receive(packet);
        // 保存接受内容
        String result = new String(buffer, 0,
                packet.getLength() // 指定字节数组有效读取末位，否则出现乱码
        );
        System.out.println("result = " + result); // result = hello UDP!
        socket.close();

        // 当发送端反复发送，这里要反复接受
        /*
        while (true) {
            socket.receive(packet);
            String result = new String(buffer, 0, packet.getLength());
            System.out.println("result = " + result);
        }
        */
    }
}
