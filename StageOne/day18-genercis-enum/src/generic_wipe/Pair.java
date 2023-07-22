package generic_wipe;

/**
 *
 */
public class Pair<T> {
    private T value;
    public T getValue(){
        return this.value;
    }
    public void setValue(T t){
        this.value = t;
    }
}
// 编译时擦除泛型，就相当于
/*
class Pair {
    private Object value;
    public Object getValue() {
        return value;
    }
    public void setValue(Object  value) {
        this.value = value;
    }
}
 */