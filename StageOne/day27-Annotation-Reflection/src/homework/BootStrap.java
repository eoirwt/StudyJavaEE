package homework;

import homework.context.ApplicationContext;
import homework.handler.SingletonHandler;
import homework.util.FileUtils;
import java.io.File;
import java.net.URL;
import java.util.List;
/**
 项目功能：
 本项目能够将 “指定目录” 下所有的单例类分别生成它们对应的实例，并把实例收集到容器里,
 那么在运行的环境中，就能直接重容器里获取你想要的单例实例

 -------------------------------------

 项目结构：
 homework.BootStrap -- 项目启动类
 util.FileUtils -- 文件路径处理工具类
 context.Application -- 容器类，维护一个上下文环境
 handler.SingletonHandler -- 反射处理类，将单例实例存储到容器中
 */
public class BootStrap {
    // 初始化
    static {
        // 通过当前线程获取 "类加载器"
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        // 通过类加载器获取 "指定路径" 的 Url 实例
        URL resource = contextClassLoader.getResource("homework");
        // 通过 Url 实例获取当前启动类的 文件路径, 是unix系统的路径表达方式
        String fileAbsolutePath = resource.getFile(); // "/D:/.../StudyJavaEE/StageOne/out/production/day27-Annotation-Reflection/homework"
        // 获取全限定名
        List<String> classNames = FileUtils.getAllClassName(new File(fileAbsolutePath));
        // 存储单例实例
        SingletonHandler.handler(classNames);
    }
    public static void main(String[] args) {
        // 所有单例实例已经被存储，接下来可以直接获取并使用
        Dog dogSingleton = ApplicationContext.getSingleton(Dog.class);
        System.out.println(dogSingleton);
    }

}
