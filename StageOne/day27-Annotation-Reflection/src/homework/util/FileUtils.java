package homework.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 用来处理文件路径的工具类
 */
public class FileUtils {
    /**
     * 获取目标文件夹下的所有 class 的全类名
     * @param folder
     *        目标文件夹
     * @return 一个包含所有 class 全类名的 String 类型的集合
     */
    public static List<String> getAllClassName(File folder){
        List<String> classPaths = new ArrayList<>();
        /*
        System.out.println(file.getAbsolutePath());
        // "D:\gh_09\Desktop\StudyJavaEE\StageOne\out\production\day27-Annotation-Reflection\homework" (-> windows 文件路径表达形式)
        */
        getAllClassFilePath(folder.getAbsolutePath(), classPaths);
        /*
        for (String str : classPaths){
            System.out.println(str);
            // "D:\...\StudyJavaEE\StageOne\out\production\day27-Annotation-Reflection\homework\BootStrap.class"
            // ...
        }
        */
        // 通过流操作，把 class 文件绝对路径转化为全限定名，并收集在一个新的集合
        String rootPath = folder.getParent(); // "D:\gh_09\Desktop\StudyJavaEE\StageOne\out\production\day27-Annotation-Reflection"
        List<String> classNames = classPaths.stream().map(path -> {
            return path.replace(rootPath + "\\", "")
                    .replace(".class", "")
                    .replaceAll("\\\\", ".");
        }).collect(Collectors.toList());
        /*
        for (String str : classNames){
            System.out.println(str);
            // "homework.BootStrap"
            // ...
        }
        */
        return classNames;
    }
    /**
     * 获取目标文件夹下的所有 class 文件的绝对路径，并整合到传入的集合中
     * @param path
     *        目标文件夹的路径
     * @param classPaths
     *        用来存储所有 class 文件的绝对路径
     */
    public static void getAllClassFilePath(String path, List<String> classPaths){
        // 1. 获取当前文件夹
        File parentFolder = new File(path);
        // 2. 过滤文件夹并获取文件列表，使当前文件夹只包含子文件夹或 class 文件
        File[] listFiles = parentFolder.listFiles(new FilenameFilter() {
            /** accept()参数进一步说明
             @param dir:
             它表示当前被遍历的 “父文件夹”.
             @param name:
             它表是每一个子文件或子文件夹的名字.
             */
            @Override
            public boolean accept(File dir, String name) {
                File file = new File(dir, name);
                return file.isDirectory() || name.contains("class");
            }
        });
        // 3. 判断文件列表是否为空, 防止空指针异常
        if(listFiles == null || listFiles.length == 0) return;
        // 4. 遍历文件列表，进一步处理
        for (File file : listFiles) {
            if(file.isDirectory()){
                // 如果 file 是文件夹, 递归遍历
                getAllClassFilePath(file.getAbsolutePath(), classPaths);
            }else{
                // 如果 file 是 class 文件，就直接获取 绝对路径
                classPaths.add(file.getAbsolutePath());
            }
        }
    }
}
