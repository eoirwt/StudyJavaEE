package chat;

import chat.constant.Constant;
import chat.constant.MessageType;
import chat.util.MsgUtils;
import chat.util.ScannerUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Optional;

/**
 * @ClassName: Client
 * @Package: chat
 * @Description:
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        // 链接服务器
        socket.connect(new InetSocketAddress(8888));
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        // 发消息
        String username = null;
        while(true){
            if(username == null){
                username = login(outputStream, inputStream);
            }else {
                printOrder();
                String input = ScannerUtil.input();
                switch (Integer.parseInt(input)){
                    case MessageType.TO_SERVER:
                        sendToServer(username, outputStream, inputStream);
                        break;
                    case MessageType.TO_FRIEND:
                        sendToFriend(username, outputStream, inputStream);
                        break;
                    case MessageType.TO_ALL:
                        sendToAll(username, outputStream, inputStream);
                        break;
                    case MessageType.RECEIVER:
                        receiveMsg(username, outputStream, inputStream);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private static void receiveMsg(String username, OutputStream outputStream, InputStream inputStream) {
        while (true){
            Optional<Message> message = MsgUtils.readMsg(inputStream);
            message.ifPresent(m -> System.out.println(m.getUsername()+ "：" + m.getContent()));
        }
    }

    private static void sendToAll(String username, OutputStream outputStream, InputStream inputStream) {
        boolean flag = true;
        while (flag){
            System.out.print(username + "：");
            String content = ScannerUtil.input();
            if("bye".equals(content)) flag = false;
            MsgUtils.writeMsg(
                    outputStream,
                    new Message(MessageType.TO_ALL, content, username)
            );
        }
    }

    private static void sendToFriend(String username, OutputStream outputStream, InputStream inputStream) {
        System.out.print("请输入好友名：");
        String friendName = ScannerUtil.input();
        boolean flag = true;
        while (flag){
            System.out.print(username + "：");
            String content = ScannerUtil.input();
            if("bye".equals(content)) flag = false;
            Message msg = new Message();
            msg.setType(MessageType.TO_FRIEND);
            msg.setContent(content);
            msg.setUsername(username);
            msg.setFriendUserName(friendName);
            MsgUtils.writeMsg(
                    outputStream,
                    msg
            );
            /*Optional<Message> message = MsgUtils.readMsg(inputStream);
            message.ifPresent(m -> {
                System.out.println(m.getUsername() + "：" + m.getContent());
            });*/
        }

    }

    private static void sendToServer(String username,   OutputStream outputStream, InputStream inputStream) {
        System.out.print(username + "：");
        String content = ScannerUtil.input();
        MsgUtils.writeMsg(
                outputStream,
                new Message(MessageType.TO_SERVER, content, username)
                );
        Optional<Message> message = MsgUtils.readMsg(inputStream);
        message.ifPresent(m -> {
            System.out.println(m.getUsername() + "：" + m.getContent());
        });
    }

    private static void printOrder(){
        System.out.println("请您选择功能:" +
                MessageType.TO_SERVER + "、给服务器发消息  " +
                MessageType.TO_FRIEND + "、给好友发消息 " +
                MessageType.TO_ALL + "、群发 " +
                MessageType.RECEIVER + "接收信息");
    }


    private static String login(OutputStream outputStream, InputStream inputStream) {
        System.out.println("请先登录");
        System.out.print("请输入用户名: ");
        String name = ScannerUtil.input();
        System.out.print("请输入密码: ");
        String pwd = ScannerUtil.input();
        // 发送登录消息
        MsgUtils.writeMsg(
                outputStream,
                new Message(name,pwd,MessageType.LOGIN)
        );
        // 接受登录结果
        Optional<Message> message = MsgUtils.readMsg(inputStream);
        message.ifPresent(m -> System.out.println(m.getContent()));
        // 登录成功
        if(message.isPresent() && Constant.SUCCESS.equals(message.get().getContent())){
            return name;
        }
        // 登录失败
        return null;
    }
}
