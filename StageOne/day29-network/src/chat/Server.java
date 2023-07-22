package chat;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * ClassName: Server
 * Package: chat
 * Description:
 */
public class Server {
    public static void main(String[] args){
        try(
                ServerSocket serverSocket = new ServerSocket();
        ){
            serverSocket.bind(new InetSocketAddress(8888));
            System.out.println("聊天系统后端已启动，在8888端口");
            while (true){
                Socket socket = serverSocket.accept();
                new ServerThread(socket).start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
