package chat;

import java.io.Serializable;

/**
 * ClassName: Message
 * Package: chat
 * Description:
 *
 * @Author guohong
 * @Create 2023/7/5 15:11
 * @Version 1.0
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 573422485053183246L; // 序列化版本号
    private Integer type; // 消息类别
    private String content; // 消息内容
    private String username; // 用户名
    private String password; // 密码
    private String friendUserName;


    public Message() {
    }

    public Message(Integer type, String content) {
        this.type = type;
        this.content = content;
    }

    public Message(Integer type, String content, String username){
        this.type = type;
        this.content = content;
        this.username = username;
    }

    public Message(String username, String password, Integer type){
        this.type = type;
        this.username = username;
        this.password = password;
    }

    public Message(Integer type, String content, String username, String password, String friendUserName){
        this.type = type;
        this.content = content;
        this.username = username;
        this.password = password;
        this.friendUserName = friendUserName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFriendUserName() {
        return friendUserName;
    }

    public void setFriendUserName(String friendUserName) {
        this.friendUserName = friendUserName;
    }

    @Override
    public String toString() {
        return "Message{" +
                "type=" + type +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", friendUserName='" + friendUserName + '\'' +
                '}';
    }
}
