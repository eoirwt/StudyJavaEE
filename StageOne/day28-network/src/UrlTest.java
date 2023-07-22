import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 URL 类的基本使用
 */
public class UrlTest {
    /**
     使用 URL 类来获取网络资源并把资源保存到本地
     */
    @Test
    public void test1() throws IOException {
        URL url = new URL("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png");
        // 可以获取 url 相关信息
        System.out.println("url.getPath() = " + url.getPath()); // url.getPath() = /img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png
        System.out.println("url.getPort() = " + url.getPort()); // url.getPort() = -1
        System.out.println("url.getDefaultPort() = " + url.getDefaultPort()); // url.getDefaultPort() = 443
        System.out.println("url.getProtocol() = " + url.getProtocol()); // url.getProtocol() = https
        System.out.println("url.getHost() = " + url.getHost()); // url.getHost() = www.baidu.com
        System.out.println("url.getFile() = " + url.getFile()); // url.getFile() = /img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png

        // 访问网络资源
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        // 通过流操作，保存到本地
        OutputStream outputStream = new FileOutputStream("D:\\gh_09\\Desktop\\PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png");
        int len;
        byte[] buffer = new byte[1024];
        while((len = inputStream.read(buffer)) != -1){
            outputStream.write(buffer, 0 , len);
        }
    }

    /**
     * 使用 URL 访问本地资源
     * 完成本地资源的复制拷贝功能
     */
    @Test
    public void test2() throws IOException {
        URL url = new URL("File:///D:/gh_09/Desktop/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png");
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        OutputStream outputStream = new FileOutputStream("D:\\gh_09\\Desktop\\a\\PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png");
        int len;
        byte[] buffer = new byte[1024];
        while((len = inputStream.read(buffer)) != -1){
            outputStream.write(buffer, 0 , len);
        }
    }
}
