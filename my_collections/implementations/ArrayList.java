package my_collections.implementations;

import my_collections.List;
import java.util.Arrays;

public class ArrayList<T> implements List<T> {
    private static final int INITIAL_SIZE = 16;
    private Object[] elements;
    private int size = 0;

    public ArrayList() {
        this(INITIAL_SIZE);
    }

    public ArrayList(int initialSize) {
        elements = new Object[initialSize];
    }

    private void increaseCapasityIfNessesary() {
        if (size >= elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    @Override
    public void add(T element) {
        increaseCapasityIfNessesary();
        elements[size++] = element;
    }

    @Override
    public void add(T element, int index) {
        if ((index > size) || (index < 0)) throw new ArrayIndexOutOfBoundsException();
        increaseCapasityIfNessesary();
        for(int i = size; i > index; i--){
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }

    @Override
    public T get(int i) {
        return (T) elements[i];
    }

    @Override
    public T remove(int index) {
        if (size == 0) throw new IllegalStateException();
        if ((index > size) || (index < 0)) throw new ArrayIndexOutOfBoundsException();
        Object result = elements[index];
        for(int i = index + 1; i < size; i++){
            elements[i - 1] = elements[i];
        }
        elements[size - 1] = null;
        size--;
        return (T) result;
    }

    @Override
    public T removeFirst(T element) {
        int index = indexOf(element);
        if (index == -1) return null;

        Object result = elements[index];
        for(int i = index + 1; i <= size; i++){
            elements[i - 1] = elements[i];
        }
        elements[size - 1] = null;
        size--;
        return (T) result;
    }

    @Override
    public T removeLast(T element) {
        int index = lastIndexOf(element);
        if (index == -1) return null;

        Object result = elements[index];
        for(int i = index + 1; i <= size; i++){
            elements[i - 1] = elements[i];
        }
        elements[size - 1] = null;
        size--;
        return (T) result;
    }

    @Override
    public List<T> removeAll(T element) {
        List<T> result = new ArrayList<>();
        Object[] tempArr = new Object[elements.length];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (!elements[i].equals(element)) {
                tempArr[j++] = elements[i];
            } else {
                result.add((T) elements[i]);
            }
        }
        size = j;
        elements = tempArr;
        return result;
    }

    @Override
    public int indexOf(T element) {
        int i = 0;
        while (i < size) {
            if (elements[i++].equals(element)) break;
        }
        return i == size ? -1 : i - 1;
    }

    @Override
    public int lastIndexOf(T element) {
        int i = size - 1;
        while (i >= 0) {
            if (elements[i--].equals(element)) break;
        }
        return i < 0 ? -1 : i + 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T[] toArray() {
        return (T[]) Arrays.copyOfRange(elements, 0, size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArrayList<?> arrayList = (ArrayList<?>) o;

        if (size != arrayList.size) return false;
        if ((elements.length < size) || (arrayList.elements.length < arrayList.size)) return false;

        for (int i = 0; i < size; i++) {
            if (elements[i] != arrayList.elements[i]) return false;
        }

        return true;
    }

    public int getCapacity() {
        return elements.length;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(elements);
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                ", capacity=" + getCapacity() +
                '}';
    }
}
