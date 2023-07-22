import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
    IO流具体使用

 */
public class IOTest{
    @Test
    /**
     使用字节流 FileInputStream 的 read() 读取文件
     */
    public void readFile1() throws IOException {
        // 1.创建输入流, new FileInputStream 会抛出 java.io.FileNotFoundException
        InputStream inputStream = new FileInputStream(new File("D:\\Test\\test.txt"));
        /*
        2.读取文件
        read(): 读取一次，并只读取一字节的内容，返回 int 值，如果内容读取完，返回 -1；
        会抛出 java.io.IOException
         */
        byte res;
        byte[] arr = new byte[10];
        for (int i = 0; (res = (byte) inputStream.read()) != -1; i++) {
            arr[i] = res;
        }
        String val = new String(arr);
        System.out.println(val); // abcdefg
    }
    @Test
    /**
     使用字节流 FileInputStream 的 read(byte[] b) 读取文件
     */
    public void readFile2() throws IOException {
        // 基本步骤和 readFile1 类似，具体 read() 有所不同
        InputStream inputStream = new FileInputStream(new File("D:\\Test\\test.txt"));
        int len;
        byte[] b = new byte[3];
        /*
        read(byte[] b): 读取一次，每次读取 b.length 字节的内容，返回读取的个数
         */
        StringBuilder stringBuilder = new StringBuilder(); // 可变的字符序列
        while ((len = inputStream.read(b)) != -1){
            System.out.println("当次读取个数: " + len);
            System.out.println("当次读取的数据: " + Arrays.toString(b));
            String s = new String(b, 0, len);
            stringBuilder.append(s);
            /*
            当次读取个数: 3
            当次读取的数据: [97, 98, 99]
            当次读取个数: 3
            当次读取的数据: [100, 101, 102]
            当次读取个数: 1
            当次读取的数据: [103, 101, 102]
             */
        }
        System.out.println(stringBuilder); // abcdefg
    }

    @Test
    /**
     使用字节流 FileOutputStream 的 write 输出文件
     */
    public void writeFile() throws IOException {
        /*
        1. 创建输出流，
        可以传入路径，也可以传入一个 File，
        同时还可以传入一个布尔值：
            + (默认)true: 以追加内容的方式向目标文件输出
            + false: 以覆盖内容的方式向目标文件输出
         */
        // OutputStream fileOutputStreamo = new FileOutputStream("D:\\gh_09\\Desktop\\test.txt");
        OutputStream fileOutputStream = new FileOutputStream(new File("D:\\Test\\test.txt"));

        // 可传入 int ，int 会转化为字节，最终为 'a'
        fileOutputStream.write(97); // "a"

        // 可传入 byte[]
        byte[] bytes = {97, 98, 99, 100};
        fileOutputStream.write(bytes); // "a" + "abcd" = "aabcd"
        fileOutputStream.write(bytes, 0, 3); // "aabcd" + "abc" = "aabcdabc"
        // String -> byte[]
        fileOutputStream.write("content text".getBytes()); // "aabcdabc" + "content text" = "aabcdabccontent text"
    }

    @Test
    /**
     综合练习：结合上述的输入输出字节流，来完成复制拷贝文件这个功能
     */
    public void copyFile1() {

        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            // 模仿流创建失败，抛出异常的情况
            if((Math.random() * 10) > 5){
                throw new IOException();
            }
            // 建立输入、输出流 (videos.mp4|99.6 MB)
            inputStream = new FileInputStream("D:\\Test\\a\\videos.mp4");
            outputStream = new FileOutputStream("D:\\Test\\b\\videos.mp4");
            /*
            建立缓冲区，设置每次读取的单位为 1KB，
            具体每次读取多大合适？需要反复测试以及一些底层原理的考虑，并不是越大读取的越快
            */
            byte[] buffer = new byte[1024];
            int len;
            long start = System.currentTimeMillis();
            // 输入、输出流的读取和写入同时进行
            while ((len = inputStream.read(buffer)) > 0){
                outputStream.write(buffer,0,len);
            }

            // 目标文件挺大，如果我们每次只读取 1 字节，这样就太慢了
            /*
            int b;
            while ((b = inputStream.read()) > 0){
                outputStream.write(b);
            }
            */
            long end = System.currentTimeMillis();
            System.out.println("文件复制完成，用时：" + (end - start) + "毫秒"); // 文件复制完成，用时：572毫秒
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            // 任务结束，要关闭流，从而释放资源
            // 关闭流的操作 close() 可能引发 “NullPointerException”，所以需要判断非空
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    @Test
    /**
     利用 AutoCloseable 接口的特性来进一步优化 copyFile1()
     */
    public void optimizCopyFile1() {
        try(
            /* 应为 InputStream 和 outputStream 都间接实现了 AutoCloseable 接口
               所以，才能在这里定义 FileInputStream 和 FileOutputStream ，
               并且它们会在 try 代码块执行完毕后自动释放资源，无须再手动调用 close(), 从而简化了代码 */
                InputStream inputStream = new FileInputStream("D:\\Test\\a\\videos.mp4");
                OutputStream outputStream = new FileOutputStream("D:\\Test\\b\\videos.mp4")
        ){
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) > 0){
                outputStream.write(buffer,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Test
    /**
     使用字符流 FileReader、FileWriter 来完成文件的复制拷贝功能
     */
    public void copyFile2() {
        // 输入字符流
        Reader reader = null;
        // 输出字符流
        Writer writer = null;
        try{
            // 开始复制拷贝
            reader = new FileReader("D:\\gh_09\\Desktop\\a\\test.txt");
            writer = new FileWriter("D:\\gh_09\\Desktop\\b\\test.txt");

            // 设置 1 字符的缓存, 每次读取 1 字符
            /*int b;
            while ((b = reader.read()) != -1){
                writer.write(b);
            }*/

            // 设置 1024 字符的缓存, 每次读取 1024 字符
            int len;
            char[] buf = new char[1024];
            while ((len = reader.read(buf)) != -1){
                writer.write(buf,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            // 拷贝结束，关闭流
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(writer != null){
                try {
                    /* flush(): 它具有刷新流的作用，
                       !此时遇到的问题: 复制拷贝的过程已经正确执行结束，但目标文件尽然是空的!
                       但通过 flush 刷新以下输出流，即可解决问题 */
                    // writer.flush();
                    // 调用close()时，也自动调用了flush()
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    /**
     在 copyFile2() 的基础上，通过 处理流(BufferedReader\BufferedWriter) 作用在字符流中，来完成如下功能:
      1. 每次读入数据，都是 "一行行的读入“
      2. 每次写出数据，也都是 ”一行行的写出“
     */
    public void copyFile3() {
        Reader reader = null;
        Writer writer = null;
        // 创建处理流
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try{
            reader = new FileReader("D:\\gh_09\\Desktop\\a\\test.txt");
            writer = new FileWriter("D:\\gh_09\\Desktop\\b\\test.txt");
            // 加载处理流
            bufferedReader = new BufferedReader(reader);
            bufferedWriter = new BufferedWriter(writer);

            /* readLine(): 每次读入一行，并返回改行字符串,如果文件被读完，则返回 null */
            String content;
            while ((content = bufferedReader.readLine()) != null){
                System.out.println(content);
                /* bufferedWriter.write() 可直接写出字符串,非常方便*/
                bufferedWriter.write(content);
                bufferedWriter.newLine(); // 换行
                bufferedWriter.flush(); // 刷新
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            // 拷贝结束，关闭所有流
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedWriter != null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(writer != null){
                try {
                    /* flush(): 它具有刷新流的作用，
                       !此时遇到的问题: 复制拷贝的过程已经正确执行结束，但目标文件尽然是空的!
                       但通过 flush 刷新以下输出流，即可解决问题 */
                    // writer.flush();
                    // 调用close()时，也自动调用了flush()
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    /**
     对象序列话，
     把内存里的对象通过 ObjectOutputStream 写出到磁盘的文件中
     */
    public void objectOutPut() throws IOException {
        /*
        创建实例对象，该对象的类型必须实现 Serializable 接口，
        该接口什么都没有，只要声明实现了它，目标类的实例对象就能载入到流中正确读写，
        否者写出对象时会报错: java.io.NotSerializableException: IOTest$User
         */
        User user = new User(18, new Pet("Dog"), "xiaoming");
        OutputStream outputStream = new FileOutputStream("D:\\gh_09\\Desktop\\b\\test.txt");
        // ObjectOutputStream 是作用于其他流上的
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(user);
        objectOutputStream.close();
        outputStream.close();
    }
    static class User implements Serializable{
        // 明确序列化版本号
        private static final long serialVersionUID = 737804351199892820L;
        int age;
        // 引用类型的成员变量的类型也需要实现 Serializable 接口
        Pet pet;
        // 瞬态变量，不会被序列化
        transient String name;
        // 静态成员，实例方法都不会被序列化
        public User(int age, Pet pet, String name) {
            this.age = age;
            this.pet = pet;
            this.name = name;
        }
        @Override
        public String toString() {
            return "User{" +
                    "age=" + age +
                    ", pet=" + pet +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    static class Pet implements Serializable{
        private static final long serialVersionUID = 573422485053183246L;
        String name;
        public Pet(String name) {
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Pet{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    @Test
    /**
     对象反序列话，
     通过 ObjectInputStream 将被写出到磁盘的文件中的对象，读入到内存中
     */
    public void objectInPut() throws IOException, ClassNotFoundException {
        InputStream inputStream = new FileInputStream("D:\\gh_09\\Desktop\\b\\test.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        User user = (User)objectInputStream.readObject();
        System.out.println(user); // User{age=18, pet=Pet{name='Dog'}, name='null'}
    }

    @Test
    /**
     利用对象序列化与反序列化，
     实现对象的 ”深拷贝“ 功能
     */
    public void deepCopyTest() {
        User user1 = new User(18, new Pet("Dog"), "ZS");
        User user2 = deepCopy(user1);
        if (user2 != null){
            user2.pet.setName("Cat");
        }else {
            System.out.println("拷贝失败");
        }
        System.out.println(user1); // User{age=18, pet=Pet{name='Dog'}, name='ZS'}
        System.out.println(user2); // User{age=18, pet=Pet{name='Cat'}, name='null'}
    }
    public static <T> T deepCopy(T t){
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;
        try{
            // 将对象写到字节数组当中
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(t);
            // 获取字节数组
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            // 用输入流读出来
            byteArrayInputStream = new ByteArrayInputStream(byteArray);
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object object = objectInputStream.readObject();
            return (T)object;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }finally {
            if(byteArrayOutputStream != null){
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(objectOutputStream != null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(byteArrayInputStream != null){
                try {
                    byteArrayInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
