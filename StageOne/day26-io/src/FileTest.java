import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * Java.io.File 文件类的基本使用
 */
public class FileTest {
    /**
     通过转义符表达文件路径
     */
    @Test
    public void filePathTest(){
//        String filePath = "D:\\Test";
        String filePath = "D:\\Test";
        System.out.println("learn java is \"difficult\",\nI can't holding to do it!");
    }

    /**
     创建 File 类实例
     */
    @Test
    public void creatFileTest(){
        String filePathName = "D:\\Test\\a.txt";
        String folderPathName = "D:\\Test";
        // 方式①
        File file1 = new File(filePathName);
        // 方式②
        File file2 = new File(folderPathName, "a.txt");
        // 方式③
        File folder = new File(folderPathName);
        File file3 = new File(folder, "a.txt");
    }

    /**
     使用 File 的一些方法与属性
     */
    @Test
    public void fileAPITest() throws IOException {
        File file = new File("D:\\Test\\a.txt");
        // 判断文件是否存在，如果存在就删除，否者创建
        if(!file.exists()){
            boolean flag = file.createNewFile();
            System.out.println(flag?"创建成功!":"创建失败!");
            // 打印一些文件属性
            System.out.println("file.getName() = " + file.getName());
            System.out.println("file.isFile() = " + file.isFile());
            System.out.println("file.isDirectory() = " + file.isDirectory());
            System.out.println("file.canRead() = " + file.canRead());
            System.out.println("file.getParent() = " + file.getParent());
            System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
            System.out.println("file.getTotalSpace() = " + file.getTotalSpace());
            System.out.println("file.lastModified() = " + file.lastModified());
        }else{
            boolean flag = file.delete();
            System.out.println(flag?"删除成功!":"删除失败!");
        }
    }


}
