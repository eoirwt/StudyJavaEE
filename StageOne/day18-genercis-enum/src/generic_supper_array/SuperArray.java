package generic_supper_array;

/**
 * 学习 泛型 ，改造超级数组
 * 具体改造内容：
 * 1. 原来的 Integer[] array 改为 Object[] array, 使得超级数组可以存储任意结构的数据
 * 2. 为超级数组指定泛型, 那么再实例话一个超级数组时就可以明确这个超级数组只能存储指定类型的值
 */
public class SuperArray<T> {
    // 维护一个Integer数组 array
//    private Integer[] array;
    private Object[] array;
    // 数组的长度 size
    private int size;
    // 数组当前的容量 capacity
    private int capacity;

    public SuperArray() {
        this(10);
    }
    public SuperArray(int capacity){
        this.capacity = capacity;
        this.array = new Object[this.capacity];
    }
    public int getSize(){
        return this.size;
    }

    /* 检查传入的下标是否越界
     *  inspect: (v)检查
     * */
    private boolean inspectIndex(int index){
        if(index < 0 || index >= size) {
            return true;
        }
        return false;
    }
    // 遍历打印 array
    private String printArray(){
        String arrayString = "[";
        for (int i = 0; i < size; i++) {
            arrayString += (array[i].toString() + ",");
        }
        arrayString = arrayString.substring(0,arrayString.length() - 1);
        arrayString += "]";

        return arrayString;
    }
    /*数组扩容
     * dilatation : (v) 扩容
     */
    private void arrayDilatation(int needCapacity){
        if(needCapacity > capacity){
            capacity = capacity + (capacity >> 1);// capacity>>2 = capacitu/2
            Object[] newArray = new Object[capacity];
            // 把 array 复制到 newArray
//            System.arraycopy(array,0,newArray,0,array.length);
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }
    // 默认添加元素(尾插)
    public void addToTail(T data){
        arrayDilatation(size + 1);
        array[size++] = data;
        System.out.println("\""+data+"\"添加成功, 当前array值为： " + printArray());
    }
    // 头插
    public void addToHead(T data){add(0,data);}
    // 添加指定下标元素
    public void add(int index, T data){
        if(index >= size) {
            addToTail(data);
        }else {
            arrayDilatation(size + 1);
            if(index < 0) index = 0;
            for (int i = size; i > index ; i--) {
                array[i] = array[i - 1];
            }
            array[index] = data;
            size++;
            System.out.println("添加成功, 当前array值为： " + printArray());
        }
    }
    // 删除指定下标的元素
    public void delete(int index){
        if(inspectIndex(index)){
            System.out.println("下标超出数组范围，删除失败!");
            return;
        }else {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[size - 1] = null;
            size--;
            System.out.println("下标 "+index+" 元素删除成功, 当前array值为： "+ printArray());
        }
    }
    /*
    修改指定下标元素
    modification: (v)修改
     */
    public void modification(int index, T data){
        if(inspectIndex(index)){
            System.out.println("下标超出数组范围，修改失败");
            return;
        }else {
            array[index] = data;
            System.out.println("下标 "+index+" 元素修改成功, 当前array值为： "+ printArray());
        }
    }
    /*
    查寻指定下标元素
    seek:(v)查寻
     */
    public T seek(int index){
        if(inspectIndex(index)){
            System.out.println("下标超出数组范围，查寻失败");
            return null;
        }else{
            System.out.println("查询成功, 下标 "+index+" 的元素值为: "+array[index].toString());
            return (T)array[index];
        }
    }

    // 数组排序
    // 数组为 Object 类型， 无法排序
    /*public Integer[] arraySort(){
        Integer[] newArray = array;
        int temp;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if(newArray[j].intValue() > newArray[j+1].intValue()){
                    temp = newArray[j];
                    newArray[j] = newArray[j+1];
                    newArray[j+1] = temp;
                }
            }
        }
        return newArray;
    }*/

}
