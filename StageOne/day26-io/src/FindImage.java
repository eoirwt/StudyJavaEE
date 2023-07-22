import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;

/**
 练习案例：找出 "D:\code\image" 文件夹下的所有的图片
 */
public class FindImage {
    @Test
    public void findAllPicInFloder(){
        String goalFloderPathName = "D:\\code\\image";
        toFind(goalFloderPathName);
    }
    public static void toFind(String pathName){
        // 1. 获取当前文件夹
        File parentFolder = new File(pathName);
        // 2. 过滤文件夹并获取文件列表，使当前文件夹只包含子文件夹或图片文件
        File[] listFiles = parentFolder.listFiles(new FilenameFilter() {
            /**
             @param dir:
             它表示当前被遍历的 “父文件夹”.
             @param name:
             它表是每一个子文件或子文件夹的名字.
             */
            @Override
            public boolean accept(File dir, String name) {
                File file = new File(dir, name);
                return file.isDirectory() || name.contains("png") || name.contains("jpeg") || name.contains("jpg");
            }
        });
        // 3. 判断文件列表是否为空, 防止空指针异常
        if(listFiles == null || listFiles.length == 0) return;
        // 4. 遍历文件列表，进一步处理
        for (File file : listFiles) {
            if(file.isDirectory()){
                // 如果 file 是文件夹, 递归遍历
                toFind(file.getAbsolutePath());
            }else{
                // 如果 file 是图片文件，就直接获取
                System.out.println(file.getName());
            }
        }
    }
}
