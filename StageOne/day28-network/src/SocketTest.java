import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 ServerSocket、Socket类的基本使用, 并基于 TPC协议 实现客户端与服务端的通信
 */
public class SocketTest {
    /**
     * 服务端
     * 通过 ServerSocket 获取一个端口，并监听客户端的请求
     */
    @Test
    public void serverTest() throws IOException {
        // 创建ServerSocket
        ServerSocket serverSocket = new ServerSocket();
        // 绑定在某一个端口上
        serverSocket.bind(new InetSocketAddress(8888));
        // 监听在这个端口，获取 Socket
        Socket socket = serverSocket.accept();

        // 接收客户端的输出流
        InputStream inputStream = socket.getInputStream();
        int len;
        byte[] buffer = new byte[1024];
        String value = "";
        while((len = inputStream.read(buffer)) != -1){
            value += new String(buffer, 0, len);
        }
        System.out.println(value); // hello server!
        inputStream.close();
        socket.close();
    }

    /**
     * 客户端
     * 通过 Socket 建立与服务端的链接
     */
    @Test
    public void clientTest() throws IOException {
        // 创建Socket
        Socket socket = new Socket();
        /*
        使用这个socket进行与客户端的连接
         */
        socket.connect(new InetSocketAddress(InetAddress.getLoopbackAddress(), 8888));

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello server!".getBytes());

        inputStream.close();
        outputStream.close();
        // 关闭 socket，防止报错
        socket.close();
    }
}
