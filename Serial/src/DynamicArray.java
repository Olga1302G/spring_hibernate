import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class DynamicArray<T> {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public int getSize() {
        return size;
    }

    public void add(T el) {
        if (size == array.length) {
            array = increaseCapacity();
        }
        array[size] = el;
        size++;

    }

    private Object[] increaseCapacity() {
        Object[] temp = new Object[(array.length * 2)];
        System.arraycopy(array, 0, temp, 0, array.length);
        return temp;
    }

    public void remove(int index) {
        Object[] temp = array;
        array = new Object[temp.length - 1];
        Object value = temp[index];
        System.arraycopy(temp, 0, array, 0, index);
        System.arraycopy(temp, index + 1, array, index, temp.length - index - 1);
        size--;
    }

    public T get(int index) {
        return (T) array[index];
    }

}
