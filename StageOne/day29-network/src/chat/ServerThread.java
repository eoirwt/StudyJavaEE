package chat;

import chat.Message;
import chat.constant.Constant;
import chat.constant.MessageType;
import chat.util.MsgUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.Optional;

/**
 * @ClassName: chat.ServerThread
 * @Package: PACKAGE_NAME
 * @Description:
 */
public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread() {
    }

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
        ){
            while (true){
                Optional<Message> message = MsgUtils.readMsg(inputStream);
                if(message.isPresent()){
                    Message msg = message.get();
                    switch (msg.getType()){
                        case MessageType.LOGIN:
                            loginHandler(inputStream, outputStream, msg, socket);
                            break;
                        case MessageType.TO_SERVER:
                            sendToClient(inputStream, outputStream, msg);
                            break;
                        case MessageType.TO_FRIEND:
                            sendToTarget(msg);
                            break;
                        case MessageType.TO_ALL:
                            sendToAll(msg);
                            break;
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void sendToAll(Message message) {
        for(Map.Entry<String, Socket> entry : Constant.USER_TABLE.entrySet()){
            try {
                MsgUtils.writeMsg(entry.getValue().getOutputStream(), message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendToTarget(Message message) {
        Socket socket = Constant.USER_TABLE.get(message.getFriendUserName());
        try {
            MsgUtils.writeMsg(socket.getOutputStream(), message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void sendToClient(InputStream inputStream, OutputStream outputStream, Message message) {
        System.out.println(message.getUsername() + "：" + message.getContent());
        MsgUtils.writeMsg(outputStream,new Message(MessageType.FROM_SERVER, Constant.OK, Constant.SERVER_NAME));
    }

    private void loginHandler(InputStream inputStream, OutputStream outputStream, Message message, Socket socket) {
        if(Constant.USER_TABLE.containsKey(message.getUsername())){
            MsgUtils.writeMsg(outputStream, new Message(MessageType.FROM_SERVER, "账户已经登录，请重新登录", Constant.SERVER_NAME));
            return;
        }
        if(
                message.getUsername() == null
                    || !Constant.DEFAULT_PASSWORD.equals(message.getPassword())
        ){
            // 登录失败
            System.out.println(message.getUsername() + " 登录失败");
            MsgUtils.writeMsg(outputStream, new Message(MessageType.FROM_SERVER, Constant.FAIL, Constant.SERVER_NAME));
//            continue;
        }else {
            // 登录成功
            System.out.println(message.getUsername() + " 登录成功");
            Constant.USER_TABLE.put(message.getUsername(), socket);
            MsgUtils.writeMsg(outputStream, new Message(MessageType.FROM_SERVER, Constant.SUCCESS, Constant.SERVER_NAME));
        }
    }

}
