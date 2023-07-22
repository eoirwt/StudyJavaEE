package chat.util;

import chat.Message;
import chat.constant.MessageType;

import java.io.*;
import java.util.Optional;

/**
 * @ClassName: MsgUtils
 * @Package: chat.util
 * @Description:
 */
public class MsgUtils {
    /**
     * 从输入流中读取消息数据
     * @param inputStream 将要读取数据的目标输入流
     * @return 两种可能的值: <br>
     *         1: Message 类型的 Optional 对象 <br>
     *         2: 值为 null 的 Optional 对象
     */
    public static Optional<Message> readMsg(InputStream inputStream){
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
            return Optional.ofNullable((Message)objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * 向输出流中写入消息数据
     * @param outputStream
     *          将要写入数据的目标输入流
     * @param message
     *          具体的消息数据
     */
    public static void writeMsg(OutputStream outputStream, Message message){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
