/**
 * 学习使用 String 的api
 * 实现一个查找字符串出现次数的功能
 */
public class Test2 {
    public static void main(String[] args) {
        String str = "Hello World abc Hello";
        Test2 test2 = new Test2();
        int count = test2.wordCount(str, "HeLlo");
        System.out.println(count);

    }

    public int wordCount(String article, String word){
        //1、先把文章打散成数组
        String[] words = article.split(" ");
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            if(words[i].equalsIgnoreCase(word)){
                res++;
            }
        }
        return  res;
    }

}
