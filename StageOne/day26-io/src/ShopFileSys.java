import com.sun.xml.internal.bind.v2.model.core.ID;
import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * 商品列表文件管理系统
 */
public class ShopFileSys {
    public static Scanner scanner = new Scanner(System.in);
    public static String PATH = "D:\\gh_09\\Desktop\\b\\shopList.txt";

    public static void main(String[] args) {
        while (true){
            System.out.print("请选择功能(1、插入新商品 2、删除商品 3、修改商品 4、查找一个商品 5、查找所有商品 6、退出):");
            int function = scanner.nextInt();
            switch (function){
                case 1:
                    insert();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    findOne();
                    break;
                case 5:
                    findAll();
                    break;
                default:
                    return;
            }
        }
    }

    public static void insert(){
        // 防止id重复
        Integer id = null;
        boolean flag = true;
        List<Goods> shopList = findAllGoods();
        while (flag) {
            System.out.print("请输入商品编号: ");
            id = scanner.nextInt();
            final Integer ID = id;
            Optional<Goods> optionalGoods = shopList.stream().filter(g -> g.getId() == ID).findFirst();
            flag = optionalGoods.isPresent();
            if(flag){
                System.out.println("商品编号已存在!");
            }
        }
        System.out.print("请输入商品名称: ");
        String name = scanner.next();
        System.out.print("请输入商品价格: ");
        double price = scanner.nextDouble();
        List<Goods> goodsList = Arrays.asList(new Goods(id, name, price));
        writeShopList(goodsList, true);
    }

    public static void delete(){
        // 输入商品id
        System.out.print("请输入要删除的商品编号: ");
        int id = scanner.nextInt();
        // 内存中删除对应的商品
        List<Goods> shopList = findAllGoods();
        Iterator<Goods> iterator = shopList.iterator();
        while(iterator.hasNext()){
            Goods goods = iterator.next();
            if(goods.getId() == id){
                iterator.remove();
            }
        }
        // 刷入磁盘
        writeShopList(shopList, false);

    }
    public static void update(){
        // 输入商品id
        System.out.print("请输入要修改的商品编号: ");
        int id = scanner.nextInt();
        System.out.print("请输入新的商品名称: ");
        String name = scanner.next();
        System.out.print("请输入新的商品价格: ");
        double price = scanner.nextDouble();
        // 内存中删除对应的商品
        List<Goods> shopList = findAllGoods();
        Iterator<Goods> iterator = shopList.iterator();
        while(iterator.hasNext()){
            Goods goods = iterator.next();
            if(goods.getId() == id){
                goods.setName(name);
                goods.setPrice(price);
            }
        }
        // 刷入磁盘
        writeShopList(shopList, false);
    }

    /**
     根据商品 id 查询商品信息
     */
    public static void findOne(){
        System.out.print("请输入商品编号:");
        int id = scanner.nextInt();
        List<Goods> shopList = findAllGoods();
        // 函数式编程找到对应id的商品
        Optional<Goods> totalGood = shopList.stream().filter(g -> g.getId() == id).findFirst();
        if(totalGood.isPresent()){
            Goods goods = totalGood.get();
            System.out.println(goods.getId() + " " + goods.getName() + " " + goods.getPrice());
        }else {
            System.out.println("商品不存在!");
        }

    }

    /**
     查找所有的商品，直接复用 findAllGoods() 得到商品集合
     */
    public static void findAll(){
        List<Goods> shopList = findAllGoods();
        // 直接遍历打印商品信息
        for(Goods goodsitem : shopList){
            System.out.println(goodsitem.getId() + " " + goodsitem.getName() + " " + goodsitem.getPrice());
        }
    }

    /**
     * 读入商品列表文件 内有所的商品字符字段，转化为商品集合，最终返回包含所有商品的集合
     */
    /**
     *
     * @return
     */
    private static List<Goods> findAllGoods(){
        Reader reader = null;
        BufferedReader bufferedReader = null;
        List<Goods> shopList = new ArrayList<>();
        try{
            reader = new FileReader(PATH);
            bufferedReader = new BufferedReader(reader);
            String goodInfo;
            while ((goodInfo = bufferedReader.readLine()) != null){
                // 把被读取的当行商品文本转化为商品数组
                String[] goodInfos = goodInfo.split(" ");
                // 创建商品对象
                Goods goodItem = new Goods(Integer.parseInt(goodInfos[0]), goodInfos[1], Double.parseDouble(goodInfos[2]));
                // 加载到集合中
                shopList.add(goodItem);
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return shopList;
    }

    /**
     * 把 shopList 通过流输出到商品列表文件中
     * @param shopList
     *        被写入目标文件的商品集合
     * @param append
     *        如果为 false，则表示输出流以 ”覆盖“ 的方式写入到目标文件；
     *        如果为 true，则表示输出流以 ”追加“ 的方式写入到目标文件
     */
    private static void writeShopList(List<Goods> shopList, boolean append){
        try(
            Writer writer = new FileWriter(PATH,append);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
        ){
            for(Goods goods : shopList){
                bufferedWriter.write(goods.getId() + " " + goods.getName() + " " + goods.getPrice());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Test
    public void test(){

    }
    private static class Goods{
        private int id;
        private String name;
        private double price;
        public Goods() {
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public double getPrice() {
            return price;
        }
        public void setPrice(double price) {
            this.price = price;
        }
        public Goods(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }
}
