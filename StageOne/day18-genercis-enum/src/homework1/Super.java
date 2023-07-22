package homework1;

/**
 *
 */
public interface Super<T> {

    void add(int index, T data);

    void delete(int index);

    void modification(int index, T data);

    T seek(int index);

    int getSize();
}
